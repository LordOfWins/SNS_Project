package org.springstudy.backend.todo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springstudy.backend.todo.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
  List<Todo> findByUsername(String username);
}