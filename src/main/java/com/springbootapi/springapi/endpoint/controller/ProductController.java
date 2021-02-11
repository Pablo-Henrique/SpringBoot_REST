package com.springbootapi.springapi.endpoint.controller;

import com.springbootapi.springapi.endpoint.dto.ProdutoResource;
import com.springbootapi.springapi.endpoint.service.ProdutoService;
import com.springbootapi.springapi.model.Produto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    private ProdutoService produtoService;

    public ProductController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listProducts() {
        return new ResponseEntity<>(produtoService.listAllProducts(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<?> getId(@PathVariable Long id) {

        if (!produtoService.existsId(id)) {
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(produtoService.getById(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createProduct(@RequestBody Produto produto) {

        return new ResponseEntity<>(produtoService.saveProducts(produto), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {

        if (!produtoService.existsId(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.produtoService.deleteId(id);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody @Valid ProdutoResource newProductResource) {

        if (!produtoService.existsId(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(this.produtoService.updateProduto(id, newProductResource), HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/{id}")
    public ResponseEntity<?> partialUpdate(@PathVariable("id") Long id, @RequestBody ProdutoResource produtoResource) {

        if (!produtoService.existsId(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(this.produtoService.partialUpdate(id, produtoResource), HttpStatus.OK);
    }

}












