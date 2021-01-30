package com.springbootapi.springapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springbootapi.springapi.model.Produto;
import com.springbootapi.springapi.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
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
    public Collection<Produto> getAllProducts() {
        return this.produtoRepository.findAll();
    }

    /**
     *  Retorna uma Entidade passada Pelo ID
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
     * @param id identificador Key
     * @param produto Objeto Entidade Relacional
     * @return Entidade Produto
     */
    public Produto updateProduto(Long id, Produto produto) {

        this.produtoRepository.findById(id)
                .map(oldProduct -> {
                    oldProduct.setNome(produto.getNome());
                    oldProduct.setDescricao(produto.getDescricao());
                    oldProduct.setValor(produto.getValor());
                    oldProduct.setQuantidade(produto.getQuantidade());
                    return this.produtoRepository.save(oldProduct);

                }).get();
        return this.objectMapper.convertValue(produto, Produto.class);
    }

    /**
     * Faz uma Modificação Parcial em um Recurso Existente
     *
     * @param id identificador Key
     * @param produto Objeto Entidade Relacional
     * @return Entidade Produto
     */
    public Produto partialUpdate(Long id, Produto produto) {

        var entity = this.produtoRepository.findById(id).orElseGet(Produto::new);

        if (!entity.getNome().equalsIgnoreCase(produto.getNome())) {
            entity.setNome(produto.getNome());
        }

        if (!entity.getDescricao().equalsIgnoreCase(produto.getDescricao())) {
            entity.setDescricao(produto.getDescricao());
        }

        if (!entity.getValor().equals(produto.getValor())) {
            entity.setValor(produto.getValor());
        }

        if (!entity.getQuantidade().equals(produto.getQuantidade())) {
            entity.setQuantidade(produto.getQuantidade());
        }

        return this.produtoRepository.save(entity);
    }
}
