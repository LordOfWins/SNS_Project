package com.springstudy.webapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
  private static final List<Todo> todos = new ArrayList<>();

  static {
    todos.add(new Todo(1, "seungjae", "Learn Java", LocalDate.now().plusYears(1), false));
    todos.add(new Todo(2, "seungjae", "Learn Spring", LocalDate.now().plusYears(2), false));
    todos.add(new Todo(3, "seungjae", "Learn Spring Boot", LocalDate.now().plusYears(3), false));
    todos.add(new Todo(4, "seungjae", "Learn Project", LocalDate.now().plusYears(4), false));
  }

  public List<Todo> findByUsername(String username) {
    return todos;
  }

  public void addTodo(String username, String description, LocalDate targetDate, boolean isDone) {
    todos.add(new Todo(todos.size() + 1, username, description, targetDate, isDone));
  }
}
