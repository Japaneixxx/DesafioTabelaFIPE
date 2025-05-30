package com.japastudios.TabelaFipe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Veiculo {
    private String modelo;
    private double valor;
    private int ano;
    private String marca;

    public Veiculo(String modelo, double valor, int ano, String marca) {
        this.modelo = modelo;
        this.valor = valor;
        this.ano = ano;
        this.marca = marca;
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
