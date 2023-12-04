package com.example.mutbooks_ebook.domain.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/join")
    public String getSignupForm(){

    }

    @PostMapping("/join")
    public String signUp(){

    }

}
