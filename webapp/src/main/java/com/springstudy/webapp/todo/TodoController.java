package com.springstudy.webapp.todo;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
  public String showTodo() {
    return "todo";
  }

  @RequestMapping(value = "add", method = RequestMethod.POST)
  public String addTodo(String description, ModelMap modelMap) {
    String username = (String) modelMap.get("name");
    todoService.addTodo(username, description, LocalDate.now().plusYears(1), false);
    return "redirect:list";
  }
}
