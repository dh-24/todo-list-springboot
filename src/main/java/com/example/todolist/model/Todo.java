package com.example.todolist.model;

import jakarta.persistence.*;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String task;
    private boolean completed;

    // default constructor for JPA
    public Todo() {}

    // create a new todo with task name
    public Todo(String task) {
        this.task = task;
        this.completed = false;
    }

    // getters and setters
    public Long getId() {return id;}
    public String getTask() {return task;}
    public void setTask(String task) {this.task = task;}
    public boolean isCompleted() {return completed;}
    public void setCompleted(boolean completed) {this.completed = completed;}
}
