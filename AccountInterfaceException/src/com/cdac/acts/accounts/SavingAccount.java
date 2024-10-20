package com.cdac.acts.accounts;

import java.util.Date;

import com.cdac.acts.exception.MinimumBalanceExpection;
import com.cdac.acts.implement.Depositable;
import com.cdac.acts.implement.Withdrawable;
import com.cdac.acts.titleenum.TypeEnum;

public class SavingAccount extends Account implements Withdrawable, Depositable {
	
	//Data Members
	private TypeEnum accType;
	private final double savingInterest = 3;
	private static final double MINIMUM_BALANCE_SAV = 1000.00;
		 
	
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
		public double withdrawAmount(double amount) throws MinimumBalanceExpection {
			if(super.getAccBal() - amount < MINIMUM_BALANCE_SAV) {
				MinimumBalanceExpection mbe = new MinimumBalanceExpection("Amount Exceeding the Minimunm Balance");
				throw mbe;
			}
			double bal = super.getAccBal() - amount;
			super.setBal(bal);
			return bal;
		}
		
		
		@Override
		public double depositAmount(double amount) {
			double bal = super.getAccBal() + amount;
			super.setBal(bal);
			return bal;
		}
		
		
		
		
		
		
		
		@Override
		public String toString() {
			
			return "[ Account Type: " + accType.getValue() + " "+ super.toString() + " ]";
		}
		
		
		
}
