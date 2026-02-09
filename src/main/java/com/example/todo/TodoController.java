package com.example.todo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TodoController {

  // Affiche la page de la liste des todos.
  @GetMapping("/todos")
  public String listTodos() {
    return "todo/list";
  }

  // Affiche la page de création d'un nouveau todo.
  @GetMapping("/todos/new")
  public String newTodo() {
    return "todo/new";
  }

  // Affiche la page de détail du todo pour l'id donné.
  @GetMapping("/todos/{id}")
  public String showTodo(@PathVariable("id") long id) {
    return "todo/detail";
  }
}
