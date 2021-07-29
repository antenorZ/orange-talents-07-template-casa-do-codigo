package br.com.zup.casadocodigo.config.validation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.zup.casadocodigo.repository.EstadoRepository;

public class UniqueCountryValidator implements ConstraintValidator<UniqueCountry, Long>{

//	private Long value;
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private EstadoRepository estadoRepository;
 
//    @Override
//    public void initialize(UniqueCountry constraintAnnotation) {
//        value = constraintAnnotation.value();
//    }
	
	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context){
		return estadoRepository.findByPaisId(value).isEmpty();
	}

}
