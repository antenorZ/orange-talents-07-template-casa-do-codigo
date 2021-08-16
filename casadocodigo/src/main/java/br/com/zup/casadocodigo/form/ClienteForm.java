package br.com.zup.casadocodigo.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import br.com.zup.casadocodigo.config.validation.CPFOrCNPJ;
import br.com.zup.casadocodigo.config.validation.Exists;
import br.com.zup.casadocodigo.config.validation.Unique;
import br.com.zup.casadocodigo.model.Cliente;
import br.com.zup.casadocodigo.model.Estado;
import br.com.zup.casadocodigo.model.Pais;
import br.com.zup.casadocodigo.repository.EstadoRepository;
import br.com.zup.casadocodigo.repository.PaisRepository;

public class ClienteForm {
	@NotNull
	private String nome;
	
	@NotNull
	private String sobrenome;
	
	@Email @Unique(domainClass = Cliente.class, fieldName = "email")
	private String email;
	
	@NotNull @Unique(domainClass = Cliente.class, fieldName = "documento")
	@CPFOrCNPJ
	private String documento;
	
	@NotNull
	private String endereco;
	
	
	private String complemento;
	
	@NotNull
	private String cidade;
	
	@NotNull
	@Exists(domainClass = Pais.class, fieldName = "id")
	private Long idPais;
	
	@Exists(domainClass = Estado.class, fieldName = "id")
	private Long idEstado;
	
	@NotNull
	private String telefone;
	
	@NotNull
	private String cep;
	
	public Cliente converter(PaisRepository paisRepository, EstadoRepository estadoRepository) {
		Pais pais = paisRepository.getById(idPais);
		if(idEstado == null) {
			return new Cliente(nome, sobrenome, email, documento, endereco, complemento, cidade, pais, telefone, cep);

		}
		else {
			Estado estado = estadoRepository.getById(idEstado);
			return new Cliente(nome, sobrenome, email, documento, endereco, complemento, cidade, pais, estado, telefone, cep);
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Long getIdPais() {
		return idPais;
	}

	public void setIdPais(Long idPais) {
		this.idPais = idPais;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
}
