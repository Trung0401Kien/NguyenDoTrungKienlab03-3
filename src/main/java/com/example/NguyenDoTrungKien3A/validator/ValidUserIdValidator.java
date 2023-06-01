package com.example.NguyenDoTrungKien3A.validator;

import com.example.NguyenDoTrungKien3A.entity.User;
import com.example.NguyenDoTrungKien3A.validator.annotation.ValidUserId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidUserIdValidator implements ConstraintValidator<ValidUserId, User> {
    @Override
    public boolean isValid(User user, ConstraintValidatorContext context){
        if(user == null)
            return true;
        return  user.getId() != null;
    }
}
