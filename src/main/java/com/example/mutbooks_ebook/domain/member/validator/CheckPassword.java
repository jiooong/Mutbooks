package com.example.mutbooks_ebook.domain.member.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = {SignFormValidator.class}) //무엇으로 검증할지
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER}) // 누구에게 사용할지
@Retention(RUNTIME) //언제까지 어노테이션을 유지할지
public @interface CheckPassword {
    String message() default "2개의 패스워드가 일치하지 않습니다."; //검사에 실패한 경우 전달하는 메시지

    Class<?>[] groups() default { }; //어느 대상까지 검사를 할것인지

    Class<? extends Payload>[] payload() default { }; //검증 시 전달될 메타정보

    String text1();

    String text2();
}
