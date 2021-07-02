package br.com.aula3.tm.restaurante2.model.service;

import br.com.aula3.tm.restaurante2.dto.MesaDTO;
import br.com.aula3.tm.restaurante2.dto.PedidoDTO;
import br.com.aula3.tm.restaurante2.form.MesaForm;
import br.com.aula3.tm.restaurante2.model.entity.Mesa;
import br.com.aula3.tm.restaurante2.model.repository.RestauranteRepository;
import br.com.aula3.tm.restaurante2.utils.converter.MesaConverter;
import br.com.aula3.tm.restaurante2.utils.converter.PedidoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauranteService {
    private RestauranteRepository restauranteRepository;

    public RestauranteService() {}

    @Autowired
    public RestauranteService(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    public List<MesaDTO> findAll() {
        return MesaConverter.mesaEntityToDTO(restauranteRepository.getAll());
    }

    public List<PedidoDTO> getPedidosMesa(long id) {
        return PedidoConverter.pedidoEntityToDTO(restauranteRepository.getPedidosMesa(id));
    }

    public List<PedidoDTO> getPedidosData(String data) {
        // TODO validação de data
        return PedidoConverter.pedidoEntityToDTO(restauranteRepository.getPedidosData(data));
    }

    public Mesa addMesa(MesaForm mesaForm) {
        Mesa mesa = MesaConverter.mesaFormToEntity(mesaForm);
        restauranteRepository.addMesa(mesa);
        return mesa;
    }

    public void updatedMesa(long id, MesaForm mesaForm) {
        Mesa mesa = MesaConverter.mesaFormToEntity(mesaForm, id);
        restauranteRepository.updateMesa(mesa);
    }

    public MesaDTO deleteMesa(long id) {
        Mesa mesa = restauranteRepository.deleteMesa(id);

        if(mesa == null) {
            return null;
        }
        
       return MesaConverter.mesaEntityToDTO(mesa);
    }
}
