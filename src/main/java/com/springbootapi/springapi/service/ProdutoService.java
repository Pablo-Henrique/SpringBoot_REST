package com.springbootapi.springapi.service;

import com.springbootapi.springapi.model.Produto;
import com.springbootapi.springapi.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    // Retorna Lista de Produto
    public List<Produto> getAllProducts() {
        return this.produtoRepository.findAll();
    }

    // Retorna produto requisitado pelo ID
    public Optional<Produto> getById(Long id) {
        return this.produtoRepository.findById(id);
    }

    // Salva um Produto
    public Produto saveProducts(Produto productModel) {
        return this.produtoRepository.save(productModel);
    }

    // Deleta um produto por ID
    public void deleteId(Long id) {
        this.produtoRepository.deleteById(id);
    }

    // verifica se o ID existe
    public boolean existsId(Long id) {
        return this.produtoRepository.existsById(id);
    }

    // Pega 1 ID
    public Produto getOne(Long id) {
        return this.produtoRepository.getOne(id);
    }
}
