package com.example.mutbooks_ebook.domain.member.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignupForm {

    @NotBlank(message = "Expense name must not be empty.")
    private String username;

    @NotBlank(message = "Expense password must not be empty.")
    private String password;

    @NotBlank(message = "Expense checkPassword must not be empty.")
    private String checkPassword;

    private String nickname;

    @Email
    private String email;
}
