package br.com.zup.casadocodigo.dto;

import java.time.LocalDate;

import br.com.zup.casadocodigo.model.Autor;
import br.com.zup.casadocodigo.model.Categoria;
import br.com.zup.casadocodigo.model.Livro;

public class DetalhesLivroDto {
	
	private String titulo;
	
	private String resumo;
	
	private String sumario;
	
	private Double preco;
	
	private Integer numPaginas;
	
	private String isbn;
	
	private LocalDate dataPublicacao;
	
	private String autor;
	
	private String descricaoAutor;
	
//	private String emailAutor;
	
	private String nomeCategoria;

	public DetalhesLivroDto(Livro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.numPaginas = livro.getNumPaginas();
		this.isbn = livro.getIsbn();
		this.dataPublicacao = livro.getDataPublicacao();
		this.autor = livro.getAutor().getNome();
		this.descricaoAutor = livro.getAutor().getDescricao();
//		this.emailAutor = livro.getAutor().getEmail();
		this.nomeCategoria = livro.getCategoria().getTitulo();
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public Double getPreco() {
		return preco;
	}

	public Integer getNumPaginas() {
		return numPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public String getAutor() {
		return autor;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public String getDescricaoAutor() {
		return descricaoAutor;
	}

//	public String getEmailAutor() {
//		return emailAutor;
//	}

	
	
}
