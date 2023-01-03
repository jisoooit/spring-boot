package com.example.jpaexample.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "Example")
public class Example {

    @Id
    private Long id;
    @Column(length = 20)
    private String name;
    @Column(length = 20)
    private int price;


}
