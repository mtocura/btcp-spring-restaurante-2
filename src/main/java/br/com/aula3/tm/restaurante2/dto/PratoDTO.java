package br.com.aula3.tm.restaurante2.dto;

public class PratoDTO {
    private Double preco;
    private String descricao;
    private Integer quantidade;

    public PratoDTO() {}

    public PratoDTO(Double preco, String descricao, Integer quantidade) {
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
