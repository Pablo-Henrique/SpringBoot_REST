package com.springbootapi.springapi.repository;

import com.springbootapi.springapi.model.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Short> {

    Optional<Produto> findById(Short id);
}
