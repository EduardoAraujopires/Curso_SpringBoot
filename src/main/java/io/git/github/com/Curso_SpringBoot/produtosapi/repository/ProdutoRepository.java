package io.git.github.com.Curso_SpringBoot.produtosapi.repository;

import io.git.github.com.Curso_SpringBoot.produtosapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
}
