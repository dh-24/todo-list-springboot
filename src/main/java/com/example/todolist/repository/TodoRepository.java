package com.example.todolist.repository;

import com.example.todolist.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

// This talks to the data access layer
public interface TodoRepository extends JpaRepository<Todo, Long> {
    /*
    This interface gives CRUD functionality for the To do entity
    without needing to write any SQL or extra code.

    JpaRepository<To do, Long> means:
    To do > entity type this repo managages
    Long > type of entity's primary key
     */
}
