package com.example.jpaexample.service;

import com.example.jpaexample.dto.ExampleReqDTO;
import com.example.jpaexample.dto.ExampleResDTO;
import com.example.jpaexample.entity.Example;
import com.example.jpaexample.repository.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExampleService {

    @Autowired
    ExampleRepository exampleRepository;

    public ExampleResDTO merge(ExampleReqDTO req){
        Example ex = req.toEntity();
        exampleRepository.save(ex);
        return new ExampleResDTO(ex.getName());
    }

    public List<ExampleResDTO> selectAll(){
        List<Example> result =  exampleRepository.findAll();
        List<ExampleResDTO> resList = result.stream()
                .map(ex -> new ExampleResDTO(ex.getName()))
                .collect(Collectors.toList());

        return resList;
    }

    public ExampleResDTO selectOne(ExampleReqDTO req){
        Example res = exampleRepository.findById(req.getId()).orElse(null);
        return new ExampleResDTO(res.getName());
    }

    public void deleteOne(ExampleReqDTO req){
        exampleRepository.deleteById(req.getId());
    }

    public void deleteAll(){
        exampleRepository.deleteAll();
    }

    public List<ExampleResDTO> selectByName(ExampleReqDTO dto){
        List<Example> result =  exampleRepository.findByName(dto.getName());
        List<ExampleResDTO> resList = result.stream()
                .map(ex -> new ExampleResDTO(ex.getName()))
                .collect(Collectors.toList());

        return resList;
    }

    public List<ExampleResDTO> selectByNameStartingWith(ExampleReqDTO dto){
        List<Example> result =  exampleRepository.findByNameStartingWith(dto.getName());
        List<ExampleResDTO> resList = result.stream()
                .map(ex -> new ExampleResDTO(ex.getName()))
                .collect(Collectors.toList());

        return resList;
    }

    public List<ExampleResDTO> selectByPriceLessThan(ExampleReqDTO dto){
            List<Example> result =  exampleRepository.findByPriceLessThan(dto.getPrice());
            List<ExampleResDTO> resList = result.stream()
                    .map(ex -> new ExampleResDTO(ex.getName()))
                    .collect(Collectors.toList());

            return resList;
    }

    public List<ExampleResDTO> selectByNameAndPrice(ExampleReqDTO dto){
        List<Example> result =  exampleRepository.findByNameAndPrice(dto.getName(),dto.getPrice());
        List<ExampleResDTO> resList = result.stream()
                .map(ex -> new ExampleResDTO(ex.getName()))
                .collect(Collectors.toList());

        return resList;
    }
}
