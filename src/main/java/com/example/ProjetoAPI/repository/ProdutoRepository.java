package com.example.ProjetoAPI.repository;

import com.example.ProjetoAPI.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Integer> {
}
