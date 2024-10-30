package com.example.ProjetoAPI.controller;

import com.example.ProjetoAPI.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.ProjetoAPI.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apiCliente")
public class ClienteController {

    @Autowired
    private ClienteRepository cRepo;

    @PostMapping("/cadastrar")
    public void cadastrarCliente(@RequestBody Cliente cliente){
        cRepo.save(cliente);
    }

    @GetMapping("/todos")
    public List<Cliente> buscarTodos(){
        return cRepo.findAll();
    }

    @GetMapping("/buscar/codigo/{codigo}")
    public Optional<Cliente> buscarCodigo(@PathVariable int codigo){
        return cRepo.findById(codigo);
    }

    @GetMapping("/buscar/nome/{nome}")
    public Optional<Cliente> buscarParteNome(@PathVariable String nome){
        return cRepo.findByParteNome(nome);
    }

    @GetMapping("/buscar/email/{email}")
    public Optional<Cliente> buscarEmail(@PathVariable String email){
        return cRepo.findByEmail(email);
    }

    @GetMapping("/buscar/nome/{nome}/{email}")
    public Optional<Cliente> buscarParteNomeEmail(@PathVariable String nome, @PathVariable String email){
        return cRepo.findByParteNomeEmail(nome, email);
    }

    @PutMapping("/atualizar")
    public void atualizarCliente(@RequestBody Cliente cliente){
        cRepo.save(cliente);
    }

    @DeleteMapping("/excluir")
    public void excluirCliente(@RequestBody Cliente cliente){
        cRepo.delete(cliente);
    }

    @DeleteMapping("/excluirPorCodigo/{codigo}")
    public void excluirClientePorCodigo(@RequestBody int codigo){
        cRepo.deleteById(codigo);
    }

}
