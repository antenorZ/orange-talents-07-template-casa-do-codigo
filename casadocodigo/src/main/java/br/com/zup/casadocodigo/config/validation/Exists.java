package br.com.zup.casadocodigo.config.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
 
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
 
@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = ExistsValidator.class)
public @interface Exists{
 
    String message() default "Não existe nenhum valor cadastrado para o campo especificado";
 
    Class<?>[] groups() default {};
 
    Class<? extends Payload>[] payload() default {};
    
    String fieldName();
    
    Class<?> domainClass();
 }
