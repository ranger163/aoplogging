package me.inassar.aoplogging.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.inassar.aoplogging.todo.domain.TodoList;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllTodos {
    private List<TodoList> todoLists;
}