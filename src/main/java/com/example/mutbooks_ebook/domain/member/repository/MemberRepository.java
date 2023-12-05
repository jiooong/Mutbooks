package com.example.mutbooks_ebook.domain.member.repository;

import com.example.mutbooks_ebook.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
