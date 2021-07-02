package br.com.aula3.tm.restaurante2.dto;

import br.com.aula3.tm.restaurante2.model.entity.PedidoStatus;

import java.util.List;

public class PedidoDTO {
    private List<PratoDTO> pratos;
    private PedidoStatus status;
    private String data;
    private Double totalPedido;

    public PedidoDTO() {}

    public PedidoDTO(List<PratoDTO> pratos, PedidoStatus status, String data, Double totalPedido) {
        this.pratos = pratos;
        this.status = status;
        this.data = data;
        this.totalPedido = totalPedido;
    }

    public List<PratoDTO> getPratos() {
        return pratos;
    }

    public PedidoStatus getStatus() {
        return status;
    }

    public String getData() {
        return data;
    }

    public Double getTotalPedido() {
        return totalPedido;
    }
}
