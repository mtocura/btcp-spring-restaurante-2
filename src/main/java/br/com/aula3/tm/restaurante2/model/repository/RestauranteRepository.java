package br.com.aula3.tm.restaurante2.model.repository;

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
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class RestauranteRepository {
    private static final File FILE = new File("restaurante.json");

    @Autowired
    private ObjectMapper mapper;

    public List<Mesa> getAll(){
        List<Mesa> anuncios = new ArrayList<>();
        try {
            FileInputStream is = new FileInputStream(FILE);
            TypeReference<List<Mesa>> typeReference = new TypeReference<List<Mesa>>() {};
            anuncios = mapper.readValue(is, typeReference);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return anuncios;
    }

    public List<Pedido> getPedidosMesa(long id) {
        List<Mesa> mesas = getAll();

        Optional<Mesa> mesaOptional = mesas.stream().filter(mesa -> mesa.getId() == id).findAny();

        if(mesaOptional.isPresent()) {
            return mesaOptional.get().getPedidos();
        }

        return null;
    }

    public List<Pedido> getPedidosData(String data) {
        List<Mesa> mesas = getAll();
        List<Pedido> pedidos = new ArrayList<>();

        for (Mesa mesa : mesas) {
            for (Pedido pedido : mesa.getPedidos()) {
                if(pedido.getData().equals(data)) {
                    pedidos.add(pedido);
                }
            }
        }

        return pedidos;
    }

    public void addMesa(Mesa mesa) {
        try {
            List<Mesa> mesas = getAll();
            mesas.add(mesa);
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, mesas);
            out.close();
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateMesa(Mesa mesa, long id) {
        try {
            List<Mesa> mesas = getAll();

            Optional<Mesa> mesaOptional = mesas.stream().filter(m -> m.getId() == id).findFirst();
            List<Mesa> updatedMesas = mesas.stream().filter(m -> m.getId() != id).collect(Collectors.toList());

            if(mesaOptional.isPresent()) {
                mesaOptional.get().setPedidos(mesa.getPedidos());
                updatedMesas.add(mesaOptional.get());
            }

            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, updatedMesas);
            out.close();
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Mesa deleteMesa(long id) {
        try {
            List<Mesa> mesas = getAll();

            Optional<Mesa> mesaOptional = mesas.stream().filter(m -> m.getId() == id).findFirst();
            List<Mesa> updatedMesas = mesas.stream().filter(m -> m.getId() != id).collect(Collectors.toList());

            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, updatedMesas);
            out.close();

            if(mesaOptional.isPresent()) {
                return mesaOptional.get();
            }

            return null;
        } catch (JsonGenerationException e) {
            e.printStackTrace();
            return null;
        } catch (JsonMappingException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
