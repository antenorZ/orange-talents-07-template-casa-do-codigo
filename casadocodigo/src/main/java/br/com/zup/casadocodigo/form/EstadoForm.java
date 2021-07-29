package br.com.zup.casadocodigo.form;

import javax.validation.constraints.NotNull;

import br.com.zup.casadocodigo.config.validation.UniqueCountry;
import br.com.zup.casadocodigo.model.Estado;
import br.com.zup.casadocodigo.model.Pais;
import br.com.zup.casadocodigo.repository.PaisRepository;

public class EstadoForm {
	
	@NotNull
	private String nome;
	
	@UniqueCountry
	@NotNull
	private Long idPais;
	
	public EstadoForm(String nome, Long idPais) {
		super();
		this.nome = nome;
		this.idPais = idPais;
	}
	
	public Estado converter(PaisRepository paisRepository) {
		Pais pais = paisRepository.getById(idPais);
		return new Estado(nome, pais);
	}
}
