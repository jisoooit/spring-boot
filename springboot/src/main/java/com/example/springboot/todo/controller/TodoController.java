package com.example.springboot.todo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {

    private List<String> todoList = new ArrayList<>();

    @GetMapping("/list")
    public List<String> getList(){
        return todoList;
    }

    @GetMapping("/receiveList")
    public List<String> receiveList(String todo){
        if (todoList.contains(todo)){
            return todoList;
        }
        todoList.add(todo);
        return todoList;
    }

    @GetMapping("/deleteList")
    public List<String> deleteList(Integer todo){

        todoList.remove(todo);
        return todoList;
    }

}
