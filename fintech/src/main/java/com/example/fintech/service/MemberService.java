package com.example.fintech.service;

import com.example.fintech.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public int signUp(Map<String, String> params){
        return memberRepository.signUp(params);
    }

    public List<Map<String, Object>> allMember(){
        return memberRepository.allMember();
    }

    public int charge(Map<String, String> params) {
        return memberRepository.charge(params);
    }

    public boolean login(Map<String, String> params, HttpSession session) {
        for (Map<String, Object> member : allMember()){
            if (params.get("email").equals(member.get("email"))
                    && params.get("password").equals(member.get("password"))){
                session.setAttribute("email", params.get("email"));
                return true;
            }
        }
        return false;
    }

    public int subscribe(String email) {
        return memberRepository.subscribe(email);
    }

    public int requestCall(Map<String, String> params){
        return memberRepository.requestCall(params);
    }

    public List<Map<String, Object>> pointList(String email){
        return memberRepository.pointList(email);
    }

    public int totalPoint(String email){
        return memberRepository.totalPoint(email);
    }

    public String checkBalance(double total, String email){
        int nowPoint = totalPoint(email);
        if (total <= nowPoint){
            System.out.println("can");
            return "can";
        }else{
            System.out.println("cannot");
            return "cannot";
        }
        
    }
}
