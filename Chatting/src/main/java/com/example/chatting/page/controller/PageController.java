package com.example.chatting.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Controller
public class PageController {

    private ArrayList<ArrayList<String>>
            chatList = new ArrayList<ArrayList<String>>();

    @GetMapping
    public String index(){
        return "index";
    }

    @GetMapping("/goMain")
    public String goChat(String nickName, HttpSession session){
        if (nickName == null || chatList.contains(nickName)){
            return "index";
        }else{
            session.setAttribute("nickName", nickName);
            return "main";
        }
    }

}
