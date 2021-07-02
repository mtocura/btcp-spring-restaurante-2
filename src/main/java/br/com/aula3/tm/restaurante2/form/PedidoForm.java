package br.com.aula3.tm.restaurante2.form;

import java.util.List;

public class PedidoForm {
    private List<PratoForm> pratos;

    public PedidoForm() {}

    public PedidoForm(List<PratoForm> pratos) {
        this.pratos = pratos;
    }

    public List<PratoForm> getPratos() {
        return pratos;
    }
}
