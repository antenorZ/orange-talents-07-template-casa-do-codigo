package br.com.zup.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.dto.ClienteDto;
import br.com.zup.casadocodigo.form.ClienteForm;
import br.com.zup.casadocodigo.model.Cliente;
import br.com.zup.casadocodigo.repository.ClienteRepository;
import br.com.zup.casadocodigo.repository.EstadoRepository;
import br.com.zup.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping("/clientes")
public class Clientes {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private PaisRepository paisRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<ClienteDto> criarClientes(@RequestBody @Valid ClienteForm clienteForm){
		Cliente cliente = clienteForm.converter(paisRepository, estadoRepository);
		clienteRepository.save(cliente);
		return ResponseEntity.status(HttpStatus.OK).body(cliente.converterDto());
	}
}
