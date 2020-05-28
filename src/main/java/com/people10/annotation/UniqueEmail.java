package com.people10.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

import com.people10.validator.UniqEmailValidator;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = { UniqEmailValidator.class})
public @interface UniqueEmail {
	
	 //error message  
    public String message();  
    //represents group of constraints     
    public Class<?>[] groups() default {};  
    //represents additional information about annotation  
    public Class<? extends Payload>[] payload() default {};  

}
