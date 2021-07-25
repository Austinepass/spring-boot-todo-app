package com.orgustine.todo.services.serviceimplementation;

import com.orgustine.todo.models.Users;
import com.orgustine.todo.repositories.UserRepository;
import com.orgustine.todo.requestbody.UserRequest;
import com.orgustine.todo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public Users logIn(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public Users signUp(UserRequest userRequest) {
        Users users = new Users();
        users.setEmail(userRequest.getEmail());
        users.setFirstName(userRequest.getFirstName());
        users.setLastName(userRequest.getLastName());
        users.setPassword(userRequest.getPassword());
        users.setPhoneNumber(userRequest.getPhoneNumber());
        return userRepository.save(users);
    }
}
