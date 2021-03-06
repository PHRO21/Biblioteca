package br.com.gep.biblioteca.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gep.biblioteca.entities.AutorEntity;
import br.com.gep.biblioteca.entities.LivroEntity;

public interface LivroRepository extends JpaRepository<LivroEntity, Long> {

	Page<LivroEntity> findByAutores(AutorEntity autorEncontrado, Pageable paginacao);

}
