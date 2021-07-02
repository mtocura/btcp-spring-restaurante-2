package br.com.aula3.tm.restaurante2.controller;

import br.com.aula3.tm.restaurante2.dto.MesaDTO;
import br.com.aula3.tm.restaurante2.dto.PedidoDTO;
import br.com.aula3.tm.restaurante2.form.MesaForm;
import br.com.aula3.tm.restaurante2.model.entity.Mesa;
import br.com.aula3.tm.restaurante2.model.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/aula3/tt")
public class RestauranteController {

    private RestauranteService restauranteService;

    public RestauranteController() {}

    @Autowired
    public RestauranteController(RestauranteService restauranteService) {
        this.restauranteService = restauranteService;
    }

    @GetMapping("/mesas")
    public ResponseEntity<?> getAllMesas() {
        return ResponseEntity.ok(restauranteService.findAll());
    }

    @GetMapping("/mesas/{id}")
    public ResponseEntity<?> getPedidosMesa(@PathVariable long id) {
        List<PedidoDTO> pedidos = restauranteService.getPedidosMesa(id);

        if(pedidos == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/pedidos/{dia}/{mes}/{ano}")
    public ResponseEntity<?> getPedidosData(@PathVariable String dia, @PathVariable String mes, @PathVariable String ano) {
        String data = dia + "/" + mes + "/" + ano;
        List<PedidoDTO> pedidos = restauranteService.getPedidosData(data);

        if(pedidos == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(pedidos);
    }

    @PostMapping("/mesas")
    public ResponseEntity<?> addMesa(@RequestBody MesaForm mesaForm, UriComponentsBuilder uriBuilder) {
        Mesa mesa = restauranteService.addMesa(mesaForm);
        URI uri = uriBuilder.path("/aula3/tt/mesas/{id}").buildAndExpand(mesa.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/mesas/{id}")
    public ResponseEntity<?> updateMesa(@PathVariable long id, @RequestBody MesaForm mesaForm) {
        restauranteService.updatedMesa(id, mesaForm);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/mesas/{id}")
    public ResponseEntity<?> deleteMesa(@PathVariable long id) {
        MesaDTO mesa = restauranteService.deleteMesa(id);

        if(mesa == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(mesa);
    }
}
