package com.example.shop.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Member {
    private String id;
    private String pw;
    private String name;
    private String postcode;
    private String phone;
    private String address;
    private String addressDetail;
    private String email;
    private String gender;
    private String sns;
    private String birth;
}
