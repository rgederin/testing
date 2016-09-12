package com.gederin.mockito.annotation;

import com.gederin.mockito.TodoBusinessImpl;
import com.gederin.mockito.TodoService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by rgederin on 9/12/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoAnnotationTest {
    private List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring",
            "Learn to Dance");

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private TodoService todoServiceMock;

    @InjectMocks
    private TodoBusinessImpl todoBusiness;

    @Test
    public void testRetrieveTodosRelatedToSpring(){
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
        assertEquals(2, todoBusiness.retrieveTodosRelatedToSpring("Dummy").size());
    }
}
