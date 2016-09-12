package com.gederin.junit;

import com.gederin.junit.StringHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

/**
 * Parameterized JUnit test
 */
@RunWith(Parameterized.class)
public class StringHelperParameterizedTest {
    private StringHelper helper = new StringHelper();
    private String input;
    private String output;

    public StringHelperParameterizedTest(String input, String output) {
        this.input = input;
        this.output = output;
    }

    @Parameterized.Parameters
    public static Collection<String[]> testConditions() {
        String[][] expectedOutputs = {{"AACD", "CD"}, {"ACD", "CD"}};
        return Arrays.asList(expectedOutputs);
    }

    @Test
    public void testTruncateAInFirst2Positions() {
        assertEquals(output, helper.truncateAInFirst2Positions(input));
    }
}
