package br.com.zup.casadocodigo.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.zup.casadocodigo.dto.AutorDto;

@Entity
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String email;
	
	private String descricao;
	
	private LocalDateTime momentoRegistro = LocalDateTime.now();

	public Autor(){
		
	}
	
	public Autor(String nome, String email, String descricao){
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}
	
	public AutorDto converterDto() {
		return new AutorDto(nome, email, descricao, momentoRegistro);
	}
	
}
