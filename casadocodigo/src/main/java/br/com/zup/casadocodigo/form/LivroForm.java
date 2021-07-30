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

import br.com.zup.casadocodigo.config.validation.Exists;
import br.com.zup.casadocodigo.config.validation.Unique;
import br.com.zup.casadocodigo.model.Autor;
import br.com.zup.casadocodigo.model.Categoria;
import br.com.zup.casadocodigo.model.Livro;
import br.com.zup.casadocodigo.model.Pais;
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
	
	@NotNull
	@Exists(domainClass = Autor.class, fieldName = "id")
	private Long idAutor;
	
	@NotNull
	@Exists(domainClass = Categoria.class, fieldName = "id")
	private Long idCategoria;	
	
	public Livro converter(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
		Autor autor = autorRepository.getById(idAutor);
		Categoria categoria = categoriaRepository.getById(idCategoria);
		return new Livro(titulo, resumo, sumario, preco, numPaginas, isbn, dataPublicacao, autor, categoria);
	}
	
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

	public Long getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(Long idAutor) {
		this.idAutor = idAutor;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	
}
