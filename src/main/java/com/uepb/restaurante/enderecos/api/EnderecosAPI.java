package com.uepb.restaurante.enderecos.api;

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

import com.uepb.restaurante.enderecos.Facade.EnderecosFacade;
import com.uepb.restaurante.enderecos.dto.EnderecoDTO;

@RestController
@RequestMapping(value = "/enderecos", produces = MediaType.APPLICATION_JSON_VALUE)
public class EnderecosAPI {

    @Autowired
    private EnderecosFacade enderecosFacade;

    @PostMapping
    @ResponseBody
    public EnderecoDTO criar(@RequestBody EnderecoDTO enderecoDTO) {
        return enderecosFacade.criar(enderecoDTO);
    }

    @PutMapping("/{enderecoId}")
    @ResponseBody
    public EnderecoDTO atualizar(@PathVariable("enderecoId") Long enderecoId, @RequestBody EnderecoDTO enderecoDTO) {
        EnderecoDTO atualizado = enderecosFacade.atualizar(enderecoDTO, enderecoId);
        if (atualizado == null) {
            // Retorne uma resposta de erro apropriada
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado");
        }
        return atualizado;
    }

    @GetMapping
    @ResponseBody
    public List<EnderecoDTO> getAll() {
        return enderecosFacade.getAll();
    }
    
    @GetMapping("{id}")
    @ResponseBody
    public EnderecoDTO getById(@PathVariable("id") Long id) {
        return enderecosFacade.getById(id);
    }

    @DeleteMapping("/{enderecoId}")
    @ResponseBody
    public String deletar(@PathVariable("enderecoId") Long enderecoId) {
        String result = enderecosFacade.delete(enderecoId);
        if ("Endereço não encontrado".equals(result)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não encontrado");
        }
        return result;
    }
}
