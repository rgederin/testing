package com.gederin.mockito;

import java.util.List;

/**
 * Created by rgederin on 9/12/2016.
 */
public interface TodoService {
    public List<String> retrieveTodos(String user);
    public void deleteTodo(String todo);
}
