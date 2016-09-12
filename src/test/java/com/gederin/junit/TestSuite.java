package com.gederin.junit;
import junit.framework.*;
public class TestSuite {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 // add the test's in the suite
	      junit.framework.TestSuite suite = new junit.framework.TestSuite(TestArithmeticUtil.class, TestMessageUtil.class);
	      TestResult result = new TestResult();
	      suite.run(result);
	      System.out.println("Number of test cases = " + result.runCount());
	}
}
