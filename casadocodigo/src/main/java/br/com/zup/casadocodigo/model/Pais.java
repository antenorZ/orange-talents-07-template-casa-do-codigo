package br.com.zup.casadocodigo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import br.com.zup.casadocodigo.dto.PaisDto;

@Entity
public class Pais {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	public Pais(){
		
	}
	
	public Pais(String nome) {
		super();
		this.nome = nome;
	}
	
	public PaisDto converterDto() {
		return new PaisDto(nome);
	}
}
