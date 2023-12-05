package com.example.mutbooks_ebook.domain.member.dto;

import com.example.mutbooks_ebook.domain.member.entity.Member;
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

    public static SignupForm from(Member member){
        SignupForm signupForm = new SignupForm();
        signupForm.username = member.getUsername();
        signupForm.password = member.getPassword();
        signupForm.nickname = member.getNickname();
        signupForm.email = member.getEmail();

        return signupForm;
    } //SignupForm.from(member) 이런식으로 호출하면 Entity 객체를 만들어 낼 수 있다.
}
