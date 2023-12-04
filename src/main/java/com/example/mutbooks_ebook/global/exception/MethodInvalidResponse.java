package com.example.mutbooks_ebook.global.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MethodInvalidResponse {
    private String errorCode;
    private String errorMessage;
}
