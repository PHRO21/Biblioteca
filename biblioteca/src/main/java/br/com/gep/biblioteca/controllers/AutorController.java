package br.com.gep.biblioteca.controllers;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gep.biblioteca.inputs.AutorInput;
import br.com.gep.biblioteca.models.Autor;
import br.com.gep.biblioteca.outputs.AutorOutput;
import br.com.gep.biblioteca.repositories.AutorRepository;
import br.com.gep.biblioteca.services.AutorService;

@RestController
@RequestMapping("/biblioteca/autor")
public class AutorController {
	
	@Autowired
	private AutorRepository autorRepository;
	@Autowired
	private AutorService autorService;
	
	@PostMapping
	public void cadastraAutor(@RequestBody AutorInput autorInput) {
		Autor autor = autorService.coverterInput(autorInput);
		autorRepository.save(autor);
	}
	
	@GetMapping
	public List<AutorOutput> listaTodosAutores() {
		List<Autor> listaAutores = autorRepository.findAll();
		
		return autorService.converterLista(listaAutores);
	}
	
	@GetMapping("/{id}")
	public Optional<Autor> buscaAutorPeloId(@PathVariable Long id) {
		return autorRepository.findById(id);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public Autor alteraAutor(@PathVariable Long id, @RequestBody AutorInput input) {
		Autor autor = input.atualizar(id, autorRepository);
			
		return autor;
	}
	
}