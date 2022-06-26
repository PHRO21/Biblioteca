package br.com.gep.biblioteca.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gep.biblioteca.models.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

	List<Livro> findByAutoresId(Long id);

}
