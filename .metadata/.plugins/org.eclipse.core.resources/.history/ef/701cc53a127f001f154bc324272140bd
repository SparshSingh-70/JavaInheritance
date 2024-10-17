package com.cdac.acts.accounts;

import java.util.Date;

import com.cdac.acts.titleenum.TypeEnum;

public class SavingAccount extends Account {
	
	private TypeEnum accType;
	private final double savingInterest = 3;
		
	
	public SavingAccount(String accName, double accBal, Date dateOfOpening, TypeEnum accType) {
		
		super(accName, accBal, dateOfOpening);
		this.accType = accType;
		System.out.println("ACCOUNT:: Savings account Param Ctr Called");
		
	}

		public double getInterest() {
			return this.savingInterest;
		}
		 
		
		@Override
		public double applyInterest() {
			double bal = (super.getAccBal() * savingInterest )/100;
			bal = bal + super.getAccBal();
			return bal;
		}
		
		@Override
		public String toString() {
			
			return "[ Account Type: " + accType.getValue() + " "+ super.toString() + " ]";
		}
		
		
		
}
