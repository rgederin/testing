package com.gederin.mockito.spy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;


/**
 * Created by rgederin on 9/12/2016.
 */
public class SpyTest {
    @Test
    public void test(){
        List listMcck = mock(ArrayList.class);
        stub(listMcck.size()).toReturn(5);
        assertEquals (5, listMcck.size());
    }

    @Test
    public void testSpy(){
        List listSpy = spy(ArrayList.class);
        assertEquals(0, listSpy.size());
        listSpy.add("test");
        assertEquals(1, listSpy.size());
        stub(listSpy.size()).toReturn(5);
        assertEquals(5, listSpy.size());
    }
}
