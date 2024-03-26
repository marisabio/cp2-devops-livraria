package com.livraria.cp2.model;

import java.util.Date;

public record LivroListagem(
        Long livroId,
        String livroTitulo,
        String livroAutor,
        Long livroAnoPublicacao) {

    public LivroListagem(Livro livro) {
        this(livro.getLivroId(), livro.getLivroTitulo(), livro.getLivroAutor(), livro.getLivroAnoPublicacao());
    }

}
