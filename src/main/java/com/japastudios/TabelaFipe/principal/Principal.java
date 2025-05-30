package com.japastudios.TabelaFipe.principal;

import com.japastudios.TabelaFipe.model.Dados;
import com.japastudios.TabelaFipe.model.DadosVeiculo;
import com.japastudios.TabelaFipe.model.Modelos;
import com.japastudios.TabelaFipe.service.ConsumeApi;
import com.japastudios.TabelaFipe.service.ConverteDados;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Principal {
    Scanner scanner = new Scanner(System.in);
    ConsumeApi consumeApi = new ConsumeApi();
    ConverteDados converteDados = new ConverteDados();

    static private String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";

    public void mostrarMenu(){
        System.out.println("Escolha o tipo de veiculo");
        var tipoVeiculo = scanner.nextLine();
        var jsonMarca = consumeApi.obterDados(ENDERECO+tipoVeiculo.toLowerCase()+"/marcas/");
//        System.out.println(json);

        List<Dados> dadosMarcas = converteDados.obterLista(jsonMarca, Dados.class);

        dadosMarcas.stream()
                        .sorted(Comparator.comparing(Dados::codigo))
                        .forEach(System.out::println);

        System.out.println("Digite o codigo da Marca desejada");
        var marca = scanner.nextLine();
        var jsonModelo = consumeApi.obterDados(ENDERECO+tipoVeiculo.toLowerCase()+"/marcas/"+marca+"/modelos/");
//        System.out.println(jsonModelo);
        var dadosModelos = converteDados.obterDados(jsonModelo, Modelos.class);

        dadosModelos.modelos()
                .stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.println("Digite o codigo do modelo desejado");
        var ano = scanner.nextLine();
        var jsonAno = consumeApi.obterDados(ENDERECO+tipoVeiculo.toLowerCase()+"/marcas/"+marca+"/modelos/"+ano+"/anos/");
//        System.out.println(jsonAno);

        List<Dados> dadosAno = converteDados.obterLista(jsonAno, Dados.class);

        dadosAno.stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        var fim = scanner.nextLine();
        var jsonFim = consumeApi.obterDados(ENDERECO+tipoVeiculo.toLowerCase()+"/marcas/"+marca+"/modelos/"+ano+"/anos/"+fim);
        System.out.println(jsonFim);
        var dadosFinais = converteDados.obterDados(jsonFim, DadosVeiculo.class);

        System.out.println(dadosFinais.Marca());
        System.out.println(dadosFinais.Ano());
        System.out.println(dadosFinais.Modelo());
        System.out.println(dadosFinais.Valor());


    }

}
