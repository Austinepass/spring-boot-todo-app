package com.orgustine.todo.controllers;

import com.orgustine.todo.models.Users;
import com.orgustine.todo.requestbody.UserRequest;
import com.orgustine.todo.services.serviceimplementation.TodosServiceImpl;
import com.orgustine.todo.services.serviceimplementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    private UserServiceImpl userService;
    private TodosServiceImpl todosService;

    @Autowired
    public UsersController(UserServiceImpl userService, TodosServiceImpl todosService) {
        this.userService = userService;
        this.todosService = todosService;
    }

    @PostMapping("/login")
    Users login(String email, String password) {
        Users users = new Users();
        users = userService.logIn(email, password);
        return users;
    }

    @PostMapping("/signup")
    ResponseEntity<?> signUp(@RequestBody UserRequest userRequest){
        Users users = new Users();
        users = userService.signUp(userRequest);
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
}
