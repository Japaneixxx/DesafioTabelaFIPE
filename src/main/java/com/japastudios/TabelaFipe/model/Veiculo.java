package com.japastudios.TabelaFipe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Veiculo {
    private String modelo;
    private double valor;
    private int ano;
    private String marca;

    public Veiculo(DadosVeiculo dados) {
        this.modelo = dados.Modelo;
        this.valor = dados.Valor;
        this.ano = dados.Ano;
        this.marca = dados.Marca;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "modelo='" + modelo + '\'' +
                ", Valor=" + valor +
                ", Ano=" + ano +
                ", Marca='" + marca + '\'' +
                '}';
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
