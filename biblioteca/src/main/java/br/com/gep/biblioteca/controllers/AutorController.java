package br.com.gep.biblioteca.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gep.biblioteca.models.Autor;
import br.com.gep.biblioteca.outputs.AutorOutput;
import br.com.gep.biblioteca.repositories.AutorRepository;
import br.com.gep.biblioteca.services.AutorService;

@RestController
@RequestMapping("/autor")
public class AutorController {
	
	@Autowired
	private AutorRepository autorRepository;
	@Autowired
	private AutorService autorService;
	
	@PostMapping
	public void cadastrarAutor(@Valid @RequestBody String nome, @Valid @RequestBody String biografia) {
		//AutorDto autor = new AutorDto();
		
	}
	
	@GetMapping
	public List<AutorOutput> listaTodosAutores() {
		List<Autor> listaAutores = autorRepository.findAll();
		
		return autorService.converterLista(listaAutores);
	}
	
	//@GetMapping("/${id}")
	//public Optional<Autor> buscaPeloId(@RequestBody Long id) {
	//	return autorRepository.findById(id);
	//}
}
