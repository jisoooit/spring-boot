package com.example.shop.mapper;

import com.example.shop.dto.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    public int signup(Member member);

    public Member login(Member member);
}
