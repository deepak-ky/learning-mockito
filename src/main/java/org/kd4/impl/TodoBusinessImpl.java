package org.kd4.impl;

import java.util.ArrayList;
import java.util.List;
import org.kd4.service.TodoService;

// TodoBusinessImpl is SUT or System Under Test
// todoService is a Dependency
public class TodoBusinessImpl {
    private TodoService todoService;

    public TodoBusinessImpl(TodoService todoService) {
        this.todoService = todoService;
    }

    public List<String> retrieveTodosRelatedToSpring(String user){
        List<String> filteredTodos = new ArrayList<String>();
        List<String> allTodos = todoService.retrieveTodos(user);
        for (String todo : allTodos){
            if(todo.contains("spring")){
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }

    public void deleteTodosNotRelatedToSpring(String user){
        List<String> allTodos =  todoService.retrieveTodos(user);
        for (String todo : allTodos){
            if(!todo.contains("spring")){
                todoService.deleteTodo(todo);
            }
        }
    }

}
