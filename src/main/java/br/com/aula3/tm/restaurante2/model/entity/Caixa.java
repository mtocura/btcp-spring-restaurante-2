package br.com.aula3.tm.restaurante2.model.entity;

public class Caixa {
    private String data;
    private Double valor;
    private static double saldo;

    public Caixa() {}

    public Caixa(String data, Double valor) {
        this.data = data;
        this.valor = valor;
        saldo += valor;
    }

    public String getData() {
        return data;
    }

    public Double getValor() {
        return valor;
    }

    public static double getSaldo() {
        return saldo;
    }

    public static void setSaldo(double saldo) {
        Caixa.saldo = saldo;
    }
}
