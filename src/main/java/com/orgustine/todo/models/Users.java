package com.orgustine.todo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class Users extends BaseModel {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    @OneToMany
    private List<Todos> todos;
}
