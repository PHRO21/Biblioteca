package br.com.gep.biblioteca.inputs;

import java.util.List;

import br.com.gep.biblioteca.models.Livro;
import br.com.gep.biblioteca.repositories.LivroRepository;
import br.com.gep.biblioteca.services.LivroService;

public class LivroInput {

	private String titulo;
	private String anoLancamento;
	private List<Long> idsAutores;

	public LivroInput(Livro livro) {
		this.titulo = livro.getTitulo();
		this.anoLancamento = livro.getAnoLancamento();
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

	public List<Long> getIdsAutores() {
		return idsAutores;
	}

	public void setIdsAutores(List<Long> idsAutores) {
		this.idsAutores = idsAutores;
	}

	public Livro atualizar(Long id, LivroRepository repository, LivroService service) {
		Livro livro = repository.findById(id).get();
		livro.setTitulo(this.titulo);
		livro.setAnoLancamento(this.anoLancamento);
		livro.setAutores(service.converteIdAutores(this.idsAutores));
		return livro;
	}

}