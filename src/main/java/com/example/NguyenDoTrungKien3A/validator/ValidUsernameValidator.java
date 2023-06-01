package com.example.NguyenDoTrungKien3A.validator;

import com.example.NguyenDoTrungKien3A.repository.IUserRepository;
import com.example.NguyenDoTrungKien3A.validator.annotation.ValidUsername;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.ConstraintValidator;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidUsernameValidator implements ConstraintValidator<ValidUsername, String> {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public  boolean isValid(String username, ConstraintValidatorContext context){
        if(userRepository == null)
            return true;
        return userRepository.findByUsername(username) == null;
        }
}
