package com.example.jpaexample.controller;

import com.example.jpaexample.dto.ExampleReqDTO;
import com.example.jpaexample.dto.ExampleResDTO;
import com.example.jpaexample.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExampleController {

    @Autowired
    ExampleService exampleService;

    @GetMapping("/insert")
    public ExampleResDTO mergeExample(){
        ExampleReqDTO dto = new ExampleReqDTO(1L,"fish",1500);
        return exampleService.merge(dto);
    }

    @GetMapping("/selectAll")
    public List<ExampleResDTO> selectAll(){
        return exampleService.selectAll();
    }

    @GetMapping("/selectOne")
    public ExampleResDTO selectOne(){
        return exampleService.selectOne(new ExampleReqDTO(2L,"",0));
    }

    @GetMapping("/deleteOne")
    public void deleteOne(){
         exampleService.deleteOne(new ExampleReqDTO(2L,"",0));
    }

    @GetMapping("/deleteAll")
    public void deleteAll(){
        exampleService.deleteAll();
    }

    @GetMapping("/selectByName")
    public List<ExampleResDTO> selectByName(){

        return exampleService.selectByName(new ExampleReqDTO(1L,"fish",0));
    }

    @GetMapping("/selectByNameStartingWith")
    public List<ExampleResDTO> selectByNameStartingWith(){
        return exampleService.selectByNameStartingWith(new ExampleReqDTO(1L,"fish",0));
    }

    @GetMapping("/selectByPriceLessThan")
    public List<ExampleResDTO> selectByPriceLessThan(){
        return exampleService.selectByNameStartingWith(new ExampleReqDTO(1L,"fish",2000));
    }

    @GetMapping("/selectByNameAndPrice")
    public List<ExampleResDTO> selectByNameAndPrice(){
        return exampleService.selectByNameStartingWith(new ExampleReqDTO(1L,"fish2",1000));
    }
}
