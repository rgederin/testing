package com.gederin.mockito.mock; /**
 * Created by rgederin on 9/12/2016.
 */

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

public class ListTest {

    @Test
    public void testMockListSizeMethod(){
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2);
        assertEquals(2, listMock.size());
        assertNotEquals(3, listMock.size());
    }

    @Test
    public void testMockListSizeMethod_ReturnMultipleValues(){
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3);
        assertEquals(2, listMock.size());
        assertEquals(3, listMock.size());
    }

    @Test
    public void testMockListGetMethod(){
        List listMock = mock(List.class);
        when(listMock.get(0)).thenReturn("zero elem");
        assertEquals("zero elem", listMock.get(0));
        assertEquals(null, listMock.get(1));
    }

    @Test
    public void testMockListGetMethod_AnyInt(){
        List listMock = mock(List.class);
        when(listMock.get(anyInt())).thenReturn("some elem");
        assertEquals("some elem", listMock.get(0));
        assertEquals("some elem", listMock.get(450));
    }

    @Test(expected = RuntimeException.class)
    public void testMockListGetMethod_throwAnException(){
        List listMock = mock(List.class);
        when(listMock.get(5)).thenThrow(new RuntimeException());
        listMock.get(5);
    }
}
