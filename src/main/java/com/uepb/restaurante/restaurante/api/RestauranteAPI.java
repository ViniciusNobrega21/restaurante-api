package com.uepb.restaurante.restaurante.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.uepb.restaurante.restaurante.dto.RestauranteDTO;
import com.uepb.restaurante.restaurante.facade.RestauranteFacade;

@RestController
@RequestMapping(value = "/restaurantes", produces = MediaType.APPLICATION_JSON_VALUE)
public class RestauranteAPI {

    @Autowired
    private RestauranteFacade restaurantesFacade;

    @PostMapping
    @ResponseBody
    public RestauranteDTO criar(@RequestBody RestauranteDTO restauranteDTO) {
        return restaurantesFacade.criar(restauranteDTO);
    }

    @PutMapping("/{restauranteId}")
    @ResponseBody
    public RestauranteDTO atualizar(@PathVariable("restauranteId") Long restauranteId, @RequestBody RestauranteDTO restauranteDTO) {
        RestauranteDTO atualizado = restaurantesFacade.atualizar(restauranteDTO, restauranteId);
        if (atualizado == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurante não encontrado");
        }
        return atualizado;
    }

    @GetMapping
    @ResponseBody
    public List<RestauranteDTO> getAll() {
        return restaurantesFacade.getAll();
    }

    @GetMapping("/{restauranteId}")
    @ResponseBody
    public RestauranteDTO getById(@PathVariable("restauranteId") Long restauranteId) {
        RestauranteDTO restaurante = restaurantesFacade.getById(restauranteId);
        if (restaurante == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurante não encontrado");
        }
        return restaurante;
    }

    @DeleteMapping("/{restauranteId}")
    @ResponseBody
    public String deletar(@PathVariable("restauranteId") Long restauranteId) {
        String result = restaurantesFacade.delete(restauranteId);
        if ("Restaurante não encontrado".equals(result)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurante não encontrado");
        }
        return result;
    }
}
