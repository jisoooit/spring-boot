package com.example.fintech.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BuyCoinDTO {
    private String price;
    private String coinId;
    private String name;
    private String email;
    private String amount;
    private String total;
}
