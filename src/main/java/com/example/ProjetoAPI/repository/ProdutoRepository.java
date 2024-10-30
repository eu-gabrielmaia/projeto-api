package com.example.ProjetoAPI.repository;

import com.example.ProjetoAPI.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto,Integer> {
    public Optional<Produto> findByMarca(String marca);

    @Query("SELECT p from Produto p where p.descricao like ?1%")
    public Optional<Produto> findByParteDescricao(String descricao);

    @Query("SELECT p from Produto p where p.preco < ?1")
    public Optional<Produto> findByRAMenorQue(double preco);

    @Query("SELECT p from Produto p where p.preco < ?1")
    public Optional<Produto> findByPrecoAndMarca(String marca, double preco);
}
