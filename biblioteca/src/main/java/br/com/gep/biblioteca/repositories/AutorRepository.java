package br.com.gep.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gep.biblioteca.entities.AutorEntity;

public interface AutorRepository extends JpaRepository<AutorEntity, Long>{

}
