package br.com.aula3.tm.restaurante2.dto;

import java.util.List;

public class MesaDTO {
    private List<PedidoDTO> pedidos;
    private Double total;

    public MesaDTO() {}

    public MesaDTO(List<PedidoDTO> pedidos, Double total) {
        this.pedidos = pedidos;
        this.total = total;
    }

    public List<PedidoDTO> getPedidos() {
        return pedidos;
    }

    public Double getTotal() {
        return total;
    }
}
