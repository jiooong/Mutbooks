package com.example.mutbooks_ebook.domain.member.controller;

import com.example.mutbooks_ebook.domain.member.dto.SignupForm;
import com.example.mutbooks_ebook.domain.member.entity.Member;
import com.example.mutbooks_ebook.domain.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/join")
    public String getSignupForm(Model model){
        //model을 사용해서 view에 데이터를 넘겨주기
        model.addAttribute("signupform", new SignupForm());
        return "member/new_member";
    }

    @PostMapping("/join")
    public Member signUp(@Valid @RequestBody SignupForm signupForm){
        return memberService.registerMember(signupForm);
    }
}
