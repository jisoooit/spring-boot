package com.example.reservation.dto;

import com.example.reservation.entity.Todo;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TodoResponse {

    private String id;
    private String todos;

    public TodoResponse(Todo todo){
        this.id=String.valueOf(todo.getId());
        this.todos=todo.getTodos();
    }


}
