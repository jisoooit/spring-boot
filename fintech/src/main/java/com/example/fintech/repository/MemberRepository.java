package com.example.fintech.repository;

import com.example.fintech.dto.BuyCoinDTO;
import com.example.fintech.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class MemberRepository {

    @Autowired
    private MemberMapper memberMapper;

    public int signUp(Map<String, String> params){
        return memberMapper.signUp(params);
    }

    public List<Map<String, Object>> allMember(){
        return memberMapper.allMember();
    }

    public int charge(Map<String, String> params) {
        return memberMapper.charge(params);
    }

    public int subscribe(String email){
        return memberMapper.subscribe(email);
    }

    public int requestCall(Map<String, String> params){
        return memberMapper.contact(params);
    }

    public List<Map<String, Object>> pointList(String email){
        return memberMapper.pointList(email);
    }

    public int totalPoint(String email){
        return memberMapper.totalPoint(email);
    }

    public int buyCoin(BuyCoinDTO buyCoinDTO){
        return memberMapper.buyCoin(buyCoinDTO);
    }
}
