package com.gederin.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestArithmeticUtil {
	private ArithmeticUtil arithmeticUtil = new ArithmeticUtil(3, 2);
	
	@Test
	public void testCorrectMult(){
		assertTrue(6 == arithmeticUtil.mult());
	}
	
	@Test
	public void testIncorrectMult(){
		assertFalse(9 == arithmeticUtil.mult());
	}
	
	@Test
	public void testFailureMult(){
		assertEquals(1, arithmeticUtil.mult());
	}
}
