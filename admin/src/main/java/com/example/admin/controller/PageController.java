package com.example.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Api(tags = {"페이지 리턴"})
@Controller
public class PageController {

    @ApiOperation(value = "main 페이지")
    @GetMapping("/")
    public String main(){
        return "login";
    }

    @ApiOperation(value = "인덱스 페이지")
    @GetMapping("/index")
    public String summary(){
        return "index";
    }
    @ApiOperation(value = "멤버 페이지")
    @GetMapping("/goMember")
    public String goMember(){
        return "memberList";
    }

    @ApiOperation(value = "충전 페이지")
    @GetMapping("/goPayment")
    public String goPayment(){
        return "paymentList";
    }

    @ApiOperation(value = "거래 페이지")
    @GetMapping("/goBuy")
    public String goBuy(){
        return "buyList";
    }

    @ApiOperation(value = "연락 페이지")
    @GetMapping("/goContact")
    public String goContact(){
        return "contactList";
    }

    @ApiOperation(value = "구독 페이지")
    @GetMapping("/goSubscribe")
    public String goSubscribe(){
        return "subscribeList";
    }
}
