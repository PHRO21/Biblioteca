package br.com.gep.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gep.biblioteca.models.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
