package com.springbootapi.springapi.controller;

import com.springbootapi.springapi.controller.dto.ProdutoResource;
import com.springbootapi.springapi.model.Produto;
import com.springbootapi.springapi.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {

    // Injeção Dependencia
    private ProdutoService produtoService;

    public ProductController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    /*
        @Get Requisita um representação do recurso especificado
        (O mesmo recurso pode ter várias representações, ao exemplo de serviços que retornam XML e JSON)
     */
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

    /*
        @Post Envia uma entidade e requisita que o servidor aceita-a como subordinada do recurso identificado pela URI.
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createProduct(@RequestBody Produto produto) {
        return new ResponseEntity<>(produtoService.saveProducts(produto), HttpStatus.CREATED);
    }

    /*
        @Delete Apaga o recurso especificado
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {

        if (!produtoService.existsId(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.produtoService.deleteId(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
        @Put Requisita que um entidade seja armazenada embaixo da URI fornecida.
        Se a URI se refere a um recurso que já existe, ele é modificado; se a URI não aponta para um recurso existente,
        então o servidor pode criar o recurso com essa URI.
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody @Valid Produto newProduct) {

        if (!produtoService.existsId(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(this.produtoService.updateProduto(id, newProduct), HttpStatus.OK);
    }

    /*
        @Patch Usado para aplicar modificações parciais a um recurso.
     */
    @RequestMapping(method = RequestMethod.PATCH, value = "/{id}")
    public ResponseEntity<?> partialUpdate(@PathVariable("id") Long id, @RequestBody Produto produto) {

        if (!produtoService.existsId(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(this.produtoService.partialUpdate(id, produto), HttpStatus.OK);
    }
}












