package com.gederin.powermock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rgederin on 9/12/2016.
 */

interface Dependency {
    List<Integer> retrieveAllStats();
}

class UtilityClass {
    static int staticMethod(long value) {
        // Some complex logic is done here...
        throw new RuntimeException(
                "I dont want to be executed. I will anyway be mocked out.");
    }
}

public class SystemUnderPowerMockTest {

    private Dependency dependency;

    public int methodUsingAnArrayListConstructor() {
        ArrayList list = new ArrayList();
        return list.size();
    }

    public int methodCallingAStaticMethod() {
        //privateMethodUnderTest calls static method SomeClass.staticMethod
        List<Integer> stats = dependency.retrieveAllStats();
        long sum = 0;
        for (int stat : stats)
            sum += stat;
        return UtilityClass.staticMethod(sum);
    }

    private long privateMethodUnderTest() {
        List<Integer> stats = dependency.retrieveAllStats();
        long sum = 0;
        for (int stat : stats)
            sum += stat;
        return sum;
    }
}
