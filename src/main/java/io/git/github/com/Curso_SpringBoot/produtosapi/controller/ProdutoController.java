package io.git.github.com.Curso_SpringBoot.produtosapi.controller;

import io.git.github.com.Curso_SpringBoot.produtosapi.model.Produto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @PostMapping
    public Produto salve (@RequestBody Produto produto){
        System.out.println("Produto Salvo: " + produto);
        return produto;
    }
}
