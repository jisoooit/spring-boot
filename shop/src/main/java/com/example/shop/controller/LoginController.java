package com.example.shop.controller;

import com.example.shop.dto.Member;
import com.example.shop.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {
    @Autowired
    MemberService memberService;

    @PostMapping("/signup")
    public int signup(Member member) {
        return memberService.signup(member);
    }

    @PostMapping("/login")
    public Member login(Member member, HttpSession session) {
        System.out.println("여기여기");
        Member loginMember = memberService.login(member);
        System.out.println(loginMember.getId());
        if (loginMember != null) {
            session.setAttribute("id", loginMember);
            return loginMember;
        }
        return null;
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        if (session.getAttribute("id") != null) {
            session.setAttribute("id", null);
            return "success";
        } else {
            return "failed";
        }
    }
}
