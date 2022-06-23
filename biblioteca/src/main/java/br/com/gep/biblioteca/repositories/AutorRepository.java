package br.com.gep.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gep.biblioteca.models.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{

}
