package br.com.gep.biblioteca.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.gep.biblioteca.inputs.LivroInput;
import br.com.gep.biblioteca.models.Livro;
import br.com.gep.biblioteca.outputs.LivroOutput;

@Service
public class LivroService {

		public List<LivroOutput> converterLista(List<Livro> livros){
			return livros.stream().map(LivroOutput::new).collect(Collectors.toList());
		}

		public Livro coverterInput(LivroInput livroInput) {
			Livro livro = new Livro(livroInput.getTitulo(), livroInput.getAnoLancamento(), livroInput.getAutor());
			return livro;
		}


}