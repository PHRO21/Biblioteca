package br.com.gep.biblioteca.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.gep.biblioteca.configs.ControllerConfig;
import br.com.gep.biblioteca.converts.LivroConvert;
import br.com.gep.biblioteca.dtos.inputs.LivroInput;
import br.com.gep.biblioteca.dtos.outputs.LivroOutput;
import br.com.gep.biblioteca.entities.LivroEntity;
import br.com.gep.biblioteca.services.LivroService;

@RestController
@RequestMapping(ControllerConfig.PRE_URL + "/livros")
public class LivroController {

	@Autowired
	private LivroConvert livroConvert;
	@Autowired
	private LivroService livroService;

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public LivroOutput cadastrarLivro(@RequestBody @Valid LivroInput livroInput) {
		LivroEntity livroCriado = livroConvert.inputToEntity(livroInput);

		livroService.cria(livroCriado);

		return livroConvert.entityToOutput(livroCriado);
	}

	@PutMapping("/{id}")
	public LivroOutput alterar(@PathVariable Long id, @RequestBody @Valid LivroInput livroInput) {
		LivroEntity livroLocalizado = livroService.buscaPeloId(id);

		livroConvert.copyInputToEntity(livroLocalizado, livroInput);

		LivroEntity livroAlterado = livroService.altera(livroLocalizado);

		return livroConvert.entityToOutput(livroAlterado);
	}

	@GetMapping
	public Page<LivroOutput> listaTodosLivros(Pageable paginacao) {
		Page<LivroEntity> livros = livroService.listaTodos(paginacao);

		return livroConvert.listaEntityToListaOutput(livros);
	}

	@GetMapping("/{id}")
	public LivroOutput buscaLivroPeloId(@PathVariable Long id) {
		LivroEntity livroEncontrado = livroService.buscaPeloId(id);

		return livroConvert.entityToOutput(livroEncontrado);
	}
	
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}") 
	public void deletaLivro(@PathVariable Long id){ 
		livroService.deletar(id);
	}
}