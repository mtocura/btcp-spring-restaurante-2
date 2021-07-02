package br.com.aula3.tm.restaurante2.model.entity;

public class Prato {
    private Long id;
    private Double preco;
    private String descricao;
    private Integer quantidade;

    public Prato() {}

    public Prato(Long id, Double preco, String descricao, Integer quantidade) {
        this.id = id;
        this.preco = preco;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
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
