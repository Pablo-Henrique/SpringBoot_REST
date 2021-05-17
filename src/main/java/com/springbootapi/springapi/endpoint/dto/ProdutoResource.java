package com.springbootapi.springapi.endpoint.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

}
