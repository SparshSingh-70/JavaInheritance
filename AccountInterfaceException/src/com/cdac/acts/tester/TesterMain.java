package com.cdac.acts.tester;

import java.util.Date; 
import java.util.Scanner;

import com.cdac.acts.accounts.Account;
import com.cdac.acts.accounts.CurrentAccount;
import com.cdac.acts.accounts.DepositAccount;
import com.cdac.acts.accounts.SavingAccount;
import com.cdac.acts.exception.MinimumBalanceExpection;
import com.cdac.acts.titleenum.TypeEnum;


public class TesterMain {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Account [] acc = new Account [10];
		
		int accCount = 0;
		int choice = 0;
		
		do { 
			
			System.out.println("------- MENU -------");
			System.out.println("1. Create Account");
			System.out.println("2. Show Balance with Interest ");
			System.out.println("3. Withdraw Amount");
			System.out.println("4. Deposit Amount");
			System.out.println("5. Show Maturity Amount");
			System.out.println("6. Display All Accounts");
			System.out.println("0. Exit");
			System.out.println("Enter Choice: ");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				{
					
					System.out.println("1. Saving   2.Current    3.Deposit");
					int choice2 = 0;
					System.out.println("Which Type of Account you want to create? ");
					choice2 = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter Name: ");
					String name = sc.nextLine();
					System.out.println("Enter Initial Balance: ");
					double balance = sc.nextDouble();
					Date todayDate = new Date();
					//System.out.println("Date: "+ DateUtils.getFormattedDate(todayDate));
					
					switch(choice2) {
					
					case 1: 
						{	
							//Creating Savings Account
							//Dynamic Method Dispatch
							acc[accCount] = new SavingAccount(name, balance, todayDate, TypeEnum.valueOf("SA"));
							System.out.println("Saving Account Created Successfully ... ");
							System.out.println(acc[accCount]);
							accCount++;
							
							
						}break;
					case 2:
						{
							//Creating Current Account
							//Dynamic Method Dispatch
							acc[accCount] = new CurrentAccount(name, balance, todayDate, TypeEnum.valueOf("CA"));
							System.out.println("Current Account Created Successfully ... ");
							System.out.println(acc[accCount]);
							accCount++;
						}break;
						
					case 3:
						{
							//Creating Deposit Account
							//Dynamic Method Dispatch
							acc[accCount] = new DepositAccount(name, balance, todayDate, TypeEnum.valueOf("DA"));
							System.out.println("Deposit Account Created Successfully ... ");
							System.out.println(acc[accCount]);
							accCount++;
						}break;
						
					default: {
							System.out.println("Select Valid Account type");
						}break;
					} 
					// nested switch end here 
				
				}break; // case 1 ends here
			case 2:
				{
					System.out.println("Enter Your Account Number: ");
					int accNum = sc.nextInt();
					boolean found = false;
					for(int i = 0 ; i  < accCount && !found; i++) {
						if(acc[i].getAccNum() == accNum) {
							
							found = true;
							System.out.println("Account Found");
							
							if(acc[i] instanceof SavingAccount) {
								//System.out.println("Yes");
								// safe down-casting 
								SavingAccount sa = (SavingAccount)acc[i];
								double bal = sa.applyInterest(); 
//								here sa reference is getting created, sa reference to acc[i] of saving 
								//System.out.println(sa);
								System.out.println( acc[i] + "Balance with interest: " + bal);
							}
							else if(acc[i] instanceof CurrentAccount) {
								//System.out.println("Yes");
								CurrentAccount ca = (CurrentAccount)acc[i];
								double bal = ca.applyInterest();
								System.out.println( acc[i] + "Balance with interest: " + bal);
							}
							// used another method to compare the type of account instance
							else if(acc[i].getClass() == DepositAccount.class) {
								//System.out.println("Yes");
								DepositAccount da = (DepositAccount)acc[i];
								double bal = da.applyInterest();
								System.out.println( acc[i] + "Balance with interest: " + bal);
							}
							else {
								System.out.println("Not Found");
							} 
							
							
							
							// irrespective of the instanceof it is calling the respective child's class overriden 
							//method here i.e applyInterest()
							
							
							/*
							if(acc[i] instanceof SavingAccount) {
								//System.out.println("Yes");
								double bal = acc[i].applyInterest();
								System.out.println( acc[i] + "Balance with interest: " + bal);
							}
							else if(acc[i] instanceof CurrentAccount) {
								//System.out.println("Yes");
								double bal = acc[i].applyInterest();
								System.out.println( acc[i] + "Balance with interest: " + bal);
							}
							// used another method to compare the type of account instance
							else if(acc[i].getClass() == DepositAccount.class) {
								//System.out.println("Yes");
								double bal = acc[i].applyInterest();
								System.out.println( acc[i] + "Balance with interest: " + bal);
							}
							else {
								System.out.println("Not Found");
							}
							*/
							
							
//							this also works fine
//							double bal = acc[i].applyInterest();
//							System.out.println( acc[i] + "Balance with interest: " + bal);
							 
						}
						
					}// for loop ends here
					if(!found) {
					System.out.println("Account Number Invalid");
					}
					
				}break; // case 2 ends here
				
				
			case 3: // withdraw
				{
					System.out.println("Enter Your Account Number: ");
					int accNum = sc.nextInt();
					boolean found = false;
					for(int i = 0 ; i  < accCount && !found; i++) {
						if(acc[i].getAccNum() == accNum) {
							
							found = true;
							System.out.println("Account Found");
							System.out.println("Enter Amount u want to withdraw");
							double amt = sc.nextDouble();
							
							try {
								if(acc[i] instanceof SavingAccount) {
									
									SavingAccount sa = (SavingAccount) acc[i];
									System.out.println( "Balance: " + sa.getAccBal());
									double newBal = sa.withdrawAmount(amt);
									System.out.println("Updated Balance: " + newBal);
								}
								
								else if(acc[i] instanceof CurrentAccount) {
									CurrentAccount ca = (CurrentAccount) acc[i];
									System.out.println( "Balance: " + ca.getAccBal());
									double newBal = ca.withdrawAmount(amt);
									System.out.println("Updated Balance: " + newBal);
								}else {
									System.out.println("Account Entered Can't Withdraw!!");
								}
								
							} catch (MinimumBalanceExpection mb) {
								System.out.println( mb.getMessage());
							}
						}
							
						} // for ends here
					if(!found) {
						System.out.println("Account Number Invalid");
						}
				}break; //case 3 ends here
				
			case 4: // deposit
					{
						System.out.println("Enter Your Account Number: ");
						int accNum = sc.nextInt();
						boolean found = false;
						for(int i = 0 ; i  < accCount && !found; i++) {
							if(acc[i].getAccNum() == accNum) {
								
								found = true;
								System.out.println("Account Found");
								System.out.println("Enter Amount u want to Deposit");
								double amt = sc.nextDouble();
								
								
									if(acc[i] instanceof SavingAccount) {
										
										SavingAccount sa = (SavingAccount) acc[i];
										System.out.println( "Balance: " + sa.getAccBal());
										double newBal = sa.depositAmount(amt);
										System.out.println("Updated Balance: " + newBal);
									}
									
									else if(acc[i] instanceof CurrentAccount) {
										CurrentAccount ca = (CurrentAccount) acc[i];
										System.out.println( "Balance: " + ca.getAccBal());
										double newBal = ca.depositAmount(amt);
										System.out.println("Updated Balance: " + newBal);
									}else {
										System.out.println("Account Entered Can't Withdraw!!");
									}
									
								
								}
								
							} // for ends here
						if(!found) {
							System.out.println("Account Number Invalid");
							}
					} break;// case 4 ends here
			
			case 5: // show maturity amount 
					{
						System.out.println("Enter Your Account Number: ");
						int accNum = sc.nextInt();
						boolean found = false;
						for(int i = 0 ; i  < accCount && !found; i++) {
							if(acc[i].getAccNum() == accNum) {
								
								found = true;
								System.out.println("Account Found");
								System.out.println("Enter number of years of FD");
								int t = sc.nextInt();
								
								
									if(acc[i] instanceof DepositAccount) {
										
										DepositAccount da = (DepositAccount) acc[i];
										System.out.println( "Balance: " + da.getAccBal());
										double newBal = da.matureAmount(t);
										System.out.println("Maturity Amount after " + t + " years is: " + newBal);
									}else {
										System.out.println("Account Enter is not FD account");
									}
							}
							
						}// for ends here
						if(!found) {
							System.out.println("Account Number Invalid");
							}
					}break; // case 5 ends here
				
				
			case 6:
				{
					
					
					
					for(int i = 0; i < accCount ; i++) {
						System.out.println(acc[i]);
					}
				}break; // case 3 end here
				
			case 0:
				{
					System.out.println("Exit");
					break; 
				} // case 4 ends here
			
			default:{
				System.out.println("Enter Valid Choice");
			}
				
			}
			// main switch ends here
			
			
		}while(choice != 0);
	
		
		sc.close();
	
	}
	
	
	
}
