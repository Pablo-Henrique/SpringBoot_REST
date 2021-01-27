package com.springbootapi.springapi.service;

import com.springbootapi.springapi.dto.ProdutoDTO;
import com.springbootapi.springapi.model.Produto;
import com.springbootapi.springapi.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    // Retorna Lista de Produto
    public List<Produto> getProducts() {
        return this.produtoRepository.findAll();
    }

    // Update PatchMapping


    // Retorna produto requisitado pelo ID
    public Optional<Produto> getById(Short id) {
        return this.produtoRepository.findById(id);
    }

    // Salva um Produto
    public Produto saveProducts(Produto productModel) {
        return this.produtoRepository.save(productModel);
    }

    // Atualiza um dado parcial
    public Produto updatePartial(Produto produto) {
        return this.produtoRepository.save(produto);
    }

    // Deleta um produto por ID
    public void deleteId(Short id) {
        this.produtoRepository.deleteById(id);
    }

    // verifica se o ID existe
    public boolean existsId(Short id) {
        return this.produtoRepository.existsById(id);
    }

    // Pega 1 item em banco
    public Produto getOne(Short id) {
        return this.produtoRepository.getOne(id);
    }
}
