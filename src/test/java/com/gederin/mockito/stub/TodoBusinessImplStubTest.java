package com.gederin.mockito.stub;

import com.gederin.mockito.TodoBusinessImpl;
import com.gederin.mockito.TodoService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by rgederin on 9/12/2016.
 */
public class TodoBusinessImplStubTest {
    private TodoService todoService;
    private TodoBusinessImpl todoBusinessImpl;

    @Before
    public void before(){
        todoService = new TodoServiceStub();
        todoBusinessImpl = new TodoBusinessImpl(todoService);
    }

    @Test
    public void testRetrieveTodosRelatedToSpring_usingStub() {
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(2, filteredTodos.size());
    }
}