package com.springstudy.webapp.todo;

import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
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

  public void deleteById(int id) {
    todos.removeIf((Predicate<? super Todo>) todo -> todo.getId() == id);
  }

  public Todo findById(int id) {
    Predicate<Todo> predicate = todo -> todo.getId() == id;
    return todos.stream().filter(predicate).findFirst().orElse(null);
  }

  public void updateTodo(@Valid Todo todo) {
    deleteById(todo.getId());
    todos.add(todo);
  }
}
