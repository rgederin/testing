package com.gederin.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTimeout {

	@Test (timeout = 1000)
	public void testTimeOut() throws InterruptedException{
		Thread.sleep(2000);
	}
}
