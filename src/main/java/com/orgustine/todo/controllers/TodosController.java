package com.orgustine.todo.controllers;

import com.orgustine.todo.models.Todos;
import com.orgustine.todo.models.Users;
import com.orgustine.todo.requestbody.TodoRequest;
import com.orgustine.todo.services.serviceimplementation.TodosServiceImpl;
import com.orgustine.todo.services.serviceimplementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodosController {

    private final UserServiceImpl userService;
    private final TodosServiceImpl todosService;

    @Autowired
    public TodosController(UserServiceImpl userService, TodosServiceImpl todosService) {
        this.userService = userService;
        this.todosService = todosService;
    }

    @PostMapping("/create")
    ResponseEntity<?> createTodo(@RequestBody TodoRequest todoRequest) {
        Todos todos = new Todos();
        todos = todosService.createTodos(todoRequest);
        return ResponseEntity.status(HttpStatus.OK).body("Successfully created todo.");
    }
    @GetMapping("/all")
    List<Todos> getAllTodosByUser(Users users) {
        return todosService.getTodosByUser(users);
    }
    @GetMapping("/id")
    Todos getTodosById(@PathVariable(value = "id") Long id) {
        return todosService.getTodosById(id);
    }


    ResponseEntity<?> deleteTodoById(Long id) {
        todosService.deleteTodoById(id);
        return ResponseEntity.status( HttpStatus.OK).body("Successfully deleted");

    }
}
