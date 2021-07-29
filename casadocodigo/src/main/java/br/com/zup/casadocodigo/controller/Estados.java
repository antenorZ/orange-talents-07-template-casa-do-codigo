package br.com.zup.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.dto.EstadoDto;
import br.com.zup.casadocodigo.form.EstadoForm;
import br.com.zup.casadocodigo.model.Estado;
import br.com.zup.casadocodigo.repository.EstadoRepository;
import br.com.zup.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping("/estados")
public class Estados {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private PaisRepository paisRepository;
	
	@PostMapping
	public ResponseEntity<EstadoDto> criarEstado(@RequestBody @Valid EstadoForm estadoForm){
		Estado estado = estadoForm.converter(paisRepository);
		estadoRepository.save(estado);
		return ResponseEntity.status(HttpStatus.OK).body(estado.converterDto());
	}
}
