package br.com.gep.biblioteca.converts;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.gep.biblioteca.dtos.inputs.LivroInput;
import br.com.gep.biblioteca.dtos.outputs.LivroOutput;
import br.com.gep.biblioteca.entities.LivroEntity;
import br.com.gep.biblioteca.services.LivroService;

@Component
public class LivroConvert {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private LivroService livroService;

	public LivroEntity inputToEntity(@Valid LivroInput livroInput) {
		LivroEntity livroCriado = modelMapper.map(livroInput, LivroEntity.class);
		
		livroService.converteIdsAutorParaAutores(livroInput, livroCriado);
		
		return livroCriado;
	}

	public LivroOutput entityToOutput(LivroEntity livroCriado) {
		return modelMapper.map(livroCriado, LivroOutput.class);
	}


	public void copyInputToEntity(LivroEntity livroEntity, @Valid LivroInput livroInput) {
		modelMapper.map(livroInput, livroEntity);
		livroService.converteIdsAutorParaAutores(livroInput, livroEntity);
	}


	public Page<LivroOutput> listaEntityToListaOutput(Page<LivroEntity> livros) {
		return livros.map(this::entityToOutput);
		
	}


}
