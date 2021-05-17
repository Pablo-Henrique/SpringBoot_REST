package com.springbootapi.springapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "PRODUTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
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

}
