package com.example.mutbooks_ebook.domain.member.entity;

import com.example.mutbooks_ebook.global.utils.Timestamped;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
public class Member extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true)
    private String nickname;

    @Column(nullable = false)
    private String email ;

    @Column(nullable = false)
    private Long authLevel;

}
