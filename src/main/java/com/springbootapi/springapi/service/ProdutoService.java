package com.springbootapi.springapi.service;

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

    public List<Produto> getProducts() {
        return this.produtoRepository.findAll();
    }

    public Optional<Produto> getById(Short id) {
        return this.produtoRepository.findById(id);
    }

    public Produto saveProducts(@RequestBody Produto productModel) {
        return this.produtoRepository.save(productModel);
    }

    public void deleteId(Short id) {
        this.produtoRepository.deleteById(id);
    }

    public boolean existsId(Short id) {
        return this.produtoRepository.existsById(id);
    }
    public Produto getOne(Short id) {
        return this.produtoRepository.getOne(id);
    }
}
