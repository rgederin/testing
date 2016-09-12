package com.gederin.mockito.mock;

import com.gederin.mockito.TodoBusinessImpl;
import com.gederin.mockito.TodoService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by rgederin on 9/12/2016.
 */
public class TodoBusinessImplMockTest {
    private TodoService todoServiceMock;
    private TodoBusinessImpl todoBusinessImpl;
    private List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring",
            "Learn to Dance");

    @Before
    public void before() {
        todoServiceMock = mock(TodoService.class);
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(Arrays.asList("Learn Spring MVC", "Learn Spring",
                "Learn to Dance"));
        todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
    }

    @Test
    public void testRetrieveTodosRelatedToSpring_usingStub() {
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(2, filteredTodos.size());
    }

    @Test
    public void testDeleteTodosNotRelatedToSpring() {
        //Given
        TodoService todoServiceMock = mock(TodoService.class);
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceMock);

        //When
        todoBusiness.deleteTodosNotRelatedToSpring("Dummy");

        //Then
        verify(todoServiceMock).deleteTodo("Learn to Dance");
        verify(todoServiceMock, times(1)).deleteTodo("Learn to Dance");
        verify(todoServiceMock, atLeastOnce()).deleteTodo("Learn to Dance");
        verify(todoServiceMock, atLeast(1)).deleteTodo("Learn to Dance");
        verify(todoServiceMock, never()).deleteTodo("Learn Spring MVC");
    }

    @Test
    public void testDeleteTodosNotRelatedToSpring_then() {
        //Given
        TodoService todoServiceMock = mock(TodoService.class);
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceMock);

        //When
        todoBusiness.deleteTodosNotRelatedToSpring("Dummy");

        //Then
        then(todoServiceMock).should().deleteTodo("Learn to Dance");
    }


    @Test
    public void testDeleteTodosNotRelatedToSpring_BDD_argumentCapture() {
        //Declare Argument captor
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

        //Given
        TodoService todoServiceMock = mock(TodoService.class);
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceMock);

        //When
        todoBusiness.deleteTodosNotRelatedToSpring("Dummy");

        //Then
        then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());

        assertThat(stringArgumentCaptor.getValue(), is("Learn to Dance"));
    }

    @Test
    public void testDeleteTodosNotRelatedToSpring_BDD_MultipleArgumentCapture() {
        //Declare Argument captor
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        List<String> todos = Arrays.asList("Learn MVC", "Learn Spring",
                "Learn to Dance");
        //Given
        TodoService todoServiceMock = mock(TodoService.class);
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceMock);

        //When
        todoBusiness.deleteTodosNotRelatedToSpring("Dummy");

        //Then
        then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());

        assertThat(stringArgumentCaptor.getAllValues().size(), is(2));
    }
}
