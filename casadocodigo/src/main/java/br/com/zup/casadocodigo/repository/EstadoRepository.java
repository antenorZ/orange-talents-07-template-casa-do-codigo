package br.com.zup.casadocodigo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.casadocodigo.model.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long>{
	List<Estado> findByPaisId(Long id);
}
