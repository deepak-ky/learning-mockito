package org.kd4.impl;

import org.junit.Test;
import org.kd4.service.TodoService;
import org.kd4.service.TodoServiceStub;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class TodoBusinessImplTest {

    @Test
    public void retrieveTodosRelatedToSpring() {
        TodoService todoService = mock(TodoService.class);
        //Dynamically stubbing a method
        when(todoService.retrieveTodos("deepak")).thenReturn(Arrays.asList("asdf","spring"));

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);

        List<String> TodosContainingSpring = todoBusinessImpl.retrieveTodosRelatedToSpring("deepak");
        assertEquals(1,TodosContainingSpring.size());
    }

    @Test
    public void retrieveTodosRelatedToSpringWithEmptyList() {
        TodoService todoService = mock(TodoService.class);
        when(todoService.retrieveTodos("deepak")).thenReturn(Arrays.asList());

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);

        List<String> TodosContainingSpring = todoBusinessImpl.retrieveTodosRelatedToSpring("deepak");
        assertEquals(0,TodosContainingSpring.size());
    }

    @Test
    public void retrieveTodosRelatedToSpring_usingBDD() {
        // given
        TodoService todoService = mock(TodoService.class);
        given(todoService.retrieveTodos("deepak")).willReturn(Arrays.asList("asdf","spring"));
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);

        // when
        List<String> todosContainingSpring = todoBusinessImpl.retrieveTodosRelatedToSpring("deepak");

        // then
        assertThat(todosContainingSpring.size(), is(1));
    }

    @Test
    public void testDeleteTodosNotRelatedToSpring() {
        TodoService todoService = mock(TodoService.class);
        when(todoService.retrieveTodos("deepak")).thenReturn(Arrays.asList("asdf","asdf","spring", "spring 1"));
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);

        todoBusinessImpl.deleteTodosNotRelatedToSpring("deepak");

        //verify(todoService).deleteTodo("asdf"); THIS WILL FAIL // has deleteTodo("asdf") been called exactly once
        verify(todoService, times(2)).deleteTodo("asdf"); // has deleteTodo("asdf") been called at exactly once
        //verify(todoService, never()).deleteTodo("asdf"); THIS WILL FAIL
        verify(todoService, never()).deleteTodo("spring");
    }

    @Test
    public void testDeleteTodosNotRelatedToSpring_captureArgument(){
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class); // 1. declaring here
        TodoService todoService = mock(TodoService.class);
        when(todoService.retrieveTodos("deepak")).thenReturn(Arrays.asList("spring","asdf",";lkj","spring 1"));
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);

        todoBusinessImpl.deleteTodosNotRelatedToSpring("deepak");

        verify(todoService,times(2)).deleteTodo(argumentCaptor.capture()); // 2. capturing here
        /*
        If deleteTodo is only invoked once this can be written as :
            verify(todoService).deleteTodo(argumentCaptor.capture());
        */
        assertEquals(";lkj", argumentCaptor.getValue()); // 3. checking single value (behaving as a stack)
        assertEquals(Arrays.asList("asdf",";lkj"), argumentCaptor.getAllValues()); // 4. checking here
    }
}