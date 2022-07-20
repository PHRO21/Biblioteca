package br.com.gep.biblioteca.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.gep.biblioteca.dtos.inputs.LivroInput;
import br.com.gep.biblioteca.entities.AutorEntity;
import br.com.gep.biblioteca.entities.LivroEntity;
import br.com.gep.biblioteca.repositories.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private AutorService autorService;

	public void cria(LivroEntity livroCriado) {
		livroRepository.save(livroCriado);
	}

	public LivroEntity buscaPeloId(Long id) {
		
		return livroRepository.findById(id).get();
	}

	public LivroEntity altera(LivroEntity livroLocalizado) {
		return livroRepository.save(livroLocalizado);
	}

	public Page<LivroEntity> buscaPorAutor(AutorEntity autorEncontrado, Pageable paginacao) {
		
		return livroRepository.findByAutores(autorEncontrado, paginacao);
	}
	
	public void converteIdsAutorParaAutores(LivroInput livroInput, LivroEntity livroEntity) {
		List<AutorEntity> autores = new ArrayList<>();
		for (Long idAutor : livroInput.getIdsAutores()) {
			AutorEntity autor = autorService.buscaPeloId(idAutor);
			autores.add(autor);
		}
		livroEntity.setAutores(autores);
	}

	public Page<LivroEntity> listaTodos(Pageable paginacao) {
		return livroRepository.findAll(paginacao);
	}

	public void deletar(Long id) {
		livroRepository.deleteById(id);
	}



}