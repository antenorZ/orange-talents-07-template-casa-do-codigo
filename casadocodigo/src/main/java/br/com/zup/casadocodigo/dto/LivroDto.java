package br.com.zup.casadocodigo.dto;

public class LivroDto{
	private Long id;
	
	private String titulo;
	
	public LivroDto(Long id, String titulo) {
		this.id = id;
		this.titulo = titulo;
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}	
}
