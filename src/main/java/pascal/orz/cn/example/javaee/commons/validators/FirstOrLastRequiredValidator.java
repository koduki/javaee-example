/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pascal.orz.cn.example.javaee.commons.validators;

import pascal.orz.cn.example.javaee.commons.annotations.FirstOrLastRequired;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import pascal.orz.cn.example.javaee.apps.model.Users;

public class FirstOrLastRequiredValidator implements ConstraintValidator<FirstOrLastRequired, Users> {

    @Override
    public void initialize(FirstOrLastRequired constraintAnnotation) {
    }

    @Override
    public boolean isValid(Users value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        } else if (value.getFirstName() == null) {
            return false;
        } else if (value.getFirstName().trim().isEmpty()) {
            return false;
        }
        return true;
    }

}
