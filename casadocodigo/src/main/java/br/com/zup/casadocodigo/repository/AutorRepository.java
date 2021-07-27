package br.com.zup.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.casadocodigo.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{

	Optional<Autor> findByemail(String email);
	
	Autor findBynome(String nome);

	boolean existsByemail(String email);
	
}
