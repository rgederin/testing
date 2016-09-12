package com.gederin.junit;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TestMessageUtil.class,
				TestArithmeticUtil.class, TestAssertions.class,
				TestJunitAnnotation.class, TestExecutionProcedureJunit.class,
				TestTimeout.class, TestException.class, TestPrimeNumberChecker.class);

		System.out.println("\t*** Tests results *** \n");
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println("Is all tests corrects: " + result.wasSuccessful());
		System.out.println("Count of ran tests: " + result.getRunCount());
		System.out.println("Count of failure tests: "
				+ result.getFailureCount());
		System.out.println("Count of ignore tests: " + result.getIgnoreCount());
		System.out.println("Spent time: " + result.getRunTime() + " millis");

	}

}
