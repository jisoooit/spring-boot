package com.example.admin.controller;

import com.example.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public String login(@RequestParam Map<String, String> params, HttpSession session){
        if (adminService.login(params, session)){
            return "redirect:/index";
        }
        return "redirect:/login";
    }




}
