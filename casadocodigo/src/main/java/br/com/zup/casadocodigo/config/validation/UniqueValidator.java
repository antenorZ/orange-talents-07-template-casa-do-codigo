package br.com.zup.casadocodigo.config.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.zup.casadocodigo.repository.AutorRepository;

public class UniqueValidator implements ConstraintValidator<Unique, String> {
 
	@Autowired
	private AutorRepository autorRepository;
	
    private String value;
 
    @Override
    public void initialize(Unique constraintAnnotation) {
        this.value = constraintAnnotation.value();
    }
 
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
    	if(autorRepository.existsByemail(value)) {
    		return false;
    	}
    	else {
    		return true;
    	}
    }
}