package com.orgustine.todo.services;

import com.orgustine.todo.models.Users;
import com.orgustine.todo.requestbody.UserRequest;

public interface UserService {
    Users logIn(String email, String password);
    Users signUp(UserRequest userRequest);
}
