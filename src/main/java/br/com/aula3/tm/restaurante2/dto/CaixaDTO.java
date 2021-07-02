package br.com.aula3.tm.restaurante2.dto;

public class CaixaDTO {
    private String data;
    private Double valor;
    private Double saldo;

    public CaixaDTO() {}

    public CaixaDTO(String data, Double valor, Double saldo) {
        this.data = data;
        this.valor = valor;
        this.saldo = saldo;
    }

    public String getData() {
        return data;
    }

    public Double getValor() {
        return valor;
    }

    public Double getSaldo() {
        return saldo;
    }
}
