package br.com.aula3.tm.restaurante2.model.entity;

import java.util.List;

public class Mesa {
    private Long id;
    private List<Pedido> pedidos;
    private Double valorTotal;

    public Mesa() {}

    public Mesa(Long id, List<Pedido> pedidos, Double valorTotal) {
        this.id = id;
        this.pedidos = pedidos;
        this.valorTotal = valorTotal;
    }

    public Long getId() {
        return id;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public Double getValorTotal() {
        return valorTotal;
    }
}
