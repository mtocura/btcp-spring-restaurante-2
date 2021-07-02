package br.com.aula3.tm.restaurante2.model.service;

import br.com.aula3.tm.restaurante2.dto.CaixaDTO;
import br.com.aula3.tm.restaurante2.dto.MesaDTO;
import br.com.aula3.tm.restaurante2.dto.PedidoDTO;
import br.com.aula3.tm.restaurante2.dto.PratoDTO;
import br.com.aula3.tm.restaurante2.form.MesaForm;
import br.com.aula3.tm.restaurante2.form.PedidoForm;
import br.com.aula3.tm.restaurante2.form.PratoForm;
import br.com.aula3.tm.restaurante2.model.entity.Caixa;
import br.com.aula3.tm.restaurante2.model.entity.Mesa;
import br.com.aula3.tm.restaurante2.model.entity.PedidoStatus;
import br.com.aula3.tm.restaurante2.model.repository.CaixaRepository;
import br.com.aula3.tm.restaurante2.utils.converter.CaixaConverter;
import br.com.aula3.tm.restaurante2.utils.converter.MesaConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CaixaService {
    private CaixaRepository caixaRepository;
    private RestauranteService restauranteService;

    public CaixaService() {}

    @Autowired
    public CaixaService(CaixaRepository caixaRepository, RestauranteService restauranteService) {
        this.caixaRepository = caixaRepository;
        this.restauranteService = restauranteService;
    }

    public List<CaixaDTO> findAll() {
        return CaixaConverter.caixaEntityToDTO(caixaRepository.getAll());
    }

    public List<CaixaDTO> getRegistrosData(String data) {
        return CaixaConverter.caixaEntityToDTO(caixaRepository.getPedidosData(data));
    }

    public void checkout(long idMesa) {
        List<PedidoDTO> pedidoDTOS = restauranteService.getPedidosMesa(idMesa);
        double total = 0;
        String data = "";

        for (PedidoDTO pedidoDTO : pedidoDTOS) {
            total += pedidoDTO.getTotalPedido();
            data = pedidoDTO.getData();
        }

        Caixa caixa = new Caixa(data, total);
        caixaRepository.addRegistro(caixa);

        List<PedidoForm> pedidoForms = new ArrayList<>(
                Arrays.asList(
                        new PedidoForm(
                                new ArrayList<PratoForm>()
                        )
                )
        );
        MesaForm mesaForm = new MesaForm(pedidoForms);
        Mesa mesa = MesaConverter.mesaFormToEntity(mesaForm, idMesa, PedidoStatus.FINALIZADO, data);
        restauranteService.updatedMesa(mesa);
    }
}
