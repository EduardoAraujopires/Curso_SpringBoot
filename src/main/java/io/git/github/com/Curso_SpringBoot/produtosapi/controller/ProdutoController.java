package io.git.github.com.Curso_SpringBoot.produtosapi.controller;

import io.git.github.com.Curso_SpringBoot.produtosapi.model.Produto;
import io.git.github.com.Curso_SpringBoot.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto salve (@RequestBody Produto produto){
        System.out.println("Produto Salvo: " + produto);

       var id = UUID.randomUUID().toString();
        produto.setId(id);
        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping("/{id}")
    public Produto obterPorId(@PathVariable("id")String id){
       return produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable ("id") String id){
        produtoRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public void atualizarPorId(@PathVariable("id") String id, @RequestBody Produto produto){
        produto.setId(id);
        produtoRepository.save(produto);
    }

    @GetMapping
    public List<Produto> BuscarPorParametros(@RequestParam("nome") String nome){
        return produtoRepository.findByNome(nome);
    }
}
