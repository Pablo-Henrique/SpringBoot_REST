package com.springbootapi.springapi.controller;

import com.springbootapi.springapi.model.Produto;
import com.springbootapi.springapi.service.ProdutoService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProdutoService produtoService;

    public ProductController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getAllProducts() {
        return new ResponseEntity<>(produtoService.getProducts(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Produto>> getId(@PathVariable Short id) {

        if (produtoService.existsId(id)) {
            return new ResponseEntity<>(produtoService.getById(id), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Produto> createProduct(@RequestBody Produto productModel) {
        return new ResponseEntity<>(produtoService.saveProducts(productModel), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Short id) {

        if (!produtoService.existsId(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.produtoService.deleteId(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Produto> updateProduct(@PathVariable Short id, @RequestBody Produto productModel) {

        if (!produtoService.existsId(id) || this.produtoService.getOne(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BeanUtils.copyProperties(productModel, this.produtoService, "id");

        return new ResponseEntity<>(this.produtoService.saveProducts(productModel), HttpStatus.OK);
    }
}
