package br.com.gep.biblioteca.dtos.outputs;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroOutput {
	
	private String titulo;
	
	private Integer anoLancamento;
	
	private List<AutorOutput> autores;
	
}