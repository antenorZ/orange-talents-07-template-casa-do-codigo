package br.com.zup.casadocodigo.dto;

public class ClienteDto {
	private Long id;
	
	public ClienteDto(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
