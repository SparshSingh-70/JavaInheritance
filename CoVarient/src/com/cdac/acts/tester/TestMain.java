package com.cdac.acts.tester;
import com.cdac.acts.classes.*;

public class TestMain {
	public static void main(String[] args) {
		
		DerivedClass b = new DerivedClass();
		Double cc = 4.494;
		//Integer c = (Integer)b.getNumber(cc);
		
		Double sd = (Double)b.getNumber(cc);
		b.printNum(sd);
		
		
	} 
	
}
