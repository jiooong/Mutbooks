package com.example.mutbooks_ebook.domain.home.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public ResponseEntity<?> recentPost (){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
