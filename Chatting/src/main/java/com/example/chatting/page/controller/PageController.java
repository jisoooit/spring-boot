package com.example.chatting.page.controller;

import com.example.chatting.chat.controller.ChatController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Controller
public class PageController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/goMain")
    public String goMain(String nickName, HttpSession session){
        if (nickName == null || ChatController.chatList.contains(nickName)){
            return "index";
        }else{
            session.setAttribute("nickName", nickName);
            return "main";
        }
    }

}
