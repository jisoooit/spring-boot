package com.example.dbconnect.Controller;

import com.example.dbconnect.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class ToDoListController {

    @Autowired
    TodoListService ts;

    @GetMapping("/list")
    public ArrayList<HashMap<String, Object>> list(){
        return ts.selectTodo();
    }

    @GetMapping("/receiveList")
    public ArrayList<HashMap<String, Object>> receiveList(String todo){

        ts.insertTodo(todo);
        return ts.selectTodo();
    }

    @GetMapping("/deleteList")
    public ArrayList<HashMap<String, Object>> deleteList(int todo){
        HashMap<String,Object> param = new HashMap<>();
        param.put("id",todo);

        ts.deleteTodo(param);
        return ts.selectTodo();
    }
}
