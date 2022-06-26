package br.com.gep.biblioteca.controllers;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

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
	public void cadastrarLivro(@RequestBody @Valid LivroInput livroInput) {
		Livro livro = livroService.coverterInput(livroInput);
		livroRepository.save(livro);
	}
	
	@GetMapping
	public List<LivroOutput> listaTodosLivros() {
		List<Livro> listalivros = livroRepository.findAll();
		
		return livroService.converterListaToOutput(listalivros);
	}
	
	@GetMapping("/{id}")
	public LivroOutput buscaLivroPeloId(@PathVariable @Valid Long id) {
		LivroOutput livroOutput = livroService.entityToOutput(livroRepository.findById(id).get());
		
		return livroOutput;
	}
	
	@PutMapping("/{id}")
	@Transactional
	public void alteraLivro(@PathVariable @Valid Long id, @RequestBody @Valid LivroInput livroInput) {
		livroInput.atualizar(id, livroRepository, livroService);
		
	}
	
	@DeleteMapping("/{id}")
	public void deletaLivro(@PathVariable @Valid Long id) {
		livroRepository.deleteById(id);
	}
	
	@GetMapping("/autor/{id}")
	public List<LivroOutput> buscaLivrosPorAutor(@PathVariable @Valid Long id){
		List<LivroOutput> livrosDoAutor = livroService.converterListaToOutput(livroRepository.findByAutoresId(id));
		return livrosDoAutor;
	}
	
}