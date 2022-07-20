package br.com.gep.biblioteca.dtos.inputs;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroInput {
	
	@NotNull(message = "Titulo é obrigatório")
	private String titulo;
	
	@NotNull(message = "Ano de lançamento é obrigatório")
	private Integer anoLancamento;
	
	@NotEmpty(message = "Necessário pelo menos um autor")
	private List<Long> idsAutores;
	
	
}