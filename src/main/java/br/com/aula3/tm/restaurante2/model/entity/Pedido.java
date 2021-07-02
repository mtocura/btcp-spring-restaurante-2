package br.com.aula3.tm.restaurante2.model.entity;

import java.util.Calendar;
import java.util.List;

public class Pedido {
    private Long id;
    private Mesa mesa;
    private String status;
    private String data;
    private List<Prato> pratos;
    private Double total;

    public Pedido() {}

    public Pedido(Long id, Mesa mesa, String status, String data, List<Prato> pratos, Double total) {
        this.id = id;
        this.mesa = mesa;
        this.status = status;
        this.data = data;
        this.pratos = pratos;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public String getStatus() {
        return status;
    }

    public String getData() {
        return data;
    }

    public List<Prato> getPratos() {
        return pratos;
    }

    public Double getTotal() {
        return total;
    }
}
