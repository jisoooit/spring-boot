package com.example.admin.controller;

import com.example.admin.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
@Api(tags = {"관리자 서비스 rest api"}, description = "관리자 관련 서비스")
@RestController
public class AdminDataController {

    @Autowired
    private AdminService adminService;

    @ApiOperation(value = "총 멤버 인원 수")
    @GetMapping("/selectCntMember")
    public Integer selectCntMember(){
        return adminService.selectCntMember();
    }

    @ApiOperation(value = "총 포인트 판매량", notes = "총 포인트 판매량을 조회한다")
    @GetMapping("/selectAmountPayment")
    public Double selectAmountPayment(){
        return adminService.selectAmountPayment();
    }

    @ApiOperation(value = "총 거래 수")
    @GetMapping("/selectCntBuy")
    public Integer selectCntBuy(){
        return adminService.selectCntBuy();
    }

    @ApiOperation(value = "총 연락 수")
    @GetMapping("/selectCntContact")
    public Integer selectCntContact(){
        return adminService.selectCntContact();
    }

    @ApiOperation(value = "총 멤버 조회")
    @GetMapping("/selectMember")
    public List<Map<String, Object>> selectMember(){
        return adminService.selectMember();
    }


    @ApiOperation(value = "충전 내역 조회")
    @GetMapping("/selectPayment")
    public List<Map<String, Object>> selectPayment(){
        return adminService.selectPayment();
    }


    @ApiOperation(value = "거래 내역 조회")
    @GetMapping("/selectBuy")
    public List<Map<String, Object>> selectBuy(){
        return adminService.selectBuy();
    }

    @ApiOperation(value = "연락 신청 내역 조회")
    @GetMapping("/selectContact")
    public List<Map<String, Object>> selectContact(){
        return adminService.selectContact();
    }

    @ApiOperation(value = "구독 내역 조회")
    @GetMapping("/selectSubscribe")
    public List<Map<String, Object>> selectSubscribe(){
        return adminService.selectSubscribe();
    }
}
