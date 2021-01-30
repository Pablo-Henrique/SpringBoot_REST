package com.springbootapi.springapi.controller.dto;

import javax.validation.constraints.NotBlank;

public class ProdutoResource {


    private Long id;

    @NotBlank(message = "Nome Obrigatorio")
    private String nome;

    @NotBlank(message = "Descrição Obrigatoria")
    private String descricao;

    @NotBlank(message = "Valor Obrigatorio")
    private Double valor;

    @NotBlank(message = "Quantidade Obrigatorio")
    private Integer quantidade;

    public Long getId() {
        return id;
    }

    public ProdutoResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public ProdutoResource setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public ProdutoResource setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public Double getValor() {
        return valor;
    }

    public ProdutoResource setValor(Double valor) {
        this.valor = valor;
        return this;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public ProdutoResource setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }
}
