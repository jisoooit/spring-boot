package com.example.admin.controller;

import com.example.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class AdminDataController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/selectCntMember")
    public Integer selectCntMember(){
        return adminService.selectCntMember();
    }

    @GetMapping("/selectAmountPayment")
    public Double selectAmountPayment(){
        return adminService.selectAmountPayment();
    }

    @GetMapping("/selectCntBuy")
    public Integer selectCntBuy(){
        return adminService.selectCntBuy();
    }

    @GetMapping("/selectCntContact")
    public Integer selectCntContact(){
        return adminService.selectCntContact();
    }

    @GetMapping("/selectMember")
    public List<Map<String, Object>> selectMember(){
        return adminService.selectMember();
    }

    @GetMapping("/selectPayment")
    public List<Map<String, Object>> selectPayment(){
        return adminService.selectPayment();
    }

    @GetMapping("/selectBuy")
    public List<Map<String, Object>> selectBuy(){
        return adminService.selectBuy();
    }

    @GetMapping("/selectContact")
    public List<Map<String, Object>> selectContact(){
        return adminService.selectContact();
    }

    @GetMapping("/selectSubscribe")
    public List<Map<String, Object>> selectSubscribe(){
        return adminService.selectSubscribe();
    }
}
