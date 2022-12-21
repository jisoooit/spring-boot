package com.example.shop.controller;

import com.example.shop.dto.Member;
import com.example.shop.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

public class LoginController {
    @Autowired
    MemberService memberService;

    @PostMapping("/signup")
    public int signup(Member member) {
        return memberService.signup(member);
    }

    @PostMapping("/login")
    public Member login(Member member, HttpSession session) {
        Member loginMember = memberService.login(member);
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
