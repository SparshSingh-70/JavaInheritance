package com.cdac.acts.accounts;

import java.util.Date;

import com.cdac.acts.implement.Maturable;
import com.cdac.acts.titleenum.TypeEnum;

public class DepositAccount extends Account implements Maturable {
	
	private TypeEnum accType;
	private final double depositInterest = 8;

	public DepositAccount(String accName, double accBal, Date dateOfOpening, TypeEnum accType) {
		super(accName, accBal, dateOfOpening);
		this.accType = accType;
		System.out.println("ACCOUNT:: Deposit account Param Ctr Called");
		
	} 

	@Override
	public double applyInterest() {
		double bal = (super.getAccBal() * depositInterest )/100;
		bal = bal + super.getAccBal(); 
		return bal;
	}

	

	@Override
	public double matureAmount(int year) {
		double matureBal = (super.getAccBal() * year * depositInterest)/100;
		matureBal = matureBal + super.getAccBal(); 
		return matureBal;
	}
	
	@Override
	public String toString() {
		
		return "[ Account Type: " + accType.getValue() + " "+ super.toString() + " ]";
	}
}
