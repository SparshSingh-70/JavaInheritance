package com.cdac.acts.accounts;

import java.util.Date;

import com.cdac.acts.utils.DateUtils;

public abstract class Account {
	private int accNum;
	private String accName;
	private double accBal;
	private Date dateOfOpening;
	
	private static int  accGen = 1000;

	public Account( String accName, double accBal, Date dateOfOpening) {
		System.out.println("ACCOUNT:: Param Ctr Called");
		this.accNum = accGen++;
		this.accName = accName;
		this.accBal = accBal;
		this.dateOfOpening = dateOfOpening;
	}
	
	
	
	public double getAccBal() {
		return this.accBal;
	}
	
	public Date getDateOfOpening() {
		return this.dateOfOpening;
	} 
	
	public int getAccNum() {
		return this.accNum;
	}
	
	public void setBal(double bal) {
		this.accBal = bal;
	}
	 
	public abstract double applyInterest();



	@Override
	public String toString() {
		return " [accNum=" + accNum + ", accName=" + accName + ", accBal=" + accBal + ", dateOfOpening="
				+ DateUtils.getFormattedDate(dateOfOpening) + "]";
	}
	
	 
	
	
	
	
	
	
	
}
