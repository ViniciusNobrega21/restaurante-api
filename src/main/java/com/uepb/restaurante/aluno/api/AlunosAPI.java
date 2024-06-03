package com.uepb.restaurante.aluno.api;

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

import com.uepb.restaurante.aluno.dto.AlunoDTO;
import com.uepb.restaurante.aluno.facade.AlunosFacade;

@RestController
@RequestMapping(value = "/alunos", produces = MediaType.APPLICATION_JSON_VALUE)
public class AlunosAPI {

    @Autowired
    private AlunosFacade alunosFacade;

    @PostMapping
    @ResponseBody
    public AlunoDTO criar(@RequestBody AlunoDTO alunoDTO) {
        return alunosFacade.criar(alunoDTO);
    }

    @PutMapping("/{alunoId}")
    @ResponseBody
    public AlunoDTO atualizar(@PathVariable("alunoId") Long alunoId, @RequestBody AlunoDTO alunoDTO) {
        AlunoDTO atualizado = alunosFacade.atualizar(alunoDTO, alunoId);
        if (atualizado == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado");
        }
        return atualizado;
    }

    @GetMapping
    @ResponseBody
    public List<AlunoDTO> getAll() {
        return alunosFacade.getAll();
    }

    @GetMapping("/{alunoId}")
    @ResponseBody
    public AlunoDTO getById(@PathVariable("alunoId") Long alunoId) {
        AlunoDTO aluno = alunosFacade.getById(alunoId);
        if (aluno == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado");
        }
        return aluno;
    }

    @DeleteMapping("/{alunoId}")
    @ResponseBody
    public String deletar(@PathVariable("alunoId") Long alunoId) {
        String result = alunosFacade.delete(alunoId);
        if ("Aluno não encontrado".equals(result)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado");
        }
        return result;
    }
}
