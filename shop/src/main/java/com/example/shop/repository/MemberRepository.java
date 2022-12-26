package com.example.shop.repository;

import com.example.shop.dto.Member;
import com.example.shop.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<HashMap<String,Object>> selectUserCart(String id){
        return memberMapper.selectUserCart(id);
    }
    public List<HashMap<String,Object>>  selectCart(String id){
        return memberMapper.selectCart(id);
    }
    public int updateCartAmount(Map<String,String> param){
        return memberMapper.updateCartAmount(param);
    }
    public int insertCart(Map<String,String> param){
        return memberMapper.insertCart(param);

    }
    public int selectAvailAmount(Map<String,String> param){
        return memberMapper.selectAvailAmount(param);
    }
    public int deleteCart(Map<String,String> param){
        return memberMapper.deleteCart(param);
    }
    public int deleteCartAll(String param){
        return memberMapper.deleteCartAll(param);
    }

    public int updateAmountProduct(Map<String, String> param) {
        return memberMapper.updateAmountProduct(param);
    }

    public int insertOrderBook(Map<String, String> param) {
        return memberMapper.insertOrderBook(param);
    }

    public int insertOrderDetail(Map<String, String> param) {
        return memberMapper.insertOrderDetail(param);
    }

    public List<HashMap<String, Object>> selectOrderBook(String id) {
        return memberMapper.selectOrderBook(id);

    }
    public List<HashMap<String, Object>> selectOrderDetail(HashMap<String, String> params) {
        return memberMapper.selectOrderDetail(params);

    }

}
