package br.com.aula3.tm.restaurante2.form;

public class PratoForm {
    private Double preco;
    private String descricao;
    private Integer quantidade;

    public PratoForm() {}

    public PratoForm(Double preco, String descricao, Integer quantidade) {
        this.preco = preco;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}
