package com.uepb.restaurante.pessoasresponsaveis.api;

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

import com.uepb.restaurante.pessoasresponsaveis.facade.PessoasResponsaveisFacade;
import com.uepb.restaurante.restaurante.dto.PessoaResponsavelDTO;
@RestController
@RequestMapping(value = "/pessoas", produces = MediaType.APPLICATION_JSON_VALUE)

public class PessoasResponsaveisApi {
    
    @Autowired
    private PessoasResponsaveisFacade pessoaResponsavelFacade;

    @PostMapping
    @ResponseBody
    public PessoaResponsavelDTO criar(@RequestBody PessoaResponsavelDTO pessoaResponsavelDTO) {
        return pessoaResponsavelFacade.criar(pessoaResponsavelDTO);
    }

    @PutMapping("/{pessoaResponsavelId}")
    @ResponseBody
    public PessoaResponsavelDTO atualizar(@PathVariable("pessoaResponsavelId") Long pessoaResponsavelId, @RequestBody PessoaResponsavelDTO pessoaResponsavelDTO) {
        PessoaResponsavelDTO atualizado = pessoaResponsavelFacade.atualizar(pessoaResponsavelDTO, pessoaResponsavelId);
        if (atualizado == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrado");
        }
        return atualizado;
    }

    @GetMapping
    @ResponseBody
    public List<PessoaResponsavelDTO> getAll() {
        return pessoaResponsavelFacade.getAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public PessoaResponsavelDTO getById(@PathVariable("id") Long id) {
        return pessoaResponsavelFacade.getById(id);
    }

    @DeleteMapping("/{pessoaResponsavelId}")
    @ResponseBody
    public String deletar(@PathVariable("pessoaResponsavelId") Long pessoaResponsavelId) {
        String result = pessoaResponsavelFacade.delete(pessoaResponsavelId);
        if ("Restaurante não encontrado".equals(result)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurante não encontrado");
        }
        return result;
    }

}
