package com.livraria.cp2.controller;

import com.livraria.cp2.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/livros")
@Tag(name = "Livro",description = "CRUD do Livro.")
public class LivroController {

    @Autowired
    private RepositoryLivro repositoryLivro;

    @PostMapping
    @Transactional
    @Operation(summary = "Cadastro de livros", description = "Endpoint do cadastro de novos livros.")
    public ResponseEntity cadastrar(@RequestBody @Valid LivroCadastro dados, UriComponentsBuilder uriBuilder) {
        var livro = new Livro(dados);
        repositoryLivro.save(livro);
        var uri = uriBuilder.path("/livros/{livroId}").buildAndExpand(livro.getLivroId()).toUri();
        return ResponseEntity.created(uri).body(new LivroListagem(livro));
    }

    @GetMapping
    @Operation(summary = "Listagem de livros", description = "Endpoint da listagem de livros cadastrados.")
    public ResponseEntity<Page<LivroListagem>> listar(@PageableDefault(size = 10) Pageable paginacao) {
        var page = repositoryLivro.findAll(paginacao).map((LivroListagem::new));
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{livroId}")
    @Operation(summary = "Exibir livros", description = "Endpoint da exibição de um único livro cadastrado.")
    public ResponseEntity exibir(@PathVariable Long Livro) {
        var cliente = repositoryLivro.getReferenceById(Livro);
        return ResponseEntity.ok(new LivroListagem(cliente));
    }

    @PutMapping
    @Transactional
    @Operation(summary = "Atualizar livro", description = "Endpoint da atualização de um único livro cadastrado.")
    public ResponseEntity atualizar(@RequestBody @Valid LivroAtualizacao dados) {
        var livro = repositoryLivro.getReferenceById(dados.livroId());
        livro.atualizarInformacoes(dados);
        return ResponseEntity.ok(new LivroListagem(livro));
    }

    @DeleteMapping("/{livroId}")
    @Transactional
    @Operation(summary = "Excluir livro", description = "Endpoint da exclusão de um único livro cadastrado.")
    public ResponseEntity excluir(@PathVariable Long Livro) {
        repositoryLivro.deleteById(Livro);
        return ResponseEntity.ok().body("Livro " + Livro + " deletado.");
    }

}

