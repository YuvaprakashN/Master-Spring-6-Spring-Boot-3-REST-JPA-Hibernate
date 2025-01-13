package com.eazybytes.eazyschool.eazyschool.annotation;


import com.eazybytes.eazyschool.eazyschool.validations.PasswordStrengthValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Constraint(validatedBy = {PasswordStrengthValidator.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordValidator {
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String message() default "Please choose strong password";
}
