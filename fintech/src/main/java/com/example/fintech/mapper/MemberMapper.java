package com.example.fintech.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MemberMapper {
    public int signUp(Map<String, String> params);

    public List<Map<String, Object>> allMember();

    public int charge(Map<String, String> params);
}
