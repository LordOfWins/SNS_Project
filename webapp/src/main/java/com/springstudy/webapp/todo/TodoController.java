package com.springstudy.webapp.todo;

import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TodoController {

  private final TodoService todoService;

  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @RequestMapping("list")
  public String listTodos(ModelMap modelMap) {
    List<Todo> todos = todoService.findByUsername("seungjae");
    modelMap.addAttribute("todos", todos);
    return "listTodos";
  }

  // GET, POST 상관 없음
  @RequestMapping(value = "add", method = RequestMethod.GET)
  public String showTodo(ModelMap modelMap) {
    String username = (String) modelMap.get("name");
    Todo todo = new Todo(0, username, "des", LocalDate.now().plusYears(1), false);
    modelMap.put("todo", todo);
    return "todo";
  }

  @RequestMapping(value = "add", method = RequestMethod.POST)
  public String addTodo(ModelMap modelMap, @Valid Todo todo, BindingResult result) {
    if (result.hasErrors()) {
      return "todo";
    }
    String username = (String) modelMap.get("name");
    todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), false);
    return "redirect:list";
  }

  @RequestMapping("delete")
  public String deleteTodo(int id) {
    todoService.deleteById(id);
    return "redirect:list";
  }

  @RequestMapping(value = "update", method = RequestMethod.GET)
  public String showUpdateTodo(int id, ModelMap modelMap) {
    Todo todo = todoService.findById(id);
    modelMap.put("todo", todo);
    return "todo";
  }

  @RequestMapping(value = "update", method = RequestMethod.POST)
  public String updateTodo(ModelMap modelMap, @Valid Todo todo, BindingResult result) {
    if (result.hasErrors()) {
      return "todo";
    }
    String username = (String) modelMap.get("name");
    todo.setUsername(username);
    todoService.updateTodo(todo);
    return "redirect:list";
  }
}
