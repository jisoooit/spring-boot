package com.example.shop.controller;

import com.example.shop.dto.Member;
import com.example.shop.dto.ProductList;
import com.example.shop.service.MemberService;
import com.example.shop.service.ProductService;
import com.example.shop.util.SearchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PageController {

    @Autowired
    ProductService ps;

    @Autowired
    MemberService ms;

    @GetMapping("/")
    public String mainPage() {
        return "index";
    }

    @GetMapping("/signupPage")
    public String signupPage() {
        return "user/signup";
    }

    @GetMapping("/loginPage")
    public String loginPage() {
        return "user/login";
    }

    @GetMapping("/aboutus")
    public String aboutus() {
        return "aboutus";
    }

    @GetMapping("/productList")
    public String productList(SearchDto params, Model model) {
        ProductList product = ps.findAll(params);
        model.addAttribute("product", product);
        String key=params.getKeyword();
        if(key!=null){
            model.addAttribute("keyword", params.getKeyword());
        }

        return "productlist";
    }

    @GetMapping("/orderList")
    public String orderList(HttpSession session, Model m) {
        List<Map<String, Object>> param = new ArrayList<Map<String, Object>>();
        String userid = null;
        Map<String, String> accParam = new HashMap<>();
        if (session.getAttribute("id") != null) {

            userid=((Member) session.getAttribute("id")).getId();
        }
        List<HashMap<String, Object>> cList = ms.selectOrderBook(userid);
        m.addAttribute("orderList", cList);

        return "orderhistory";
    }

}
