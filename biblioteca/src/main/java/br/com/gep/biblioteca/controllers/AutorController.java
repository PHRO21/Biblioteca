package br.com.gep.biblioteca.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.gep.biblioteca.configs.ControllerConfig;
import br.com.gep.biblioteca.converts.AutorConvert;
import br.com.gep.biblioteca.converts.LivroConvert;
import br.com.gep.biblioteca.dtos.inputs.AutorInput;
import br.com.gep.biblioteca.dtos.outputs.AutorOutput;
import br.com.gep.biblioteca.dtos.outputs.LivroOutput;
import br.com.gep.biblioteca.entities.AutorEntity;
import br.com.gep.biblioteca.entities.LivroEntity;
import br.com.gep.biblioteca.services.AutorService;
import br.com.gep.biblioteca.services.LivroService;

@RestController
@RequestMapping(ControllerConfig.PRE_URL + "/autores")
public class AutorController {

	@Autowired
	private AutorConvert autorConvert;
	
	@Autowired
	private AutorService autorService;
	
	@Autowired
	private LivroService livroService;
	
	@Autowired
	private LivroConvert livroConvert;

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public AutorOutput cria(@RequestBody @Valid AutorInput autorInput) {
		AutorEntity autorCriado = autorConvert.inputToEntity(autorInput);
		autorService.cria(autorCriado);
		return autorConvert.entityToOutput(autorCriado);
	}

	@GetMapping
	public Page<AutorOutput> listaTodos(Pageable paginacao) {
		Page<AutorEntity> listaAutores = autorService.listaTodos(paginacao);

		return autorConvert.converterLista(listaAutores);
	}

	@PutMapping("/{id}")
	public AutorOutput atualiza(@PathVariable Long id, @RequestBody @Valid AutorInput autorInput) {
		AutorEntity autorEncontrado = autorService.buscaPeloId(id);

		autorConvert.copyInputToEntity(autorEncontrado, autorInput);
		AutorEntity autorAtualizado = autorService.atualiza(autorEncontrado);

		return autorConvert.entityToOutput(autorAtualizado);

	}

	@GetMapping("/{id}")
	public AutorOutput buscaPorId(@PathVariable Long id) {
		AutorEntity autorEncotrado = autorService.buscaPeloId(id);

		return autorConvert.entityToOutput(autorEncotrado);
	}
	
	@GetMapping("/{id}/livros")
	public Page<LivroOutput> buscaLivros(@PathVariable Long id, Pageable paginacao){
		AutorEntity autorEncontrado = autorService.buscaPeloId(id);
		Page<LivroEntity> livros = livroService.buscaPorAutor(autorEncontrado, paginacao);
		return livroConvert.listaEntityToListaOutput(livros);
		
	}

}
