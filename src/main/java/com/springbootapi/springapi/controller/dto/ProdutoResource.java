package com.springbootapi.springapi.controller.dto;

import com.springbootapi.springapi.model.Produto;

import javax.validation.constraints.NotBlank;
import java.util.function.Predicate;

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

    // Contructor and Methods
    public ProdutoResource(Long id, String nome, String descricao, Double valor, Integer quantidade) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public ProdutoResource() {
    }

    public static ProdutoResource converter(Produto produto) {
        var produtoRs = new ProdutoResource();

        produtoRs.setNome(produto.getNome());
        produtoRs.setDescricao(produto.getDescricao());
        produtoRs.setValor(produto.getValor());
        produtoRs.setQuantidade(produto.getQuantidade());
        return produtoRs;
    }


    // Getters and Setters
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
