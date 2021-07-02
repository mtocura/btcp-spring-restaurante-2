package br.com.aula3.tm.restaurante2.form;

import java.util.List;

public class MesaForm {
    private List<PedidoForm> pedidos;

    public MesaForm() {}

    public MesaForm(List<PedidoForm> pedidos) {
        this.pedidos = pedidos;
    }

    public List<PedidoForm> getPedidos() {
        return pedidos;
    }
}
