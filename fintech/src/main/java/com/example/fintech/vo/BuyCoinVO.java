package com.example.fintech.vo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BuyCoinVO {
    private String price;
    private String coinId;
    private String name;
    private String amount;
    private String total;
}
