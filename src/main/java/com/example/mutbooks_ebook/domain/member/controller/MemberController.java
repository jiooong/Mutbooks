package com.example.mutbooks_ebook.domain.member.controller;

import com.example.mutbooks_ebook.domain.member.dto.LoginForm;
import com.example.mutbooks_ebook.domain.member.dto.SignupForm;
import com.example.mutbooks_ebook.domain.member.entity.Member;
import com.example.mutbooks_ebook.domain.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String showLoginForm(Model model)  {
        model.addAttribute("loginForm", new LoginForm());
        return "member/login";
    }

    @GetMapping("/join")
    public String getSignupForm(Model model){
        //model을 사용해서 view에 데이터를 넘겨주기
        model.addAttribute("signupform", new SignupForm());
        return "member/new_member";
    }

    @PostMapping("/join")
    public Member signUp(@Valid @ModelAttribute @RequestBody SignupForm signupForm){
        return memberService.registerMember(signupForm);
    }
}
