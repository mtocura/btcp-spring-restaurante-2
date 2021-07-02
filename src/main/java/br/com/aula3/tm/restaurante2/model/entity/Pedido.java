package br.com.aula3.tm.restaurante2.model.entity;

import java.util.Calendar;
import java.util.List;

public class Pedido {
    private Long id;
    private Long idMesa;
    private PedidoStatus status;
    private String data;
    private List<Prato> pratos;
    private Double total;

    public Pedido() {}

    public Pedido(Long id, Long idMesa, PedidoStatus status, String data, List<Prato> pratos, Double total) {
        this.id = id;
        this.idMesa = Pedido.this.idMesa;
        this.status = status;
        this.data = data;
        this.pratos = pratos;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public Long getIdMesa() {
        return idMesa;
    }

    public PedidoStatus getStatus() {
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
