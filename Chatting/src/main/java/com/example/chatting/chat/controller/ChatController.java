package com.example.chatting.chat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;

@RestController
public class ChatController {

   public static ArrayList<ArrayList<String>>
           chatList = new ArrayList<>();


   @GetMapping("/chat/sendMsg")
   public void sendMsg(String msg, HttpSession session){

      ArrayList<String> message = new ArrayList<>();
      message.add(session.getAttribute("nickName").toString());
      message.add(msg);
      message.add(LocalDateTime.now().toString());
      chatList.add(message);

   }

   @GetMapping("/chat/getMsg")
   public ArrayList<ArrayList<String>> Msg(){
      return chatList;
   }

}
