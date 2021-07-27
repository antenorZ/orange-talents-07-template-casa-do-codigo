package br.com.zup.casadocodigo.form;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import br.com.zup.casadocodigo.config.validation.Unique;
import br.com.zup.casadocodigo.model.Autor;
import br.com.zup.casadocodigo.model.Categoria;
import br.com.zup.casadocodigo.model.Livro;
import br.com.zup.casadocodigo.repository.AutorRepository;
import br.com.zup.casadocodigo.repository.CategoriaRepository;

public class LivroForm{
	@NotBlank @Unique(domainClass = Livro.class, fieldName = "titulo")
	private String titulo;
	
	@NotBlank @Max(value = 500)
	private String resumo;
	
	private String sumario;
	
	@Min(value = 20)
	private Double preco;
	
	@Min(value = 100)
	private Integer numPaginas;
	
	@NotBlank @Unique(domainClass = Livro.class, fieldName = "isbn")
	private String isbn;
	
	@Future
	private LocalDate dataPublicacao;
	
	@NotBlank
	private String nomeAutor;
	
	@NotBlank
	private String nomeCategoria;
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public void setSumario(String sumario) {
		this.sumario = sumario;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(Integer numPaginas) {
		this.numPaginas = numPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public Livro converter(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
		Autor autor = autorRepository.findBynome(nomeAutor);
		Categoria categoria = categoriaRepository.findBytitulo(nomeCategoria);
		return new Livro(titulo, resumo, sumario, preco, numPaginas, isbn, dataPublicacao, autor, categoria);
	}
	
}
