package com.gederin.junit;

public class ArithmeticUtil {
	private Integer a;
	private Integer b;
	
	
	public ArithmeticUtil(Integer a, Integer b) {
		super();
		this.a = a;
		this.b = b;
	}

	public int mult (){
		if (this.a == null && this.b == null){
			throw new NullPointerException();
		}
		return a * b;
	}
}
