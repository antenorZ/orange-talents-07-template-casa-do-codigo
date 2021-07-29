package br.com.zup.casadocodigo.model;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.zup.casadocodigo.dto.ClienteDto;
import br.com.zup.casadocodigo.dto.EstadoDto;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String email;
	
	private String sobrenome;
	
	private String documento;
	
	private String endereco;
	
	private String complemento;
	
	private String cidade;
	
	@ManyToOne
	private Pais pais;
	
	@ManyToOne
	private Estado estado;
	
	private String telefone;
	
	private String cep;
	
	public Cliente (){
		super();
	}

	public Cliente(String nome, String sobrenome, String email, String documento, String endereco, String complemento, String cidade,
			Pais pais, Estado estado, String telefone, String cep) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.estado = estado;
		this.telefone = telefone;
		this.cep = cep;
	}
	
	public Cliente(String nome, String sobrenome, String email, String documento, String endereco, String complemento, String cidade,
			Pais pais, String telefone, String cep) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.telefone = telefone;
		this.cep = cep;
	}
	
	public ClienteDto converterDto() {
		return new ClienteDto(id);
	}
	
	
}
