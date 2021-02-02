package com.springbootapi.springapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springbootapi.springapi.controller.dto.ProdutoResource;
import com.springbootapi.springapi.model.Produto;
import com.springbootapi.springapi.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;
    private ObjectMapper objectMapper;

    public ProdutoService(ProdutoRepository produtoRepository, ObjectMapper objectMapper) {

        this.produtoRepository = produtoRepository;
        this.objectMapper = objectMapper;
    }

    /**
     * Retorna uma Lista com todas Entidade em Banco
     *
     * @return Lista de Entidade
     */
    public List<Produto> listAllProducts() {
        return this.produtoRepository.findAll();
    }

    /**
     * Retorna uma Entidade passada Pelo ID
     *
     * @param id identificador Key
     * @return Entidade Produto pelo ID
     */
    public Optional<Produto> getById(Long id) {


        return this.produtoRepository.findById(id);
    }

    /**
     * Salva uma Entidade em Banco
     *
     * @param produto Objeto Entidade Relacional
     * @return Entidade Produto
     */
    public Produto saveProducts(Produto produto) {
        return this.produtoRepository.save(produto);
    }

    /**
     * Deleta uma Entidade em Banco
     *
     * @param id identificador Key
     */
    public void deleteId(Long id) {
        this.produtoRepository.deleteById(id);
    }

    /**
     * Verifica se Existe um ID em Entidade
     *
     * @param id identificador Key
     * @return Boolean (true) - ID existe, (false) ID não existe
     */
    public boolean existsId(Long id) {
        return this.produtoRepository.existsById(id);
    }

    /**
     * Faz uma Modificação em um Recurso ja Existente passado por ID
     *
     * @param id              identificador Key
     * @param produtoResource Objeto Entidade Relacional
     * @return Entidade Produto
     */
    public Produto updateProduto(Long id, ProdutoResource produtoResource) {

        this.produtoRepository.findById(id)
                .map(oldProduct -> {
                    oldProduct.setNome(produtoResource.getNome());
                    oldProduct.setDescricao(produtoResource.getDescricao());
                    oldProduct.setValor(produtoResource.getValor());
                    oldProduct.setQuantidade(produtoResource.getQuantidade());
                    return this.produtoRepository.save(oldProduct);

                }).get();
        return this.objectMapper.convertValue(produtoResource, Produto.class);
    }

    /**
     * Faz uma Modificação Parcial em um Recurso Existente
     *
     * @param id              Identificador Key
     * @param produtoResource Objeto Entidade Relacional
     * @return Entidade Produto
     */
    public Produto partialUpdate(Long id, ProdutoResource produtoResource) {

        this.produtoRepository.findById(id).map(produto -> {

            if (!(produtoResource.getNome() == null)) {
                produto.setNome(produtoResource.getNome());
            }
            if (!(produtoResource.getDescricao() == null)) {
                produto.setDescricao(produtoResource.getDescricao());
            }
            if (!(produtoResource.getValor() == null)) {
                produto.setValor(produtoResource.getValor());
            }
            if (!(produtoResource.getQuantidade() == null)) {
                produto.setQuantidade(produtoResource.getQuantidade());
            }
            return this.produtoRepository.save(produto);

        }).get();

        return this.objectMapper.convertValue(produtoResource, Produto.class);
    }
}
