package br.com.zup.casadocodigo.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.casadocodigo.dto.AutorDto;
import br.com.zup.casadocodigo.form.AutorForm;
import br.com.zup.casadocodigo.model.Autor;
import br.com.zup.casadocodigo.repository.AutorRepository;

@RestController
@RequestMapping("/criaAutor")
public class CriaAutor {
	
	@Autowired
	private AutorRepository autorRepository; 
	
	@PostMapping
	public ResponseEntity<AutorDto> criar(@RequestBody @Valid AutorForm autorForm){
		Autor autor = autorForm.converter();
		autorRepository.save(autor);
//		URI uri = uriBuilder.path("/criaAutor/{id}").buildAndExpand(autor.getId()).toUri();
		return ResponseEntity.status(HttpStatus.OK).body(autor.converterDto());
	}
}
