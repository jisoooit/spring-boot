package com.example.fintech.controller;

import com.example.fintech.dto.BuyCoinDTO;
import com.example.fintech.service.MemberService;
import com.example.fintech.vo.BuyCoinVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
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

        if(memberService.login(params, session)){
            return "redirect:/";
        }

        return "redirect:/login";
    }

    @GetMapping("/point")
    public String charge(@RequestParam Map<String, String> params, HttpSession httpSession){

        params.put("email",httpSession.getAttribute("email").toString());

        for (Map.Entry<String, String> entrySet : params.entrySet()) {
            System.out.println(entrySet.getKey() + " : " + entrySet.getValue());
        }
        memberService.charge(params);

        return "index";
    }

    @GetMapping("/subscribe")
    public String subscribe(@RequestParam String email, HttpServletRequest request){
        memberService.subscribe(email);
        return "redirect:" + request.getHeader("Referer");
    }

    @PostMapping("/requestCall")
    public String requestCall(@RequestParam Map<String, String> params){
        memberService.requestCall(params);
        return "redirect:/";
    }

    @GetMapping("/pointList")
    @ResponseBody
    public List<Map<String, Object>> pointList(HttpSession session){
        return memberService.pointList(session.getAttribute("email").toString());
    }

    @GetMapping("/checkBalance")
    @ResponseBody
    public String checkBalance(@RequestParam double total, HttpSession session){
        if (session.getAttribute("email")==null){
            return "login";
        }
        return memberService.checkBalance(total, session.getAttribute("email").toString());
    }

    @PostMapping("/buyCoin")
    public String buyCoin(@ModelAttribute BuyCoinVO buyCoinVO, HttpSession session){ //vo로 받으면 requestbody 없어야되고, hashmap이랑 받으면 있어야함
        if (session.getAttribute("email")==null){
            return "login";
        }
        //buyCoin.put("email", session.getAttribute("email").toString());

        System.out.println(buyCoinVO.toString());
        memberService.buyCoin(buyCoinVO, session.getAttribute("email").toString());
        return "redirect:/history";
    }





}
