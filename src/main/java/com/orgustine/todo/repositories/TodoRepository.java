package com.orgustine.todo.repositories;

import com.orgustine.todo.models.Todos;
import com.orgustine.todo.models.Users;
import com.orgustine.todo.requestbody.TodoRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todos, Long> {
    Todos findTodosById(Long id);
    Todos findTodosByTitle(String title);
    List<Todos> findAllByUsers(Users users);
    void deleteById(Long id);
//    Todos updateTodo(TodoRequest todoRequest);

}
