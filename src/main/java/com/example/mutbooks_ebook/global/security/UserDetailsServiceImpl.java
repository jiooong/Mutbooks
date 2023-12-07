package com.example.mutbooks_ebook.global.security;

import com.example.mutbooks_ebook.domain.member.entity.Member;
import com.example.mutbooks_ebook.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
// 로그인 시 로그인 체크 가능하도록
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("Not Found" + username));
        return new UserDetailsImpl(member);
    }
}
