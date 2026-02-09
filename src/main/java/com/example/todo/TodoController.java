package com.example.todo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {

  // Affiche la page de la liste des todos.
  @GetMapping("/todos")
  public String listTodos() {
    return "todo/list";
  }

  // Affiche la page de création d'un nouveau todo.
  @GetMapping("/todos/new")
  public String showForm() {
    return "todo/form";
  }

  // Affiche la page de détail du todo pour l'id donné.
  @GetMapping("/todos/{id}")
  public String showTodo(@PathVariable("id") long id) {
    return "todo/detail";
  }

  // Traite l'enregistrement final à partir des valeurs cachées du formulaire de
  // confirmation.
  @PostMapping("/todos/complete")
  public String completeTodo(
      @RequestParam(name = "title", required = true) String title,
      @RequestParam(name = "description", required = false) String description,
      @RequestParam(name = "priority", required = false, defaultValue = "3") Integer priority,
      Model model) {
    model.addAttribute("title", title);
    model.addAttribute("description", description);
    model.addAttribute("priority", priority);
    return "todo/complete";
  }
}
