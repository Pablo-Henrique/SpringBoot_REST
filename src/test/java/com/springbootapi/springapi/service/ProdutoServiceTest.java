package com.springbootapi.springapi.service;

import com.springbootapi.springapi.endpoint.service.ProdutoService;
import com.springbootapi.springapi.model.Produto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProdutoServiceTest {

    ProdutoService produtoServiceTest;

    public ProdutoServiceTest(ProdutoService produtoService) {
        this.produtoServiceTest = produtoService;
    }

    @Test
    public void getById() {
        Optional<Produto> pro = produtoServiceTest.getById(5L);

    }

}
