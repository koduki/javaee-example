/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pascal.orz.cn.example.javaee.commons.annotations;

import pascal.orz.cn.example.javaee.commons.validators.FirstOrLastRequiredValidator;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import jakarta.validation.Payload;
import pascal.orz.cn.example.javaee.commons.validators.FirstOrLastRequiredValidator;

@Target({ TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy={FirstOrLastRequiredValidator.class})
public @interface FirstOrLastRequired {

    String message() default "may not be empty2";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}