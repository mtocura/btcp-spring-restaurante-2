package br.com.aula3.tm.restaurante2.model.entity;

public class Caixa {
    private String data;
    private Double valor;
    private static Double saldo;

    public Caixa() {
        saldo = 0.0;
    }

    public Caixa(String data, Double valor) {
        this.data = data;
        this.valor = valor;
        saldo = 0.0;
    }

    public String getData() {
        return data;
    }

    public Double getValor() {
        return valor;
    }

    public static Double getSaldo() {
        return saldo;
    }
}
