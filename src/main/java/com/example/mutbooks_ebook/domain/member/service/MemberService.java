package com.example.mutbooks_ebook.domain.member.service;

import com.example.mutbooks_ebook.domain.member.dto.SignupForm;
import com.example.mutbooks_ebook.domain.member.entity.Member;
import com.example.mutbooks_ebook.domain.member.repository.MemberRepository;
import com.example.mutbooks_ebook.domain.member.validator.CheckPassword;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Check;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


// entity -> dto, dto -> entity 를 사용하는 경우 정적 팩토리 메서드 패턴을 사용해보자
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public String registerMember(SignupForm signupForm) {
//        Member member = Member.builder()
//                .username(signupForm.getUsername())
//                .password(signupForm.getPassword())
//                .nickname(signupForm.getNickname())
//                .email(signupForm.getEmail())
//                .authLevel(3L)
//                .build();
        Member member = Member.from(signupForm);
        member.encodePassword(passwordEncoder.encode(member.getPassword()));
        memberRepository.save(member);
        return "등록완료";
    }

}
