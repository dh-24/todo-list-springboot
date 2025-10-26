package com.example.todolist.controller;

import com.example.todolist.model.Todo;
import com.example.todolist.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class TodoController {

    private static final Logger logger = LoggerFactory.getLogger(TodoController.class);
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // Homepage: Show all todos
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("todos", todoService.getAllTodos());
        return "index";
    }

    // To do page
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("todo", new Todo());
        return "add-todo";
    }

    // To do Form submission
    @PostMapping("/add")
    public String addTodo(@ModelAttribute Todo todo) {
        todoService.addTodo(todo);
        logger.info("Added new todo: {}", todo.getTask());
        return "redirect:/";
    }

    // To do details page
    @GetMapping("/todo/{id}")
    public String viewTodo(@PathVariable Long id, Model model) {
        Todo todo = todoService.getTodoById(id);
        model.addAttribute("todo", todo);
        return "todo-details";
    }

    // Delete to do
    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        logger.info("Deleted todo with id: {}", id);
        return "redirect:/";
    }

    // Toggle complete
    @GetMapping("/toggle/{id}")
    public String toggleComplete(@PathVariable Long id) {
        todoService.toggleComplete(id);
        return "redirect:/";
    }


}
