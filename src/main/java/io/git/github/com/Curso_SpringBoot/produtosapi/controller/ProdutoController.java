package io.git.github.com.Curso_SpringBoot.produtosapi.controller;

import io.git.github.com.Curso_SpringBoot.produtosapi.model.Produto;
import io.git.github.com.Curso_SpringBoot.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
