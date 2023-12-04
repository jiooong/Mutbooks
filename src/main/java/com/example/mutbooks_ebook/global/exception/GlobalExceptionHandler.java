package com.example.mutbooks_ebook.global.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice // 전역에서 발생할 수 있는 예외는 잡아 처리
public class GlobalExceptionHandler  {

    // 컨트롤러 form validation 핸들러
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MethodInvalidResponse> methodInvalidException(
            final MethodArgumentNotValidException e
    ) {
        BindingResult bindingResult = e.getBindingResult();
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(MethodInvalidResponse.builder()
                        .errorCode(bindingResult.getFieldErrors().get(0).getCode())
                        .errorMessage(bindingResult.getFieldErrors().get(0).getDefaultMessage())
                        .build());
    }

}
