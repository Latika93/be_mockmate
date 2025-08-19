package com.Mockmate.Mockmate.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Home {
    ArrayList<Object> arrayList = new ArrayList<>();

    @GetMapping("/")
    public ArrayList<Object> home(){
        return arrayList;
    }

    @PostMapping("/product")
    public void createText(@RequestBody Object object){
        arrayList.add(object);
    }

    @GetMapping("/csrf")
    public CsrfToken getCsrf(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

}
