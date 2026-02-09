package com.example.todo.service;

import com.example.todo.entity.Todo;
import com.example.todo.form.TodoForm;
import com.example.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

  private final TodoRepository todoRepository;

  public TodoService(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  public Todo createTodo(TodoForm form) {
    Todo todo = toEntity(form);
    return todoRepository.save(todo);
  }

  private Todo toEntity(TodoForm form) {
    return Todo.builder()
        .title(form.getTitle())
        .description(form.getDescription())
        .priority(form.getPriority() == null ? 1 : form.getPriority())
        .completed(false)
        .build();
  }
}
