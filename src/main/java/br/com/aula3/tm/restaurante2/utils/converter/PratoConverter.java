package br.com.aula3.tm.restaurante2.utils.converter;

import br.com.aula3.tm.restaurante2.dto.PratoDTO;
import br.com.aula3.tm.restaurante2.form.PratoForm;
import br.com.aula3.tm.restaurante2.model.entity.Prato;
import br.com.aula3.tm.restaurante2.utils.Id;

import java.util.ArrayList;
import java.util.List;

public class PratoConverter {
    public static Prato pratoFormToEntity(PratoForm pratoForm) {
        return new Prato(
                Id.genrateIdPrato(),
                pratoForm.getPreco(),
                pratoForm.getDescricao(),
                pratoForm.getQuantidade()
        );
    }

    public static List<Prato> pratoFormToEntity(List<PratoForm> pratoForms) {
        List<Prato> pratos = new ArrayList<>();

        for (PratoForm pratoForm : pratoForms) {
            pratos.add(pratoFormToEntity(pratoForm));
        }

        return pratos;
    }

    public static PratoDTO pratoEntityToDTO(Prato prato) {
        return new PratoDTO(
                prato.getPreco(),
                prato.getDescricao(),
                prato.getQuantidade()
        );
    }

    public static List<PratoDTO> pratoEntityToDTO(List<Prato> pratos) {
        List<PratoDTO> pratoDTOS = new ArrayList<>();

        for (Prato prato : pratos) {
            pratoDTOS.add(pratoEntityToDTO(prato));
        }

        return pratoDTOS;
    }
}
