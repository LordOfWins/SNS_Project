package org.springstudy.backend.todo;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springstudy.backend.todo.repository.TodoRepository;

@RestController
public class TodoJpaResource {

  private final TodoRepository todoRepository;

  public TodoJpaResource(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  @GetMapping("/users/{username}/todos")
  public List<Todo> getAllTodos(@PathVariable String username) {
    return todoRepository.findByUsername(username);
  }

  @GetMapping("/users/{username}/todos/{id}")
  public Todo getTodo(@PathVariable String username, @PathVariable int id) {
    return todoRepository.findById(id).orElse(null);
  }

  @DeleteMapping("/users/{username}/todos/{id}")
  public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable int id) {
    todoRepository.deleteById(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/users/{username}/todos/{id}")
  public Todo updateTodo(
      @PathVariable String username, @PathVariable int id, @RequestBody Todo todo) {
    todoRepository.save(todo);
    return todo;
  }

  @PostMapping("/users/{username}/todos")
  public Todo createTodo(@PathVariable String username, @RequestBody Todo todo) {
    todo.setUsername(username);
    todo.setId(null);
    return todoRepository.save(todo);
  }
}