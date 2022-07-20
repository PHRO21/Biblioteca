package br.com.gep.biblioteca.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_autores")
@Getter
@Setter
public class AutorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotBlank
	@Column(name = "nome", length = 100)
	private String nome;
	
	@NotBlank
	@Column(name = "biografia",length = 1000)
	private String biografia;

}
