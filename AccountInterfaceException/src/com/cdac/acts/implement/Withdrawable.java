package com.cdac.acts.implement;

import com.cdac.acts.exception.MinimumBalanceExpection;

@FunctionalInterface
public interface Withdrawable  {
	double withdrawAmount(double amount) throws MinimumBalanceExpection;
	
}
