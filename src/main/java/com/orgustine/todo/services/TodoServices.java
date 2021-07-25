package com.orgustine.todo.services;

import com.orgustine.todo.models.Todos;
import com.orgustine.todo.models.Users;
import com.orgustine.todo.requestbody.TodoRequest;

import java.util.List;

public interface TodoServices {
   Todos createTodos(TodoRequest todoRequest);
   List<Todos> getAllTodos();
   Todos getTodosById(Long id);
   List<Todos> getTodosByUser(Users users);
   void deleteTodoById(Long id);

}
