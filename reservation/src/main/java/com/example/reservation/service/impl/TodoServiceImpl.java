package com.example.reservation.service.impl;

import com.example.reservation.dto.TodoResponse;
import com.example.reservation.entity.Todo;
import com.example.reservation.repository.TodoRepository;
import com.example.reservation.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Override
    public List<TodoResponse> todoList() {

        return todoRepository.findAll().stream()
                .map(TodoResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public String deleteTodos(String id) {
        try {
            todoRepository.deleteById(Long.valueOf(id));
        } catch (Exception e) {
            return "failed";
        }
        return "success";
    }

    @Override
    public String insertTodos(String todos) {
        try {
            todoRepository.save(Todo.builder()
                    .todos(todos)
                    .build());
        } catch (Exception e){
            return "failed";
        }
        return "success";
    }
}
