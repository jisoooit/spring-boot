package com.example.chatting.chat.controller;

import org.apache.catalina.Session;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;

@RestController
public class ChatController {

   private ArrayList<ArrayList<String>>
           chatList = new ArrayList<ArrayList<String>>();


   @GetMapping("/chat/sendMsg")
   public ArrayList<ArrayList<String>> sendMsg(String msg, HttpSession session){
      ArrayList<String> message = new ArrayList<>();

      message.add(session.getAttribute("nickName").toString());
      message.add(msg);
      message.add(LocalDateTime.now().toString());
      chatList.add(message);

      return chatList;
   }

   @GetMapping("/chat/getMsg")
   public ArrayList<ArrayList<String>> sendMsg(){

      return chatList;
   }



}
