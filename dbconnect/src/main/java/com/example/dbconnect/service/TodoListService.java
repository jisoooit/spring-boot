package com.example.dbconnect.service;

import com.example.dbconnect.repository.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class TodoListService {

    @Autowired
    TodoListRepository todoListRepository;
    public int insertTodo(String todo){
        return todoListRepository.insertTodo(todo);
    }

    public ArrayList<HashMap<String,Object>> selectTodo(){
        return todoListRepository.selectTodo();
    }

    public int deleteTodo(HashMap<String,Object> param){
        return todoListRepository.deleteTodo(param);
    }
}
