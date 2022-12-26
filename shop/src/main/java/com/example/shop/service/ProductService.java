package com.example.shop.service;

import com.example.shop.dto.Product;
import com.example.shop.dto.ProductList;
import com.example.shop.repository.ProductRepository;
import com.example.shop.util.Pagination;
import com.example.shop.util.SearchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductList findAll(SearchDto params) {
        int count = productRepository.count(params);
        if (count < 1) {
            return new ProductList(Collections.emptyList(), null);
        }
        Pagination pagination = new Pagination(count, params);
        params.setPagination(pagination);

        List<Product> list = productRepository.selectProduct(params);

        return new ProductList(list,pagination);

    }

    public int selectAvailAmount(HashMap<String,String> params){
        return productRepository.selectAvailAmount(params);
    }
    public List<HashMap<String, Object>> checkAvailProductId(){
        return productRepository.checkAvailProductId();
    }
    public HashMap<String, Object> checkAmountProduct(HashMap<String, String> params){
        return productRepository.checkAmountProduct(params);
    }
}
