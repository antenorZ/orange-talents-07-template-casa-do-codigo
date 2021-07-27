package br.com.zup.casadocodigo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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
	
	private LocalDate dataPublicacao;
	
	@ManyToOne
	private Autor autor;
	
	@OneToOne
	private Categoria categoria;
	
	public Livro(){
		
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
	}
	
	public LivroDto converterDto(){
		return new LivroDto(id, titulo);
	}
}
