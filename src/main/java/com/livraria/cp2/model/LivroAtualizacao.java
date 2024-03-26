package com.livraria.cp2.model;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record LivroAtualizacao(
        @NotNull
        Long livroId,
        String livroTitulo,
        String livroAutor,
        Long livroAnoPublicacao) {

}
