package br.com.zup.casadocodigo.form;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zup.casadocodigo.config.validation.Unique;
import br.com.zup.casadocodigo.model.Autor;
import br.com.zup.casadocodigo.model.Categoria;
import br.com.zup.casadocodigo.model.Livro;
import br.com.zup.casadocodigo.repository.AutorRepository;
import br.com.zup.casadocodigo.repository.CategoriaRepository;

public class LivroForm{
	@NotBlank @NotNull @Unique(domainClass = Livro.class, fieldName = "titulo")
	private String titulo;
	
	@NotBlank @Length(max = 500)
	private String resumo;
	
	private String sumario;
	
	@Min(value = 20) @NotNull 
	private Double preco;
	
	@Min(value = 100) @NotNull 
	private Integer numPaginas;
	
	@NotBlank @NotNull @Unique(domainClass = Livro.class, fieldName = "isbn")
	private String isbn;
	
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private LocalDate dataPublicacao;
	
	@NotBlank @NotNull
	private String nomeAutor;
	
	@NotBlank @NotNull
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

	public String getNomeAutor() {
		return nomeAutor;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public Livro converter(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
		Autor autor = autorRepository.findBynome(nomeAutor);
		Categoria categoria = categoriaRepository.findBytitulo(nomeCategoria);
		Assert.state(autor!=null,"Não foi encontrado autor com o nome especificado");
		Assert.state(categoria!=null,"Não foi encontrada categoria com o nome especificado");
		return new Livro(titulo, resumo, sumario, preco, numPaginas, isbn, dataPublicacao, autor, categoria);
	}
	
}
