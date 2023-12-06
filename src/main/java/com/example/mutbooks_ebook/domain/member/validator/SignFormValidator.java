package com.example.mutbooks_ebook.domain.member.validator;

import com.example.mutbooks_ebook.domain.member.dto.SignupForm;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class SignFormValidator implements ConstraintValidator<CheckPassword, Object> {

    @Override
    public boolean isValid(Object target, ConstraintValidatorContext context) { //실질적으로 유효성을 검증하는 메서드
        // 패턴에 값이 잘 들어갔는 지 value 값으로 확인
        SignupForm signupForm = (SignupForm) target;

        if(!signupForm.getPassword().equals(signupForm.getCheckPassword())){
            return false;
        }
        return true;
    }
}
