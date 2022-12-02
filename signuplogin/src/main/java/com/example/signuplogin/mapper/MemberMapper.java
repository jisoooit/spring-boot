package com.example.signuplogin.mapper;


import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface MemberMapper {

    public int signup(Map<String, String> params);

    public List<Map<String, Object>> allMember();
}
