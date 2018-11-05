package com.scoopsoup.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScoopSearchController {
    @GetMapping("/getHelloMessage")
    public String getHelloMessage(){
        return "Hello Spring Boot World";
    }
}
