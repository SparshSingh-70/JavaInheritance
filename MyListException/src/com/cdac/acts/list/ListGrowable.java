package com.cdac.acts.list;

import com.cdac.acts.exception.ArrayException;
import com.cdac.acts.implement.MyList;

public class ListGrowable implements MyList {
	private int size;
	private int currIndex;
	private int arr[];
	
	public ListGrowable() {
		this.size = 5;
		this.currIndex = 0;
		this.arr = new int [size];
	}

	@Override
	public void insert(int element) {
		if(currIndex == size ) {
			// increase size
			size = size * 2;
			// create temp array of new size 
			int tempArr [] = new int[size];
			
			// copy elements to temp array
			for(int i = 0 ; i < currIndex; i++) {
				tempArr[i] = arr[i];
			}
			// assign the temp array to arr 
			arr = tempArr;
		}
		arr[currIndex++] = element;
	} 

	@Override
	public int retrieve(int index) throws ArrayException {
		if(index < 0 || index > size - 1) {
			ArrayException ae = new ArrayException("Array out of Bound");
			throw ae;
			
		}
		return arr[index];
	}
	 
	
	
}
