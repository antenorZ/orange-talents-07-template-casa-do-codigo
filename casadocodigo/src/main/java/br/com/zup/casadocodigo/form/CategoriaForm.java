package br.com.zup.casadocodigo.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import br.com.zup.casadocodigo.config.validation.Unique;
import br.com.zup.casadocodigo.model.Categoria;

public class CategoriaForm {
	@NotNull @NotBlank
	@Unique(domainClass = Categoria.class, fieldName = "titulo")
	private String titulo;
	
	public CategoriaForm(){
		
	}
	
//	@JsonCreator(mode = Mode.PROPERTIES)
	public CategoriaForm(String titulo) {
		super();
		this.titulo = titulo;
	}
	
	public Categoria converter(){
		return new Categoria(titulo);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
}
