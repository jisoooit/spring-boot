package com.example.signuplogin.controller;

import com.example.signuplogin.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MemberController {


    @Autowired
    MemberService memberService;

    @PostMapping("/signup")
    public String signup(@RequestParam Map<String, String> params){
        for (Map.Entry<String, String> entrySet : params.entrySet()) {
            System.out.println(entrySet.getKey() + " : " + entrySet.getValue());
        }

        if(params.get("Terms").equals("on")){
            memberService.signup(params);
        } else{
            return "signup";
        }
        return "index";
    }

    @PostMapping("/login")
    public String login(@RequestParam Map<String, String> params, HttpSession session, Model model){

        for (Map<String, Object> existing : memberService.allMember()){
            if(params.get("email").equals(existing.get("email")) && params.get("password").equals(existing.get("password"))){

                //가입한 회원인 경우
                session.setAttribute("email",existing.get("email"));
                model.addAttribute("email", existing.get("email"));
            }
        }

        return "index";
    }

    @GetMapping("/logout")
    public String logOut(HttpSession session){

        session.setAttribute("email",null);
        return "index";
    }

}
