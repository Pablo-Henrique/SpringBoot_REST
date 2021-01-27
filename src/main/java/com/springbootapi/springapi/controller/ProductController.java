package com.springbootapi.springapi.controller;

import com.springbootapi.springapi.dto.ProdutoDTO;
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

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Produto>> getAllProducts() {
        return new ResponseEntity<>(produtoService.getProducts(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
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

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Short id) {

        if (!produtoService.existsId(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.produtoService.deleteId(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<Produto> updateProduct(@PathVariable Short id, @RequestBody Produto productModel) {

        if (!produtoService.existsId(id) || this.produtoService.getOne(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BeanUtils.copyProperties(productModel, this.produtoService, "id");

        return new ResponseEntity<>(this.produtoService.saveProducts(productModel), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/{id}")
    public ResponseEntity<?> partialUpdateName(@PathVariable("id") Short id, @RequestBody Produto produto) {

        var product = this.produtoService.getById(id);

        if(!product.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        produto = product.get();

        if(produto.getId() != null) {
            produto.setValor(produto.getValor());
        }
        this.produtoService.updatePartial(produto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
