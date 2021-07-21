package br.com.zup.casadocodigo.config.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
 
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
 
@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = UniqueValidator.class)
public @interface Unique{
 
    String message() default "Email já cadastrado.";
 
    Class<?>[] groups() default {};
 
    Class<? extends Payload>[] payload() default {};
 
    String value() default "";
}