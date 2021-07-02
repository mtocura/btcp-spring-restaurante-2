package br.com.aula3.tm.restaurante2.dto;

import java.util.List;

public class PedidoDTO {
    private List<PratoDTO> pratos;
    private Double totalPedido;

    public PedidoDTO() {}

    public PedidoDTO(List<PratoDTO> pratos, Double totalPedido) {
        this.pratos = pratos;
        this.totalPedido = totalPedido;
    }

    public List<PratoDTO> getPratos() {
        return pratos;
    }

    public Double getTotalPedido() {
        return totalPedido;
    }
}
