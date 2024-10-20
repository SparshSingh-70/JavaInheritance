package com.cdac.acts.list;

import com.cdac.acts.exception.ArrayException;
import com.cdac.acts.implement.MyList;

public class ListFixed implements MyList {
	
	private final int size ;
	private int currIndex; 
	private int arr[];
	
	 public ListFixed() {
		this.currIndex = 0;
		this.size = 5;
		this.arr = new int [size];
	} 

	 
	@Override
	public void insert(int element) throws ArrayException {
		if(currIndex == size ) {
			throw new ArrayException("Size if Full");  
		} 
		arr[currIndex++] = element;
		
	}

	@Override
	public int retrieve(int index) throws ArrayException {
		if(index < 0 || index > size - 1) {
			throw new ArrayException("Array index out of bound");
		}
		return arr[index];
	}
		
	

}
