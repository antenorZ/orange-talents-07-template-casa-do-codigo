package br.com.zup.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.casadocodigo.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
}
