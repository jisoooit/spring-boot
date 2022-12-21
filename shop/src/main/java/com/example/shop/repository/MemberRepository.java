package com.example.shop.repository;

import com.example.shop.dto.Member;
import com.example.shop.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    @Autowired
    MemberMapper memberMapper;

    public int signup(Member member){
        return memberMapper.signup(member);
    }

    public Member login(Member member){
        return memberMapper.login(member);
    }
}
