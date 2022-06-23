package br.com.gep.biblioteca.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gep.biblioteca.inputs.LivroInput;
import br.com.gep.biblioteca.models.Autor;
import br.com.gep.biblioteca.models.Livro;
import br.com.gep.biblioteca.outputs.LivroOutput;
import br.com.gep.biblioteca.repositories.LivroRepository;
import br.com.gep.biblioteca.services.LivroService;

@RestController
@RequestMapping("/biblioteca/livros")
public class LivroController {
	
	@Autowired
	private LivroRepository livroRepository;
	@Autowired
	private LivroService livroService;
	
	@PostMapping
	public void cadastrarAutor(@RequestBody LivroInput livroInput) {
		Livro livro = livroService.coverterInput(livroInput);
		livroRepository.save(livro);
	}
	
	@GetMapping
	public List<LivroOutput> listaTodosAutores() {
		List<Livro> listalivros = livroRepository.findAll();
		
		return livroService.converterLista(listalivros);
	}
	
	@GetMapping("/{id}")
	public Optional<Livro> buscaPeloId(@PathVariable Long id) {
		return livroRepository.findById(id);
	}
	
	@PutMapping("/{id}")
	public void alteraAutor(@PathVariable Long id, @RequestBody Livro livro) {
		Optional<Livro> livroInput = livroRepository.findById(id);
		
	}
	
}
