package br.com.aula3.tm.restaurante2.controller;

import br.com.aula3.tm.restaurante2.model.service.CaixaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aula3/tt")
public class CaixaController {
    private CaixaService caixaService;

    public CaixaController() {}

    @Autowired
    public CaixaController(CaixaService caixaService) {
        this.caixaService = caixaService;
    }

    @GetMapping("/caixa")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(caixaService.findAll());
    }

    @GetMapping("/caixa/{dia}/{mes}/{ano}")
    public ResponseEntity<?> getRegistrosData(@PathVariable String dia, @PathVariable String mes, @PathVariable String ano) {
        String data = dia + "/" + mes + "/" + ano;
        return ResponseEntity.ok(caixaService.getRegistrosData(data));
    }

    @GetMapping("/mesas/{id}/checkout")
    public ResponseEntity<?> fecharConta(@PathVariable long id) {
        caixaService.checkout(id);
        return ResponseEntity.ok().build();
    }
}
