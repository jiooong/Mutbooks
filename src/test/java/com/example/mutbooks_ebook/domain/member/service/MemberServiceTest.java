package com.example.mutbooks_ebook.domain.member.service;

import com.example.mutbooks_ebook.domain.member.dto.SignupForm;
import com.example.mutbooks_ebook.domain.member.entity.Member;
import com.example.mutbooks_ebook.domain.member.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@Slf4j
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("회원가입")
    void registerMember() {

        SignupForm signupForm = SignupForm.builder()
                .username("test_username")
                .password("1234")
                .checkPassword("1234")
                .nickname("test_nickname")
                .email("test@email.com")
                .build();

        Member member = memberService.registerMember(signupForm);

        Member findMember = memberRepository.findById(member.getId()).orElseThrow();
        assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        assertThat(findMember.getNickname()).isEqualTo(member.getNickname());
        assertThat(findMember.getEmail()).isEqualTo(member.getEmail());
        assertThat(findMember.getAuthLevel()).isEqualTo(3L);
        assertThat(findMember.getCreatedAt()).isNotNull();
        assertThat(findMember.getModifiedAt()).isNotNull();
        log.info("{}", findMember.getPassword());


    }
}