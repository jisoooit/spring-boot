package com.example.shop.service;

import com.example.shop.dto.Member;
import com.example.shop.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<HashMap<String,Object>> selectUserCart(String id){
        return memberRepository.selectUserCart(id);
    }
    public List<HashMap<String,Object>>  selectCart(String id){
        return memberRepository.selectCart(id);

    }
    public int updateCartAmount(Map<String,String> param){
        return memberRepository.updateCartAmount(param);
    }
    public int insertCart(Map<String,String> param){
        return memberRepository.insertCart(param);

    }
    public int selectAvailAmount(Map<String,String> param){
        return memberRepository.selectAvailAmount(param);
    }
    public int deleteCart(Map<String,String> param){
        return memberRepository.deleteCart(param);
    }
    public int deleteCartAll(String param){
        return memberRepository.deleteCartAll(param);
    }
    public int updateAmountProduct(Map<String, String> param) {
        return memberRepository.updateAmountProduct(param);
    }

    public int insertOrderBook(Map<String, String> param) {
        return memberRepository.insertOrderBook(param);
    }

    public int insertOrderDetail(Map<String, String> param) {
        return memberRepository.insertOrderDetail(param);
    }

    public List<HashMap<String, Object>> selectOrderBook(String id) {
        return memberRepository.selectOrderBook(id);

    }
    public List<HashMap<String, Object>> selectOrderDetail(HashMap<String, String> params) {
        return memberRepository.selectOrderDetail(params);

    }
}
