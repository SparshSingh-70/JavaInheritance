package com.cdac.acts.tester;

import java.util.Scanner;

import com.cdac.acts.exception.ArrayException;
import com.cdac.acts.list.ListFixed;
import com.cdac.acts.list.ListGrowable;

public class TesterMain {
	public static void main(String[] args)  {
		Scanner sc= new Scanner(System.in);
		
		ListFixed fl = new ListFixed(); 
		
		try { 
			fl.retrieve(10);
		} catch (ArrayException ae ) {
			System.out.println(ae.getMessage()); 
		} 
		finally {

			sc.close();
		}
	  
		 
		
		
//		try {
//			for(int i = 0 ; i < 5; i++) {
//				System.out.println("Enter Element: ");
//				int ele = sc.nextInt(); 
//				fl.insert(ele);
//			}
//			
//			for(int i = 0 ; i <= 5; i++) {
//				System.out.print(fl.retrieve(i) + " ");
//			}
//		} catch (ArrayException ae) {
//			System.out.println(ae.getMessage());
//		}
//		finally {
//			System.out.println("Fixed List Gracefull Execution");
//		}
		
		
		//ListGrowable gl = new ListGrowable();
		
//		try {
//			for(int i = 0 ; i < 10; i++) {
//				System.out.println("Enter Element: ");
//				int ele = sc.nextInt(); 
//				gl.insert(ele);
//			}
//			
//			for(int i = 0 ; i < 10; i++) {
//				System.out.print(gl.retrieve(i) + " ");
//			}
//		} catch (ArrayException ae) {
//			System.out.println(ae.getMessage());
//		}
//		finally {
//			System.out.println("Fixed List Gracefull Execution");
//			sc.close();
//		}
		
	}
}
