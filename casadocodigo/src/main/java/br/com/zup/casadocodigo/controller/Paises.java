package br.com.zup.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.dto.PaisDto;
import br.com.zup.casadocodigo.form.PaisForm;
import br.com.zup.casadocodigo.model.Pais;
import br.com.zup.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping("/paises")
public class Paises {
	
	@Autowired
	private PaisRepository paisRepository;
	
	@PostMapping
	public ResponseEntity<PaisDto> criarCategorias(@RequestBody @Valid PaisForm paisForm){
		Pais pais = paisForm.converter();
		paisRepository.save(pais);
		return ResponseEntity.status(HttpStatus.OK).body(pais.converterDto());
	}
}