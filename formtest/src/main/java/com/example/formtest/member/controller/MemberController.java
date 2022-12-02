package com.example.formtest.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class MemberController {

    ArrayList<HashMap<String, String>> memberList = new ArrayList<>();

    @PostMapping("/signup")
    public String signup(@RequestParam HashMap<String, String> params){

        memberList.add(params);
        System.out.println(params);
        return "index";
    }

    @PostMapping("/login")
    public String login(@RequestParam HashMap<String, String> params, HttpSession session, Model model){

        for (HashMap<String, String> param : memberList){
            if(params.get("email").equals(param.get("email")) && params.get("password").equals(param.get("password"))){
                //가입한 회원인 경우
                session.setAttribute("email",param.get("email"));
                model.addAttribute("email", param.get("email"));
            }
        }

        return "index";
    }

    @GetMapping("/logout")
    public String logOut(HttpSession session){

        //session.invalidate(); //쓰지마세요!
        session.setAttribute("email",null);
        return "index";
    }
}
