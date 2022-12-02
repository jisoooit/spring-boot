package com.example.dbconnect.repository;

import com.example.dbconnect.mapper.TodoListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class TodoListRepository {

    @Autowired
    TodoListMapper tm;

    public int insertTodo(String todo){
        return tm.insertTodo(todo);
    }

    public ArrayList<HashMap<String,Object>> selectTodo(){
        return tm.selectTodo();
    }

    public int deleteTodo(HashMap<String, Object> param){
        return tm.deleteTodo(param);
    }
}
