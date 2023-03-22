package com.example.yarnshop.validations.passwordMatcher;


import com.example.yarnshop.models.dtos.UserRegisterDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

public class PasswordMatcher implements ConstraintValidator<PasswordMatch, UserRegisterDto> {

    private String first;
    private String second;
    private String message;

    @Override
    public void initialize(PasswordMatch constraintAnnotation) {
        this.first = constraintAnnotation.first();
        this.second = constraintAnnotation.second();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(UserRegisterDto userRegisterDto, ConstraintValidatorContext context) {
        BeanWrapper beanWrapper = PropertyAccessorFactory.
                forBeanPropertyAccess(userRegisterDto);

        Object firstValue = beanWrapper.getPropertyValue(this.first);
        Object secondValue = beanWrapper.getPropertyValue(this.second);

        boolean valid;

        if (firstValue == null) {
            valid = secondValue == null;
        } else {
            valid = firstValue.equals(secondValue);
        }

        if (!valid) {
            context.
                    buildConstraintViolationWithTemplate(message).
                    addPropertyNode(second).
                    addConstraintViolation().
                    disableDefaultConstraintViolation();
        }

        return valid;
    }
}