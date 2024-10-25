package com.example.ProjetoAPI.repository;

import com.example.ProjetoAPI.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

    public Optional<Cliente> findByEmail (String email);

    @Query("SELECT c from Cliente c where c.nome like ?1%")
    public Optional<Cliente> findByParteNome (String nome);

    @Query("SELECT c FROM Cliente c WHERE c.nome LIKE ?1% AND c.email LIKE %?2%")
    public Optional<Cliente> findByParteNomeEmail (String nome, String email);
}
