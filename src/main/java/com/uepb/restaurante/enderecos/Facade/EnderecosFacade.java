package com.uepb.restaurante.enderecos.Facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.uepb.restaurante.enderecos.dto.EnderecoDTO;

@Service
public class EnderecosFacade {

    private static final Map<Long, EnderecoDTO> enderecos = new HashMap<>();
    
    public EnderecoDTO criar(EnderecoDTO enderecoDTO){
        Long proximoId = enderecos.keySet().size() + 1L;
        enderecoDTO.setId(proximoId);
        enderecos.put(proximoId, enderecoDTO);
        return enderecoDTO;
    }

    public EnderecoDTO atualizar(EnderecoDTO enderecoDTO, Long enderecoId){
        if (!enderecos.containsKey(enderecoId)) {
            // Log para indicar que o endereço não foi encontrado
            System.out.println("Endereço com ID " + enderecoId + " não encontrado para atualização.");
            return null; // Ou lance uma exceção apropriada
        }
        enderecoDTO.setId(enderecoId);
        enderecos.put(enderecoId, enderecoDTO);
        return enderecoDTO;
    }

    public EnderecoDTO getById(Long enderecoId){
        return enderecos.get(enderecoId);
    }

    public List<EnderecoDTO> getAll(){
        return new ArrayList<>(enderecos.values());
    }

    public String delete(Long enderecoId){
        if (!enderecos.containsKey(enderecoId)) {
            // Log para indicar que o endereço não foi encontrado
            System.out.println("Endereço com ID " + enderecoId + " não encontrado para deleção.");
            return "Endereço não encontrado"; // Ou lance uma exceção apropriada
        }
        enderecos.remove(enderecoId);
        return "Deleted";
    }
}
