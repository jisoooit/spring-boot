package com.example.admin.controller;

import com.example.admin.dto.AdminDTO;
import com.example.admin.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags={"로그인"})
@Controller
@Slf4j
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    @ApiOperation(value = "사용자별 인증 정보 CHECK", notes = "인증된 사용자인지 판단하는 API입니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "사용자 식별 ID", required = true),
            @ApiImplicitParam(name = "password", value = "사용자 비밀번호", required = true)
    })
    public String login(AdminDTO adminDTO, @ApiIgnore HttpSession session){


        if (adminService.login(adminDTO, session)){
            return "redirect:/index";
        }
        return "redirect:/login";
    }

    @ApiOperation(value = "로그아웃")
    @GetMapping("/logout")
    public String logOut(HttpSession session){
        session.setAttribute("id",null);
        return "login";
    }




}
