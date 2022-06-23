package br.com.gep.biblioteca.inputs;

import br.com.gep.biblioteca.models.Autor;
import br.com.gep.biblioteca.models.Livro;

public class LivroInput {
	
	private String titulo;
	private String anoLancamento;
	private Autor autor;
	
	public LivroInput(Livro livro) {
		this.titulo = livro.getTitulo();
		this.anoLancamento = livro.getAnoLancamento();
		this.autor = livro.getAutor();
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAnoLancamento() {
		return anoLancamento;
	}
	public void setAnoLancamento(String anoLancamento) {
		this.anoLancamento = anoLancamento;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	

}
