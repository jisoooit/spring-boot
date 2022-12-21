package com.example.shop.service;

import com.example.shop.dto.Member;
import com.example.shop.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public int signup(Member member){
        int result=0;
        try{
            result = memberRepository.signup(member);
        }catch (Exception e){
            result=-1;
        }

        return result;
    }

    public Member login(Member member){
        return memberRepository.login(member);
    }
}
