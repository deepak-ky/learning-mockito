package org.kd4.service;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService{
    @Override
    public List<String> retrieveTodos(String user) {
        return Arrays.asList("learn spring","learn to dance","learn spring boot");
    }

    public void deleteTodo(String todo){

    }
}
