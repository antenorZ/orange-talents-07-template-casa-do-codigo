package br.com.zup.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.dto.LivroDto;
import br.com.zup.casadocodigo.form.LivroForm;
import br.com.zup.casadocodigo.model.Livro;
import br.com.zup.casadocodigo.repository.AutorRepository;
import br.com.zup.casadocodigo.repository.CategoriaRepository;
import br.com.zup.casadocodigo.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
public class Livros {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private AutorRepository autorRepository;
	
	@PostMapping
	public ResponseEntity<LivroDto> criarCategorias(@RequestBody @Valid LivroForm livroForm){
		Livro livro = livroForm.converter(autorRepository, categoriaRepository);
		livroRepository.save(livro);
		return ResponseEntity.status(HttpStatus.OK).body(livro.converterDto());
	}
}
