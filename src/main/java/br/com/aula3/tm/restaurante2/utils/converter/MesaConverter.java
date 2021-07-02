package br.com.aula3.tm.restaurante2.utils.converter;

import br.com.aula3.tm.restaurante2.dto.MesaDTO;
import br.com.aula3.tm.restaurante2.form.MesaForm;
import br.com.aula3.tm.restaurante2.form.PedidoForm;
import br.com.aula3.tm.restaurante2.form.PratoForm;
import br.com.aula3.tm.restaurante2.model.entity.Mesa;
import br.com.aula3.tm.restaurante2.model.entity.PedidoStatus;
import br.com.aula3.tm.restaurante2.utils.Id;

import java.util.ArrayList;
import java.util.List;

public class MesaConverter {
    public static Mesa mesaFormToEntity(MesaForm mesaForm) {
        long id = Id.genrateIdMesa();
        return new Mesa(
                id,
                PedidoConverter.pedidoFormToEntity(mesaForm.getPedidos(), id),
                total(mesaForm.getPedidos())
        );
    }

    public static Mesa mesaFormToEntity(MesaForm mesaForm, long id) {
        return new Mesa(
                id,
                PedidoConverter.pedidoFormToEntity(mesaForm.getPedidos(), id),
                total(mesaForm.getPedidos())
        );
    }

    public static Mesa mesaFormToEntity(MesaForm mesaForm, long id, PedidoStatus pedidoStatus, String data) {
        return new Mesa(
                id,
                PedidoConverter.pedidoFormToEntity(mesaForm.getPedidos(), id, pedidoStatus, data),
                total(mesaForm.getPedidos())
        );
    }

    public static List<Mesa> mesaFormToEntity(List<MesaForm> mesaForms) {
        List<Mesa> mesas = new ArrayList<>();

        for (MesaForm mesaForm : mesaForms) {
            mesas.add(mesaFormToEntity(mesaForm));
        }

        return mesas;
    }

    public static MesaDTO mesaEntityToDTO(Mesa mesa) {
        return new MesaDTO(
                PedidoConverter.pedidoEntityToDTO(mesa.getPedidos()),
                mesa.getValorTotal()
        );
    }

    public static List<MesaDTO> mesaEntityToDTO(List<Mesa> mesas) {
        List<MesaDTO> mesaDTOS = new ArrayList<>();

        for (Mesa mesa : mesas) {
            mesaDTOS.add(mesaEntityToDTO(mesa));
        }

        return mesaDTOS;
    }

    private static double total(List<PedidoForm> pedidoForms) {
        double total = 0;

        for (PedidoForm pedidoForm : pedidoForms) {
            for (PratoForm prato : pedidoForm.getPratos()) {
                total += prato.getPreco() * prato.getQuantidade();
            }
        }

        return total;
    }
}
