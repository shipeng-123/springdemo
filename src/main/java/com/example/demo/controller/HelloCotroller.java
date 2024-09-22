package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloCotroller {
//    http://localhost:8080/hello
    @GetMapping("/hello")
    public String hello(){
        return "你好1111111";
    }
}
