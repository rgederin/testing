package com.gederin.junit;

import com.gederin.junit.ArrayCompareTest;
import com.gederin.junit.StringHelperParameterizedTest;
import com.gederin.junit.StringHelperTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by rgederin on 9/12/2016.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({ArrayCompareTest.class, StringHelperParameterizedTest.class, StringHelperTest.class})
public class RunSeveralTests {
}
