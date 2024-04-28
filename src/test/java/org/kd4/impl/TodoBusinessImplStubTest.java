package org.kd4.impl;

import org.junit.Test;
import org.kd4.service.TodoService;
import org.kd4.service.TodoServiceStub;

import java.util.List;

import static org.junit.Assert.assertEquals;



public class TodoBusinessImplStubTest {
    @Test
    public void testRetrieveTodosRelatedToSpring_usingAStub() {
        TodoService todoServiceStub = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);

        List<String> TodosContainingSpring = todoBusinessImpl.retrieveTodosRelatedToSpring("DummyUser");
        assertEquals(2,TodosContainingSpring.size());
    }
}