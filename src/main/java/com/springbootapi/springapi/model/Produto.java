package com.springbootapi.springapi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nome_Produto", length = 255, nullable = false)
    private String nome;

    @Column(name = "Descricao_Produto", length = 255, nullable = false)
    private String descricao;

    @Column(name = "Valor_Produto", nullable = false)
    private Double valor;

    @Column(name = "Qtd_Produto", nullable = false)
    private Integer quantidade;

    // Getters, Setters and constructor
    public Produto(Long id, String no, String desc, Double valor, int qtd) {
        this.id = id;
        this.nome = no;
        this.descricao = desc;
        this.valor = valor;
        this.quantidade = qtd;
    }

    public Produto() {

    }

    public Long getId() {
        return id;
    }

    public Produto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Produto setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Produto setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public Double getValor() {
        return valor;
    }

    public Produto setValor(Double valor) {
        this.valor = valor;
        return this;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Produto setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return valor == produto.valor
                && quantidade == produto.quantidade
                && id.equals(produto.id) && nome.equals(produto.nome)
                && descricao.equals(produto.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, valor, quantidade);
    }
}
