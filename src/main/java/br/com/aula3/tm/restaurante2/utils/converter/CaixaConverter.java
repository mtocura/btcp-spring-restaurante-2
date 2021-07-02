package br.com.aula3.tm.restaurante2.utils.converter;

import br.com.aula3.tm.restaurante2.dto.CaixaDTO;
import br.com.aula3.tm.restaurante2.model.entity.Caixa;

import java.util.ArrayList;
import java.util.List;

public class CaixaConverter {
    public static CaixaDTO caixaEntityToDTO(Caixa caixa) {
        return new CaixaDTO(
                caixa.getData(),
                caixa.getValor(),
                Caixa.getSaldo()
        );
    }

    public static List<CaixaDTO> caixaEntityToDTO(List<Caixa> caixas) {
        List<CaixaDTO> caixaDTOS = new ArrayList<>();

        for (Caixa caixa : caixas) {
            caixaDTOS.add(caixaEntityToDTO(caixa));
        }

        return caixaDTOS;
    }
}
