package com.gederin.powermock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


/**
 * Created by rgederin on 9/12/2016.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UtilityClass.class)
public class SystemUnderPowerMockTestTest {
    @Mock
    private Dependency dependency;

    @InjectMocks
    private SystemUnderPowerMockTest systemUnderPowerMockTest;


    @Test
    public void testMethodCallingAStaticMethod() {
        List<Integer> stats = Arrays.asList(1, 2, 3);
        when(dependency.retrieveAllStats()).thenReturn(stats);

        PowerMockito.mockStatic(UtilityClass.class);
        when(UtilityClass.staticMethod(6)).thenReturn(150);

        int result = systemUnderPowerMockTest.methodCallingAStaticMethod();
        assertEquals(150, result);

        PowerMockito.verifyStatic();
        UtilityClass.staticMethod(6);
    }


    @Test
    public void PrivateMethodUnderTest() throws Exception {
        List<Integer> stats = Arrays.asList(1, 2, 3);
        when(dependency.retrieveAllStats()).thenReturn(stats);

        long result = Whitebox.invokeMethod(systemUnderPowerMockTest, "privateMethodUnderTest");
        assertEquals(6, result);
    }
}