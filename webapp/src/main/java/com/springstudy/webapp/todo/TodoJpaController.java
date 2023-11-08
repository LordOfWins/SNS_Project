package com.springstudy.webapp.todo;

import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoJpaController {

  private final TodoRepository todoRepository;

  public TodoJpaController(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  private static String getLoggedInUserName(ModelMap modelMap) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    return authentication.getName();
  }

  @RequestMapping("list")
  public String listTodos(ModelMap modelMap) {
    String username = getLoggedInUserName(modelMap);
    List<Todo> todos = todoRepository.findByUsername(username);
    modelMap.addAttribute("todos", todos);
    return "listTodos";
  }

  @RequestMapping(value = "add", method = RequestMethod.GET)
  public String showTodo(ModelMap modelMap) {
    String username = getLoggedInUserName(modelMap);
    Todo todo = new Todo(0, username, "des", LocalDate.now().plusYears(1), false);
    modelMap.put("todo", todo);
    return "todo";
  }

  @RequestMapping(value = "add", method = RequestMethod.POST)
  public String addTodo(ModelMap modelMap, @Valid Todo todo, BindingResult result) {
    if (result.hasErrors()) {
      return "todo";
    }
    String username = getLoggedInUserName(modelMap);
    todo.setUsername(username);
    todoRepository.save(todo);
    return "redirect:list";
  }

  @RequestMapping("delete")
  public String deleteTodo(int id) {
    todoRepository.deleteById(id);
    //    todoService.deleteById(id);
    return "redirect:list";
  }

  @RequestMapping(value = "update", method = RequestMethod.GET)
  public String showUpdateTodo(int id, ModelMap modelMap) {
    Todo todo = todoRepository.findById(id).orElse(null);
    if (todo == null) {
      return "redirect:list";
    }
    modelMap.put("todo", todo);
    return "todo";
  }

  @RequestMapping(value = "update", method = RequestMethod.POST)
  public String updateTodo(ModelMap modelMap, @Valid Todo todo, BindingResult result) {
    if (result.hasErrors()) {
      return "todo";
    }
    String username = getLoggedInUserName(modelMap);
    todo.setUsername(username);
    todoRepository.save(todo);
    return "redirect:list";
  }
}
