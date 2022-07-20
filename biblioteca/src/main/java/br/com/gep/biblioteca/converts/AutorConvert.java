package br.com.gep.biblioteca.converts;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.gep.biblioteca.dtos.inputs.AutorInput;
import br.com.gep.biblioteca.dtos.outputs.AutorOutput;
import br.com.gep.biblioteca.entities.AutorEntity;

@Component
public class AutorConvert {

	@Autowired
	private ModelMapper modelMapper;

	public AutorEntity inputToEntity(AutorInput autorInput) {
		AutorEntity autorCriado = modelMapper.map(autorInput, AutorEntity.class);
		return autorCriado;
	}

	public AutorOutput entityToOutput(AutorEntity autorCriado) {
		AutorOutput autorOutput = modelMapper.map(autorCriado, AutorOutput.class);
		return autorOutput;
	}

	public void copyInputToEntity(AutorEntity autorEncontrado, AutorInput autorInput) {
		modelMapper.map(autorInput, autorEncontrado);

	}

	public Page<AutorOutput> converterLista(Page<AutorEntity> listaAutores) {
	 return listaAutores.map(this::entityToOutput); 
	 }

}
