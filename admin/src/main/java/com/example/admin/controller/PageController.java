package com.example.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String main(){
        return "login";
    }

    @GetMapping("/index")
    public String summary(){
        return "index";
    }

    @GetMapping("/goMember")
    public String goMember(){
        return "memberList";
    }

    @GetMapping("/goPayment")
    public String goPayment(){
        return "paymentList";
    }

    @GetMapping("/goBuy")
    public String goBuy(){
        return "buyList";
    }

    @GetMapping("/goContact")
    public String goContact(){
        return "contactList";
    }

    @GetMapping("/goSubscribe")
    public String goSubscribe(){
        return "subscribeList";
    }
}
