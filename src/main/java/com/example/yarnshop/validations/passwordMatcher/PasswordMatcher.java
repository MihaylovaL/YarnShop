package com.example.yarnshop.validations.passwordMatcher;


import com.example.yarnshop.models.dtos.UserRegisterDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatcher implements ConstraintValidator<PasswordMatch, UserRegisterDto> {

    @Override
    public void initialize(PasswordMatch constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserRegisterDto userRegisterDto, ConstraintValidatorContext context) {
        if(userRegisterDto.getPassword() != null &&
                userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())){
            return true;
        }
        context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                .addPropertyNode(userRegisterDto.getConfirmPassword())
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }
}
