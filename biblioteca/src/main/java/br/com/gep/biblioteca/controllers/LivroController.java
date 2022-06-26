package br.com.gep.biblioteca.controllers;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gep.biblioteca.inputs.LivroInput;
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
	public void cadastrarLivro(@RequestBody LivroInput livroInput) {
		Livro livro = livroService.coverterInput(livroInput);
		livroRepository.save(livro);
	}
	
	@GetMapping
	public List<LivroOutput> listaTodosLivros() {
		List<Livro> listalivros = livroRepository.findAll();
		
		return livroService.converterLista(listalivros);
	}
	
	@GetMapping("/{id}")
	public Optional<Livro> buscaLivroPeloId(@PathVariable Long id) {
		return livroRepository.findById(id);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public Livro alteraLivro(@PathVariable Long id, @RequestBody LivroInput livroInput) {
		Livro livro = livroInput.atualizar(id, livroRepository, livroService);
		
		return livro;
	}
	
	@DeleteMapping("/{id}")
	public void deletaLivro(@PathVariable Long id) {
		livroRepository.deleteById(id);
	}
	
	@GetMapping("/autor/{id}")
	public List<Livro> buscaLivrosPorAutor(@PathVariable Long id){
		List<Livro> livrosDoAutor = livroRepository.findByAutoresId(id);
		return livrosDoAutor;
	}
	
}