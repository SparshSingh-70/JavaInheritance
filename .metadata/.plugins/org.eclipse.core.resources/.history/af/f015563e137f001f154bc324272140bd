package com.cdac.acts.accounts;

import java.util.Date;

import com.cdac.acts.titleenum.TypeEnum;

public class CurrentAccount extends Account {
	
	private TypeEnum accType;
	private final double currentInterest = 1;

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
	public String toString() {
		
		return "[ Account Type: " + accType.getValue() + " "+ super.toString() + " ]";
	}
}
