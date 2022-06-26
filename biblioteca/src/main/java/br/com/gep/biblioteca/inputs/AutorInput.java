package br.com.gep.biblioteca.inputs;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.gep.biblioteca.models.Autor;
import br.com.gep.biblioteca.repositories.AutorRepository;

public class AutorInput {

	@NotNull @NotBlank
	private String nome;
	@NotNull @Length(min = 10)
	private String biografia;


	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public String getNome() {
		return nome;
	}

	public String getBiografia() {
		return biografia;
	}
	
	public Autor atualizar(Long id, AutorRepository autorRepository) {
		Autor autor = autorRepository.findById(id).get();
		autor.setNome(this.nome);
		autor.setBiografia(this.biografia);
		return autor;
	}

}
