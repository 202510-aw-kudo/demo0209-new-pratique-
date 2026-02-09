package com.example.todo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TodoController {

  // Display the todo list page.
  @GetMapping("/todos")
  public String listTodos() {
    return "todo/list";
  }

  // Display the new todo creation page.
  @GetMapping("/todos/new")
  public String newTodo() {
    return "todo/new";
  }

  // Display the todo detail page for the given id.
  @GetMapping("/todos/{id}")
  public String showTodo(@PathVariable("id") long id) {
    return "todo/detail";
  }
}
