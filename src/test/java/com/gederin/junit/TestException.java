package com.gederin.junit;

import org.junit.Test;

public class TestException {
	
	@Test(expected = NullPointerException.class)
	public void testException(){
		throw new NullPointerException();
	}
	
	@Test(expected = Exception.class)
	public void testException1(){
		throw new NullPointerException();
	}
	
	@Test(expected = Exception.class)
	public void testException2() throws Throwable{
		throw new Throwable();
	}
}
