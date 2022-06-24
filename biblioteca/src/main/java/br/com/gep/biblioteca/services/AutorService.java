package br.com.gep.biblioteca.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.gep.biblioteca.models.Autor;
import br.com.gep.biblioteca.outputs.AutorOutput;

@Service
public class AutorService {
	
	public List<AutorOutput> converterLista(List<Autor> autores){
		return autores.stream().map(AutorOutput::new).collect(Collectors.toList());
	}

	public Autor coverterInput(AutorOutput autorOutput) {
		Autor autor = new Autor(autorOutput.getNome(), autorOutput.getBiografia());
		
		return autor;
	}

}
