package com.example.admin.repository;

import com.example.admin.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class AdminRepository {

    @Autowired
    private AdminMapper adminMapper;

    public List<Map<String, Object>> allAdmin(){
        return adminMapper.allAdmin();
    }

    public Integer selectCntMember(){
        return adminMapper.selectCntMember();
    }

    public Double selectAmountPayment(){
        return adminMapper.selectAmountPayment();
    }

    public Integer selectCntBuy() {
        return adminMapper.selectCntBuy();
    }

    public Integer selectCntContact() {
        return adminMapper.selectCntContact();
    }

    public List<Map<String, Object>> selectMember() {
        return adminMapper.selectMember();
    }

    public List<Map<String, Object>> selectPayment() {
        return adminMapper.selectPayment();
    }

    public List<Map<String, Object>> selectBuy() {
        return adminMapper.selectBuy();
    }

    public List<Map<String, Object>> selectContact() {
        return adminMapper.selectContact();
    }

    public List<Map<String, Object>> selectSubscribe() {
        return adminMapper.selectSubscribe();
    }
}
