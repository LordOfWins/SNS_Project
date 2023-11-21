package org.springstudy.backend.todo;

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
    todos.add(new Todo(1, "test", "Learn Java", LocalDate.now().plusYears(1), false));
    todos.add(new Todo(2, "test", "Learn Spring", LocalDate.now().plusYears(2), false));
    todos.add(new Todo(3, "test", "Learn Spring Boot", LocalDate.now().plusYears(3), false));
    todos.add(new Todo(4, "test", "Learn Project", LocalDate.now().plusYears(4), false));
  }

  public List<Todo> findByUsername(String username) {
    Predicate<Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
    return todos.stream().filter(predicate).toList();
  }

  public Todo addTodo(String username, String description, LocalDate targetDate, boolean isDone) {
    Todo todo = new Todo(todos.size() + 1, username, description, targetDate, isDone);
    todos.add(todo);
    return todo;
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