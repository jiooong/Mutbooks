package com.example.mutbooks_ebook.global.security;

import com.example.mutbooks_ebook.domain.member.entity.Member;
import com.example.mutbooks_ebook.domain.member.enums.UserRoleEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class UserDetailsImpl implements UserDetails {
    private final Member member;

    public UserDetailsImpl(Member member){
        this.member = member;
    }

    @JsonProperty
    public Member getMember() {
        return member;
    }

    @Override
    @JsonProperty
    public String getPassword() {
        return member.getPassword();
    }

    @Override
    @JsonProperty
    public String getUsername() {
        return member.getUsername();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {


        Collection<GrantedAuthority> collectors = new ArrayList<>();
        collectors.add(() -> {
            return "ROLE_USER";
        });
        return collectors;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
