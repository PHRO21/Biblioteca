package br.com.gep.biblioteca.outputs;

import java.util.List;

import br.com.gep.biblioteca.models.Autor;
import br.com.gep.biblioteca.models.Livro;

public class LivroOutput {
	
	private Long id;
	private String titulo;
	private String anoLancamento;
	private List<Autor> autor;
	
	public LivroOutput() {
	}
	
	public LivroOutput(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.anoLancamento = livro.getAnoLancamento();
		this.autor = livro.getAutores();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAnoLancamento() {
		return anoLancamento;
	}

	public List<Autor> getAutores() {
		return autor;
	}

	
	
}