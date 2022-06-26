package br.com.gep.biblioteca.outputs;

import java.util.List;

import br.com.gep.biblioteca.models.Autor;
import br.com.gep.biblioteca.models.Livro;

public class LivroOutput {
	
	private String titulo;
	private String anoLancamento;
	private List<Autor> autores;
	
	public LivroOutput() {
	}
	
	public LivroOutput(Livro livro) {
		this.titulo = livro.getTitulo();
		this.anoLancamento = livro.getAnoLancamento();
		this.autores = livro.getAutores();
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAnoLancamento() {
		return anoLancamento;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	
	
}