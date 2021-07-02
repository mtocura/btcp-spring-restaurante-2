package br.com.aula3.tm.restaurante2.model.entity;

import java.util.List;

public class Pedido {
    private Long id;
    private Mesa mesa;
    private List<Prato> pratos;
    private Double total;

    public Pedido() {}

    public Pedido(Long id, Mesa mesa, List<Prato> pratos, Double total) {
        this.id = id;
        this.mesa = mesa;
        this.pratos = pratos;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public List<Prato> getPratos() {
        return pratos;
    }

    public Double getTotal() {
        return total;
    }
}
