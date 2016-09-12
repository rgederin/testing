package com.gederin.junit;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * JUnit trivial examples
 */
public class StringHelperTest {
    private final String AACD = "AACD";
    private final String AACDAA = "AACDAA";
    private final String ACD = "ACD";
    private final String CD = "CD";
    private StringHelper helper;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("test begin...");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("test end ...");
    }

    @Before
    public void beforeTest() {
        helper = new StringHelper();
    }

    @After
    public void afterTest() {
        helper = null;
    }

    @Test
    public void testTruncateAInFirst2Positions_AinFirst2Position() {
        assertEquals(CD, helper.truncateAInFirst2Positions(AACD));
    }

    @Test
    public void testTruncateAInFirst2Positions_AinFirstPosition() {
        assertEquals(CD, helper.truncateAInFirst2Positions(ACD));
    }

    @Test(expected = NullPointerException.class)
    public void testTruncateAInFirst2Positions_NullArg() {
        assertEquals(CD, helper.truncateAInFirst2Positions(null));
    }

    @Test
    public void testTruncateAInFirst2Positions_EmptyArg() {
        assertEquals("", helper.truncateAInFirst2Positions(""));
    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_BasicFalseFlow() {
        assertFalse(helper.areFirstAndLastTwoCharactersTheSame(AACD));
    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_BasicTrueFlow() {
        assertTrue(helper.areFirstAndLastTwoCharactersTheSame(AACDAA));
    }
}