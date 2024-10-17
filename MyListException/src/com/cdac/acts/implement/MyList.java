package com.cdac.acts.implement;

import com.cdac.acts.exception.ArrayException;

public interface MyList {
	void insert(int element) throws ArrayException;
	int retrieve(int index) throws ArrayException;
}
