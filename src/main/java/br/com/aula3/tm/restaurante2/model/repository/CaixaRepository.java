package br.com.aula3.tm.restaurante2.model.repository;

import br.com.aula3.tm.restaurante2.model.entity.Caixa;
import br.com.aula3.tm.restaurante2.model.entity.Mesa;
import br.com.aula3.tm.restaurante2.model.entity.Pedido;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CaixaRepository {
    private static final File FILE = new File("caixa.json");

    @Autowired
    private ObjectMapper mapper;

    public List<Caixa> getAll(){
        List<Caixa> anuncios = new ArrayList<>();
        try {
            FileInputStream is = new FileInputStream(FILE);
            TypeReference<List<Caixa>> typeReference = new TypeReference<List<Caixa>>() {};
            anuncios = mapper.readValue(is, typeReference);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return anuncios;
    }

    public List<Caixa> getPedidosData(String data) {
        List<Caixa> registros = getAll();
        List<Caixa> res = new ArrayList<>();

        for (Caixa registro : registros) {
            if(registro.getData().equals(data)) {
                res.add(registro);
            }
        }

        return res;
    }

    public void addRegistro(Caixa caixa) {
        try {
            List<Caixa> registros = getAll();
            System.out.println(caixa.getSaldo());
            registros.add(caixa);
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, registros);
            out.close();
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
