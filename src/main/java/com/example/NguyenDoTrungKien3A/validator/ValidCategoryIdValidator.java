package com.example.NguyenDoTrungKien3A.validator;

import com.example.NguyenDoTrungKien3A.entity.Category;
import com.example.NguyenDoTrungKien3A.validator.annotation.ValidCategoryId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidCategoryIdValidator implements ConstraintValidator<ValidCategoryId, Category>{
    @Override
    public boolean isValid(Category category, ConstraintValidatorContext context) {
        return category != null && category.getId() != null;
    }
}