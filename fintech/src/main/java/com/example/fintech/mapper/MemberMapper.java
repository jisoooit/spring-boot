package com.example.fintech.mapper;

import com.example.fintech.dto.BuyCoinDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MemberMapper {
    public int signUp(Map<String, String> params);

    public List<Map<String, Object>> allMember();

    public int charge(Map<String, String> params);

    public int subscribe(String email);

    public int contact(Map<String, String> params);

    public List<Map<String, Object>> pointList(String email);

    public int totalPoint(String email);

    public int buyCoin(BuyCoinDTO buyCoinDTO);
}
