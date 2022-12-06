package com.example.fintech.controller;

import com.example.fintech.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/signup")
    public String signUp(@RequestParam  Map<String, String> params){
        memberService.signUp(params);

        return "index";
    }

    @PostMapping("/login")
    public String login(@RequestParam Map<String, String> params, HttpSession session){
//        for (Map.Entry<String, String> entrySet : params.entrySet()) {
//            System.out.println(entrySet.getKey() + " : " + entrySet.getValue());
//        }
//
//        for (Map<String, Object> member : memberService.allMember()){
//            if (params.get("email").equals(member.get("email"))
//                && params.get("password").equals(member.get("password"))){
//                session.setAttribute("email", params.get("email"));
//                System.out.println(session.getAttribute("email"));
//
//            }
//        }
        session.setAttribute("email",params.get("email"));
        return "redirect:/";
    }

    @GetMapping("/point")
    public String charge(@RequestParam Map<String, String> params, HttpSession httpSession){
        System.out.println(httpSession.getAttribute("email").toString());
        params.put("email",httpSession.getAttribute("email").toString());

        for (Map.Entry<String, String> entrySet : params.entrySet()) {
            System.out.println(entrySet.getKey() + " : " + entrySet.getValue());
        }
        memberService.charge(params);

        return "index";
    }


}
