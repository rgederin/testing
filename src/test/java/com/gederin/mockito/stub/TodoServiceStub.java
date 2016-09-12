package com.gederin.mockito.stub;

import com.gederin.mockito.TodoService;

import java.util.Arrays;
import java.util.List;

/**
 * Created by rgederin on 9/12/2016.
 */
public class TodoServiceStub implements TodoService {
    public List<String> retrieveTodos(String user) {
        return Arrays.asList("Learn Spring MVC", "Learn Spring",
                "Learn to Dance");
    }

    public void deleteTodo(String todo) {

    }
}