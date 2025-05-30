package com.japastudios.TabelaFipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosVeiculo( String Modelo,
                            String Valor,
                            @JsonAlias("AnoModelo")
                            int Ano,
                            String Marca) {
}
