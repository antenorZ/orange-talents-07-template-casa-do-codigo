package br.com.zup.casadocodigo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zup.casadocodigo.dto.LivroDto;

@Entity
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titulo;
	
	private String resumo;
	
	private String sumario;
	
	private Double preco;
	
	private Integer numPaginas;
	
	private String isbn;
	
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private LocalDate dataPublicacao;
	
	@ManyToOne
	private Autor autor;
	
	@ManyToOne
	private Categoria categoria;
	
	public Livro(){
		
	}
	
	public Long getId() {
		return id;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public Livro(String titulo, String resumo, String sumario, Double preco, 
			Integer numPaginas, String isbn, LocalDate dataPublicacao, Autor autor, Categoria categoria){
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numPaginas = numPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.autor = autor;
		this.categoria = categoria;
	}
	
	public LivroDto converterDto(){
		return new LivroDto(Livro.this);
	}
}
