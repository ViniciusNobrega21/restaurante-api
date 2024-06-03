package com.uepb.restaurante.pessoasresponsaveis.facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.uepb.restaurante.restaurante.dto.PessoaResponsavelDTO;
@Service
public class PessoasResponsaveisFacade {
    private static final Map<Long, PessoaResponsavelDTO> pessoasResponsaveis = new HashMap<>();

    public PessoaResponsavelDTO criar(PessoaResponsavelDTO pessoaResponsavelDTO) {
        Long proximoId = (long) (pessoasResponsaveis.size() + 1);
        pessoaResponsavelDTO.setId(proximoId);
        pessoasResponsaveis.put(proximoId, pessoaResponsavelDTO);
        return pessoaResponsavelDTO;
    }

    public PessoaResponsavelDTO atualizar(PessoaResponsavelDTO pessoaResponsavelDTO, Long restauranteId) {
        if (!pessoasResponsaveis.containsKey(restauranteId)) {
            return null; // Ou lance uma exceção apropriada
        }
        pessoaResponsavelDTO.setId(restauranteId);
        pessoasResponsaveis.put(restauranteId, pessoaResponsavelDTO);
        return pessoaResponsavelDTO;
    }

    public PessoaResponsavelDTO getById(Long restauranteId) {
        return pessoasResponsaveis.get(restauranteId);
    }

    public List<PessoaResponsavelDTO> getAll() {
        return new ArrayList<>(pessoasResponsaveis.values());
    }

    public String delete(Long restauranteId) {
        if (!pessoasResponsaveis.containsKey(restauranteId)) {
            return "Restaurante não encontrado"; // Ou lance uma exceção apropriada
        }
        pessoasResponsaveis.remove(restauranteId);
        return "Deleted";
    }
    

}
