package br.com.zup.casadocodigo.dto;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import br.com.zup.casadocodigo.model.Autor;

public class AutorDto {
	
	private String nome;
	
	private String email;
	
	private String descricao;
	
	private LocalDateTime momentoRegistro;
	
	public AutorDto(String nome, String email, String descricao, LocalDateTime momentoRegistro) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		this.momentoRegistro = momentoRegistro;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDateTime getMomentoRegistro() {
		return momentoRegistro;
	}
	
	
//	public static Page<AutorDto> converter(Page<Autor> autores){
//		return autores.map(AutorDto::new);
//	}
}
