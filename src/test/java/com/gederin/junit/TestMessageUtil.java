package com.gederin.junit;

import static org.junit.Assert.*;


import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class TestMessageUtil {
	private String message = "Hello World";
	private MessageUtil messageUtil = new MessageUtil(message);

	@Test
	public void testCorrectPrintMessage() {
		assertEquals(message, messageUtil.printMessage());
	}
	
	@Test
	public void testWrongPrintMessage(){
		assertFalse("Ololo" == messageUtil.printMessage());
	}
}
