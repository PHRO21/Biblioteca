package br.com.gep.biblioteca.inputs;

import br.com.gep.biblioteca.models.Autor;
import br.com.gep.biblioteca.repositories.AutorRepository;

public class AutorInput {

	private String nome;
	private String biografia;


	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public Autor atualizar(Long id, AutorRepository autorRepository) {
		Autor autor = autorRepository.findById(id).get();
		autor.setNome(this.nome);
		autor.setBiografia(this.biografia);
		return autor;
	}

}
