package com.example.signuplogin.service;

import com.example.signuplogin.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public int signup(Map<String, String> params){
        return memberRepository.signup(params);
    }

    public List<Map<String, Object>> allMember(){
        return  memberRepository.allMember();
    }
}
