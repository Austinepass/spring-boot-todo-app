package com.orgustine.todo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public class BaseModel {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
}
