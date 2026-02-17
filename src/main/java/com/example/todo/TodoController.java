package com.example.todo;

import com.example.todo.form.TodoForm;
import com.example.todo.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TodoController {

  private final TodoService todoService;

  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  // Affiche la page de la liste des todos.
  @GetMapping("/todos")
public String listTodos() {
    return "todo/list";
}


  // Affiche la page de creation d'un nouveau todo.
  @GetMapping("/todos/new")
  public String showForm() {
    return "todo/form";
  }

  // Affiche la page de detail du todo pour l'id donne.
  @GetMapping("/todos/{id}")
  public String showTodo(@PathVariable("id") long id) {
    return "todo/detail";
  }

  // Recoit le formulaire et affiche l'ecran de confirmation.
  @PostMapping("/todos/confirm")
  public String confirmTodo(@ModelAttribute TodoForm form, Model model) {
    model.addAttribute("todoForm", form);
    return "todo/confirm";
  }

  // Enregistre le todo et redirige vers la liste avec un message flash.
  @PostMapping("/todos/complete")
  public String completeTodo(@ModelAttribute TodoForm form, RedirectAttributes redirectAttributes) {
    todoService.createTodo(form);
    redirectAttributes.addFlashAttribute("message", "登録が完了しました");
    return "redirect:/todos";
  }
}
