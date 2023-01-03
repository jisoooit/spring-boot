package com.example.jpaexample.repository;

import com.example.jpaexample.entity.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExampleRepository extends JpaRepository<Example,Long> {

    public List<Example> findByName(String name); //where name = ?

    public List<Example> findByNameStartingWith(String name); //where name like 'x%'

    public List<Example> findByPriceLessThan(int price); //where price < x

    public List<Example> findByNameAndPrice(String name, int price); //where name=? and price=?
}
