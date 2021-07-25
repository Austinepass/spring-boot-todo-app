package com.orgustine.todo.services.serviceimplementation;

import com.orgustine.todo.models.Todos;
import com.orgustine.todo.models.Users;
import com.orgustine.todo.repositories.TodoRepository;
import com.orgustine.todo.requestbody.TodoRequest;
import com.orgustine.todo.services.TodoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class TodosServiceImpl implements TodoServices {
    private TodoRepository todoRepository;

    @Autowired
    public TodosServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Todos createTodos(TodoRequest todoRequest) {
        Todos todos = new Todos();
        todos.setTitle(todoRequest.getTitle());
        todos.setDescription(todoRequest.getDescription());
        todos.setStartTime(todoRequest.getStartTime());
        todos.setFinishedTime(todoRequest.getFinishedTime());
        return  todoRepository.save(todos);
    }

    @Override
    public List<Todos> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Todos getTodosById(@PathVariable(value = "id") Long id) {
        return todoRepository.findTodosById(id);
    }

    @Override
    public List<Todos> getTodosByUser(Users users) {
        return todoRepository.findAllByUsers(users);
    }

    @Override
    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }

    Todos updateTodo(@PathVariable("id") Long id, TodoRequest todoRequest) {
        Todos todos = new Todos();
        todos.setTitle(todoRequest.getTitle());
        todos.setDescription(todoRequest.getDescription());
        todos.setStartTime(todoRequest.getStartTime());
        todos.setFinishedTime(todoRequest.getFinishedTime());
        return todoRepository.save(todos);
    }
}
