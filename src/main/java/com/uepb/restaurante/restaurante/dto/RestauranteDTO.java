package com.uepb.restaurante.restaurante.dto;

import com.uepb.restaurante.enderecos.dto.EnderecoDTO;

public class RestauranteDTO {

    private Long id;
    private String nome;
    private EnderecoDTO endereco;
    private PessoaResponsavelDTO pessoaResponsavel;
    private int capacidadeRefeicoes;
    private String horarioCafeManha;
    private String horarioAlmoco;
    private String horarioJantar;
    private String diasFuncionamento;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }

    public PessoaResponsavelDTO getPessoaResponsavel() {
        return pessoaResponsavel;
    }

    public void setPessoaResponsavel(PessoaResponsavelDTO pessoaResponsavel) {
        this.pessoaResponsavel = pessoaResponsavel;
    }

    public int getCapacidadeRefeicoes() {
        return capacidadeRefeicoes;
    }

    public void setCapacidadeRefeicoes(int capacidadeRefeicoes) {
        this.capacidadeRefeicoes = capacidadeRefeicoes;
    }

    public String getHorarioCafeManha() {
        return horarioCafeManha;
    }

    public void setHorarioCafeManha(String horarioCafeManha) {
        this.horarioCafeManha = horarioCafeManha;
    }

    public String getHorarioAlmoco() {
        return horarioAlmoco;
    }

    public void setHorarioAlmoco(String horarioAlmoco) {
        this.horarioAlmoco = horarioAlmoco;
    }

    public String getHorarioJantar() {
        return horarioJantar;
    }

    public void setHorarioJantar(String horarioJantar) {
        this.horarioJantar = horarioJantar;
    }

    public String getDiasFuncionamento() {
        return diasFuncionamento;
    }

    public void setDiasFuncionamento(String diasFuncionamento) {
        this.diasFuncionamento = diasFuncionamento;
    }
}
