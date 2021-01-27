package com.springbootapi.springapi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(name = "Nome_Produto", length = 255, nullable = false, unique = true)
    private String nome;

    @Column(name = "Descricao_Produto", length = 255, nullable = false, unique = true)
    private String descricao;

    @Column(name = "Valor_Produto", nullable = false)
    private long valor;

    @Column(name = "Qtd_Produto", nullable = false)
    private int quantidade;

    // Getters, Setters and constructor
    public Produto(Short id, String no, String desc, long valor, int qtd) {
        this.id = id;
        this.nome = no;
        this.descricao = desc;
        this.valor = valor;
        this.quantidade = qtd;
    }

    public Short getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public long getValor() {
        return valor;
    }

    public int getQuantidade() {
        return quantidade;
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
