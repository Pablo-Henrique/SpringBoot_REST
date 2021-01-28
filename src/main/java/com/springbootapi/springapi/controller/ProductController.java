package com.springbootapi.springapi.controller;

import com.springbootapi.springapi.model.Produto;
import com.springbootapi.springapi.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {


    // Injeção Dependencia
    private ProdutoService produtoService;

    public ProductController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }


    //Controllers
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listProducts() {
        return new ResponseEntity<>(produtoService.getAllProducts(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<?> getId(@PathVariable Long id) {

        if (produtoService.existsId(id)) {
            return new ResponseEntity<>(produtoService.getById(id), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createProduct(@RequestBody Produto productModel) {
        return new ResponseEntity<>(produtoService.saveProducts(productModel), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {

        if (!produtoService.existsId(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.produtoService.deleteId(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody Produto newProduct) {

        if (!produtoService.existsId(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(this.produtoService.getById(id)
                .map(oldProduct -> {

                    oldProduct.setNome(newProduct.getNome());
                    oldProduct.setDescricao(newProduct.getDescricao());
                    oldProduct.setValor(newProduct.getValor());
                    oldProduct.setQuantidade(newProduct.getQuantidade());
                    return this.produtoService.saveProducts(oldProduct);

                }).orElseGet(() -> {
                    newProduct.getId();
                    return this.produtoService.saveProducts(newProduct);
                }), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/{id}")
    public ResponseEntity<?> partialUpdateName(@PathVariable("id") Long id, @RequestBody Produto produto) {

        var identify = produtoService.getById(id);

        if(!identify.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {

            Produto product = identify.get();

            if(produto.getNome() != null) {
                product.setNome(produto.getNome());
            }
            if(produto.getDescricao() != null) {
                product.setDescricao(produto.getDescricao());
            }
            if(produto.getValor() != null) {
                product.setValor(produto.getValor());
            }
            if(produto.getQuantidade() > 0) {
                product.setQuantidade(produto.getQuantidade());
            }
            this.produtoService.saveProducts(product);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
