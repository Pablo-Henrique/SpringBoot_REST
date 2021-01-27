package com.springbootapi.springapi.dto;

import java.util.Objects;

public class ProdutoDTO {

    private Short id;
    private double valor;

    public Double getValor() {
        return valor;
    }

    public ProdutoDTO setValor(double valor) {
        this.valor = valor;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoDTO that = (ProdutoDTO) o;
        return Double.compare(that.valor, valor) == 0 && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valor);
    }
}
