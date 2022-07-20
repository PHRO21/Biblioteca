package br.com.gep.biblioteca.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.gep.biblioteca.entities.AutorEntity;
import br.com.gep.biblioteca.repositories.AutorRepository;

@Service
public class AutorService {

	@Autowired
	private AutorRepository autorRepository;

	public void cria(AutorEntity autorCriado) {
		autorRepository.save(autorCriado);
	}

	public Page<AutorEntity> listaTodos(Pageable paginacao) {
		Page<AutorEntity> autores = autorRepository.findAll(paginacao);
		return autores;
	}

	public AutorEntity buscaPeloId(Long id) {
		AutorEntity autorEncontrado = autorRepository.findById(id).get();
		return autorEncontrado;
	}

	public AutorEntity atualiza(AutorEntity autorEncontrado) {
		return autorRepository.save(autorEncontrado);
	}

}
