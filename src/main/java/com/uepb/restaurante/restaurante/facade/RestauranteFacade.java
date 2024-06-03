package com.uepb.restaurante.restaurante.facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.uepb.restaurante.restaurante.dto.RestauranteDTO;

@Service
public class RestauranteFacade {

    private static final Map<Long, RestauranteDTO> restaurantes = new HashMap<>();
    
    public RestauranteDTO criar(RestauranteDTO restauranteDTO){
        Long proximoId = restaurantes.keySet().size() + 1L;
        restauranteDTO.setId(proximoId);
        restaurantes.put(proximoId, restauranteDTO);
        return restauranteDTO;
    }

    public RestauranteDTO atualizar(RestauranteDTO restauranteDTO, Long restauranteId){
        if (!restaurantes.containsKey(restauranteId)) {
            System.out.println("Restaurante com ID " + restauranteId + " não encontrado para atualização.");
            return null;
        }
        restauranteDTO.setId(restauranteId);
        restaurantes.put(restauranteId, restauranteDTO);
        return restauranteDTO;
    }

    public RestauranteDTO getById(Long restauranteId){
        return restaurantes.get(restauranteId);
    }

    public List<RestauranteDTO> getAll(){
        return new ArrayList<>(restaurantes.values());
    }

    public String delete(Long restauranteId){
        if (!restaurantes.containsKey(restauranteId)) {
            System.out.println("Restaurante com ID " + restauranteId + " não encontrado para deleção.");
            return "Restaurante não encontrado";
        }
        restaurantes.remove(restauranteId);
        return "Deleted";
    }
}
