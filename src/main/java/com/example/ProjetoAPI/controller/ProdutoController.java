package com.example.ProjetoAPI.controller;

import com.example.ProjetoAPI.model.Produto;
import com.example.ProjetoAPI.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/apiProduto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository pRepo;

    @PostMapping("/cadastrar")
    public void cadastrarProduto(@RequestBody Produto produto){
        pRepo.save(produto);
    }

    @GetMapping("/todos")
    public List<Produto> buscarTodos(){
        return pRepo.findAll();
    }

    @GetMapping ("/buscar/codigo/{codigo}")
    public Optional<Produto> buscarProduto(@PathVariable int codigo){
        return pRepo.findById(codigo);
    }

    @GetMapping ("/buscar/parteDesc/{descricao}")
    public Optional<Produto> buscarProdutoParteDescricao(@PathVariable String descricao){
        return pRepo.findByParteDescricao(descricao);
    }

    @GetMapping ("/buscar/todosRAmenor/{ra}")
    public Optional<Produto> buscarRAMenorQue(@PathVariable int ra){
        return pRepo.findByRAMenorQue(ra);
    }

    @GetMapping ("/buscar/marca/{marca}")
    public Optional<Produto> buscarMarca(@PathVariable String marca){
        return pRepo.findByMarca(marca);
    }

    @GetMapping ("/buscar/marcaEtodosPrecoMenor/{marca}/{ra}")
    public Optional<Produto> buscarMarcaEPrecoMenor(@PathVariable String marca, @PathVariable double preco){
        return pRepo.findByPrecoAndMarca(marca, preco);
    }

    @PutMapping("/atualizar")
    public void atualizarProduto(@RequestBody Produto produto){
        pRepo.save(produto);
    }

    @DeleteMapping("/excluir")
    public void excluirProduto(@RequestBody Produto produto){
        pRepo.delete(produto);
    }

    @DeleteMapping("/excluirPorCodigo/{codigo}")
    public void excluirProdutoPorCodigo(@RequestBody int codigo){
        pRepo.deleteById(codigo);
    }
}