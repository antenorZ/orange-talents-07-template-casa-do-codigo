package br.com.zup.casadocodigo.form;

import javax.validation.constraints.NotNull;

import br.com.zup.casadocodigo.config.validation.Unique;
import br.com.zup.casadocodigo.model.Pais;

public class PaisForm {
	
	@NotNull
	@Unique(domainClass = Pais.class, fieldName = "nome")
	private String nome;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public PaisForm() {
		
	}

	public PaisForm(String nome) {
		super();
		this.nome = nome;
	}
	
	public Pais converter() {
		return new Pais(nome);
	}
	
}
