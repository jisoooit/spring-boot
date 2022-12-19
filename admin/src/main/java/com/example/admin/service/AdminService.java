package com.example.admin.service;

import com.example.admin.dto.AdminDTO;
import com.example.admin.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Map<String, Object>> allAdmin(){
        return adminRepository.allAdmin();
    }

    public boolean login(AdminDTO adminDTO, HttpSession session) {

        HashMap<String, String> params = new HashMap<>();
        params.put("id",adminDTO.getId());
        params.put("password", adminDTO.getPassword());

        for(Map<String, Object> admin  : allAdmin()){
            if(params.get("id").equals(admin.get("id")) &&
                params.get("password").equals(admin.get("password"))){
                session.setAttribute("id", params.get("id"));
                return true;
            }
        }
        return false;
    }

    public Integer selectCntMember(){
        return adminRepository.selectCntMember();
    }

    public Double selectAmountPayment(){
        return adminRepository.selectAmountPayment();
    }

    public Integer selectCntBuy(){
        return adminRepository.selectCntBuy();
    }

    public Integer selectCntContact(){
        return adminRepository.selectCntContact();
    }

    public List<Map<String, Object>> selectMember(){
        return adminRepository.selectMember();
    }

    public List<Map<String, Object>> selectPayment(){
        return adminRepository.selectPayment();
    }

    public List<Map<String, Object>> selectBuy(){
        return adminRepository.selectBuy();
    }

    public List<Map<String, Object>> selectContact(){
        return adminRepository.selectContact();
    }

    public List<Map<String, Object>> selectSubscribe(){
        return adminRepository.selectSubscribe();
    }

}
