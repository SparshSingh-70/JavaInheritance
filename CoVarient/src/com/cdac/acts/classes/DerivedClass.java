package com.cdac.acts.classes;

public class DerivedClass extends BaseClass {
	
//	@Override
//	public Integer getNumber(Number a) {
//		return (Integer) a;
//	}
//	
//	@Override
//	public Short getNumber(Number a) {
//		return (Short) a;
//	}
	
	@Override
	public Double getNumber(Number a) {
		return (Double) a;
	}
	
	
	@Override
	public void printNum(Number a) {
		System.out.println("Number is "+ a);
	}
	
}
