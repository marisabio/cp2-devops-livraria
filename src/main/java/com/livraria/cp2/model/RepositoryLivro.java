package com.livraria.cp2.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryLivro extends JpaRepository<Livro, Long> {
    Page<Livro> findAll(Pageable pageable);
}
