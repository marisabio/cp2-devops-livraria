package com.livraria.cp2.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "livro")
public class Livro {

    @Id
    private Long livroId;

    private String livroTitulo;
    private String livroAutor;
    private Long livroAnoPublicacao;

    public Livro(LivroCadastro dados) {
        this.livroId = dados.livroId();
        this.livroTitulo = dados.livroTitulo();
        this.livroAutor = dados.livroAutor();
        this.livroAnoPublicacao = dados.livroAnoPublicacao();
    }

    public void atualizarInformacoes(LivroAtualizacao dados) {
        if (dados.livroId() != null) {
            this.livroId = dados.livroId();
        }
        if (dados.livroTitulo() != null) {
            this.livroTitulo = dados.livroTitulo();
        }
        if (dados.livroAutor() != null) {
            this.livroAutor = dados.livroAutor();
        }
        if (dados.livroAnoPublicacao() != null) {
            this.livroAnoPublicacao = dados.livroAnoPublicacao();
        }
    }

}