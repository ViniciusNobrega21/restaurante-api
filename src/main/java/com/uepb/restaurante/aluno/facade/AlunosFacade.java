package com.uepb.restaurante.aluno.facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.uepb.restaurante.aluno.dto.AlunoDTO;

@Service
public class AlunosFacade {

    private static final Map<Long, AlunoDTO> alunos = new HashMap<>();
    
    public AlunoDTO criar(AlunoDTO alunoDTO){
        Long proximoId = alunos.keySet().size() + 1L;
        alunoDTO.setId(proximoId);
        alunos.put(proximoId, alunoDTO);
        return alunoDTO;
    }

    public AlunoDTO atualizar(AlunoDTO alunoDTO, Long alunoId){
        if (!alunos.containsKey(alunoId)) {
            System.out.println("Aluno com ID " + alunoId + " não encontrado para atualização.");
            return null; 
        }
        alunoDTO.setId(alunoId);
        alunos.put(alunoId, alunoDTO);
        return alunoDTO;
    }

    public AlunoDTO getById(Long alunoId){
        return alunos.get(alunoId);
    }

    public List<AlunoDTO> getAll(){
        return new ArrayList<>(alunos.values());
    }

    public String delete(Long alunoId){
        if (!alunos.containsKey(alunoId)) {
            System.out.println("Aluno com ID " + alunoId + " não encontrado para deleção.");
            return "Aluno não encontrado"; 
        }
        alunos.remove(alunoId);
        return "Deleted";
    }
}
