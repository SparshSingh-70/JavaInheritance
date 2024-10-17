package com.cdac.acts.accounts;

import java.util.Date;

import com.cdac.acts.exception.MinimumBalanceExpection;
import com.cdac.acts.implement.Depositable;
import com.cdac.acts.implement.Withdrawable;
import com.cdac.acts.titleenum.TypeEnum;

public class CurrentAccount extends Account implements Withdrawable, Depositable{
	
	//Data Members
	private TypeEnum accType;
	private final double currentInterest = 1;
	private static final double MINIMUM_BALANCE_CURR = 2000.00 ; 
	
	public CurrentAccount(String accName, double accBal, Date dateOfOpening, TypeEnum accType) {
		super(accName, accBal, dateOfOpening);
		this.accType = accType;
		System.out.println("ACCOUNT:: current account Param Ctr Called");
	}

	@Override
	public double applyInterest() {
		double bal = (super.getAccBal() * currentInterest )/100;
		bal = bal + super.getAccBal();
		return bal;
	}
	
	
	
	@Override
	public double depositAmount(double amount) {
		
		double bal = super.getAccBal()+amount;
		super.setBal(bal);
		return bal;
	}
	
	@Override
	public double withdrawAmount(double amount) throws MinimumBalanceExpection {
		if(super.getAccBal() - amount < MINIMUM_BALANCE_CURR) {
			MinimumBalanceExpection mbe = new MinimumBalanceExpection("Amount Exceeding the Minimunm Balance");
			throw mbe;
		}
		double bal = super.getAccBal() - amount;
		super.setBal(bal);
		return bal;
	}
	
	

	@Override
	public String toString() {
		
		return "[ Account Type: " + accType.getValue() + " "+ super.toString() + " ]";
	}
}
