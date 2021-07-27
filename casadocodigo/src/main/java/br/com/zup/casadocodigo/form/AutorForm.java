package br.com.zup.casadocodigo.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.zup.casadocodigo.config.validation.Unique;
import br.com.zup.casadocodigo.model.Autor;
import br.com.zup.casadocodigo.model.Categoria;

public class AutorForm {
	
	@NotBlank
	private String nome;
	
	@Email @NotBlank
	@Unique(domainClass = Autor.class, fieldName = "email")
	private String email;
	
	@NotBlank @Length(max = 400)
	private String descricao;

	public AutorForm(String nome, String email, String descricao){
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}
	
	public Autor converter(){
		return new Autor(nome, email, descricao);
	}
	
	
}
