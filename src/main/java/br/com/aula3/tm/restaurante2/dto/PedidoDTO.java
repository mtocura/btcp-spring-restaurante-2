package br.com.aula3.tm.restaurante2.dto;

import java.util.List;

public class PedidoDTO {
    private List<PratoDTO> pratos;
    private String status;
    private String data;
    private Double totalPedido;

    public PedidoDTO() {}

    public PedidoDTO(List<PratoDTO> pratos, String status, String data, Double totalPedido) {
        this.pratos = pratos;
        this.status = status;
        this.data = data;
        this.totalPedido = totalPedido;
    }

    public List<PratoDTO> getPratos() {
        return pratos;
    }

    public String getStatus() {
        return status;
    }

    public String getData() {
        return data;
    }

    public Double getTotalPedido() {
        return totalPedido;
    }
}
