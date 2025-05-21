/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pascal.orz.cn.example.javaee.commons.validators;

import pascal.orz.cn.example.javaee.commons.annotations.Required;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RequiredValidator implements ConstraintValidator<Required, String> {

    @Override
    public void initialize(Required constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        } else if (value.trim().isEmpty()) {
            return false;
        }
        return true;
    }

}
