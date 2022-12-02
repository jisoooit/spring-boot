package com.example.signuplogin.repository;

import com.example.signuplogin.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class MemberRepository {

    @Autowired
    MemberMapper memberMapper;

    public int signup(Map<String, String> params){
        return memberMapper.signup(params);
    }

    public List<Map<String, Object>> allMember(){
        return  memberMapper.allMember();
    }
}
