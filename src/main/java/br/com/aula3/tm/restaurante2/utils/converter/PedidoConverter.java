package br.com.aula3.tm.restaurante2.utils.converter;

import br.com.aula3.tm.restaurante2.dto.PedidoDTO;
import br.com.aula3.tm.restaurante2.dto.PratoDTO;
import br.com.aula3.tm.restaurante2.form.PedidoForm;
import br.com.aula3.tm.restaurante2.form.PratoForm;
import br.com.aula3.tm.restaurante2.model.entity.Pedido;
import br.com.aula3.tm.restaurante2.model.entity.PedidoStatus;
import br.com.aula3.tm.restaurante2.utils.Id;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PedidoConverter {
    public static Pedido pedidoFormToEntity(PedidoForm pedidoForm, long idMesa) {
        return new Pedido(
                Id.genrateIdPedido(),
                idMesa,
                PedidoStatus.NOVO,
                today(),
                PratoConverter.pratoFormToEntity(pedidoForm.getPratos()),
                totalPedido(pedidoForm.getPratos())
        );
    }

    public static List<Pedido> pedidoFormToEntity(List<PedidoForm> pedidoForms, long idMesa) {
        List<Pedido> pedidos = new ArrayList<>();

        for (PedidoForm pedidoForm : pedidoForms) {
            pedidos.add(pedidoFormToEntity(pedidoForm, idMesa));
        }

        return pedidos;
    }

    public static PedidoDTO pedidoEntityToDTO(Pedido pedido) {
        return new PedidoDTO(
                PratoConverter.pratoEntityToDTO(pedido.getPratos()),
                pedido.getStatus(),
                pedido.getData(),
                pedido.getTotal()
        );
    }

    public static List<PedidoDTO> pedidoEntityToDTO(List<Pedido> pedidos) {
        List<PedidoDTO> pedidoDTOS = new ArrayList<>();

        for (Pedido pedido : pedidos) {
            pedidoDTOS.add(pedidoEntityToDTO(pedido));
        }

        return pedidoDTOS;
    }

    private static String today() {
        Calendar calendar = Calendar.getInstance();

        Integer ano = calendar.get(Calendar.YEAR);
        Integer mes = calendar.get(Calendar.MONTH) + 1;
        Integer dia = calendar.get(Calendar.DAY_OF_MONTH);

        return dia + "/" + mes + "/" + ano;
    }

    private static double totalPedido(List<PratoForm> pratoForms) {
        double total = 0;

        for (PratoForm pratoForm : pratoForms) {
            total += pratoForm.getPreco() * pratoForm.getQuantidade();
        }

        return total;
    }
}
