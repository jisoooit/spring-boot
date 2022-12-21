package com.example.shop.repository;

import com.example.shop.dto.Product;
import com.example.shop.mapper.ProductMapper;
import com.example.shop.util.SearchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    @Autowired
    ProductMapper productMapper;

    public List<Product> selectProduct(SearchDto params){
        return productMapper.selectProduct(params);
    }

    public int count(SearchDto params){
        return productMapper.count(params);
    }
}
