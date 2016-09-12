package com.gederin.mockito.bdd;

import com.gederin.mockito.TodoBusinessImpl;
import com.gederin.mockito.TodoService;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by rgederin on 9/12/2016.
 */
public class BddStyleTest {
    private List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring",
            "Learn to Dance");
    @Test
    public void testRetrieveTodosRelatedToSpring(){
        //Given
        TodoService todoServiceMock = mock(TodoService.class);
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceMock);

        //When
        List<String> filteredTodos = todoBusiness.retrieveTodosRelatedToSpring("Dummy");

        //Then
        assertThat(filteredTodos.size(), is(2));
    }
}
