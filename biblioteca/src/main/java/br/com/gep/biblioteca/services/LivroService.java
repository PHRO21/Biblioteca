package br.com.gep.biblioteca.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gep.biblioteca.inputs.LivroInput;
import br.com.gep.biblioteca.models.Autor;
import br.com.gep.biblioteca.models.Livro;
import br.com.gep.biblioteca.outputs.LivroOutput;
import br.com.gep.biblioteca.repositories.AutorRepository;
import br.com.gep.biblioteca.repositories.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private AutorRepository autorRepository;

	public List<LivroOutput> converterLista(List<Livro> livros){
		return livros.stream().map(LivroOutput::new).collect(Collectors.toList());
	}

	public Livro coverterInput(LivroInput livroInput) {
		Livro livro = new Livro(livroInput.getTitulo(), livroInput.getAnoLancamento(), converteIdAutores(livroInput.getIdsAutores()));
		return livro;
	}
	
	public List<Autor> converteIdAutores(List<Long> idsAutores) {
		List<Autor> autores = new ArrayList<>();
		
		for (Long id : idsAutores) {
			Autor autorEncontrado = autorRepository.findById(id).get();
			autores.add(autorEncontrado);
		}
		return autores;
	}


}