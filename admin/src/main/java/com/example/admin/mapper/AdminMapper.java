package com.example.admin.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminMapper {
    public List<Map<String, Object>> allAdmin();

    public Integer selectCntMember();

    public Double selectAmountPayment();

    public Integer selectCntBuy();

    public Integer selectCntContact();

    public List<Map<String, Object>> selectMember();

    public List<Map<String, Object>> selectPayment();

    public List<Map<String, Object>> selectBuy();

    public List<Map<String, Object>> selectContact();

    public List<Map<String, Object>> selectSubscribe();

}
