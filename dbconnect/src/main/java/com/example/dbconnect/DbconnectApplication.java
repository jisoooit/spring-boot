package com.example.dbconnect;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value={"com.example.dbconnect.mapper"}) //인터페이스의 위치를 적어준다.
public class DbconnectApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbconnectApplication.class, args);
    }

}
