package br.com.zup.casadocodigo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.zup.casadocodigo.dto.DetalhesLivroDto;
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
	@Transactional
	public ResponseEntity<LivroDto> criarCategorias(@RequestBody @Valid LivroForm livroForm){
		Livro livro = livroForm.converter(autorRepository, categoriaRepository);
		livroRepository.save(livro);
		return ResponseEntity.status(HttpStatus.OK).body(livro.converterDto());
	}
	
	@GetMapping
	public List<LivroDto> lista(Long id) {
		List<Livro> livros = livroRepository.findAll();
		return LivroDto.converter(livros);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesLivroDto> detalhar(@PathVariable Long id) {
		Optional<Livro> livro = livroRepository.findById(id);
		if (livro.isPresent()) {
			return ResponseEntity.ok(new DetalhesLivroDto(livro.get()));
		}
		return ResponseEntity.notFound().build();
	}
}
