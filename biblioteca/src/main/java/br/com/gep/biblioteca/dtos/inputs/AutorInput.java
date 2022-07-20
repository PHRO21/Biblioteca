package br.com.gep.biblioteca.dtos.inputs;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AutorInput {

	@NotBlank(message = "Nome é obrigatório")
	private String nome;
	
	@NotBlank(message = "Biografia é obrigatória")
	private String biografia;

}
