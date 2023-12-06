package com.example.mutbooks_ebook.global.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;

    public void sendSimpleEmail(String toEmail){

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setSubject("홈페이지 가입을 축하합니다"); // 제목
        simpleMailMessage.setText("홈페이지 가입을 축하합니다.\n" + "좋은 하루 되세요!"); // 본문 내용

        javaMailSender.send(simpleMailMessage);

    }

}
