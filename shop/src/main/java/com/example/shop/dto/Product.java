package com.example.shop.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Product {
    private String id;
    private String productName;
    private String thumb;
    private String status;
    private int amount;
    private int price;
    private String content;
    private String indate;
    private String marketType;
    private String catename;

}
