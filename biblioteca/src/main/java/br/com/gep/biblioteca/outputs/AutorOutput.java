package br.com.gep.biblioteca.outputs;


import br.com.gep.biblioteca.models.Autor;

public class AutorOutput {
	
	private Long id;
	private String nome;
	private String biografia;
	
	public AutorOutput() {
		
	}

	
	public AutorOutput(Autor autor) {
		this.id = autor.getId();
		this.nome = autor.getNome();
		this.biografia = autor.getBiografia();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getBiografia() {
		return biografia;
	}
	
	
	
}