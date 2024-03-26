package com.livraria.cp2.model;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record LivroCadastro(
        @NotBlank
        Long livroId,
        @NotBlank
        String livroTitulo,
        @NotBlank
        String livroAutor,
        @NotBlank
        Long livroAnoPublicacao) {

}