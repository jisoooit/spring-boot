package com.example.formtest.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class PageController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/goSignUp")
    public  String goSignUp(){
        return "signup";
    }

    @GetMapping("/goLogin")
    public  String goLogin(){
        return "login";
    }

    @GetMapping("/test")
    public String test(@RequestParam HashMap<String, String> params){
        System.out.println(params);
        return "main";
    }

    @GetMapping("/goMember")
    public  String goMember(HttpSession session){
        if (session.getAttribute("email")==null){ // login 안한 경우
            return "signup";
        }else{
            return "index";
        }
    }


}
