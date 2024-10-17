package com.cdac.acts.titleenum;

public enum TypeEnum {
	SA("Savings Account"),
	CA("Current Account"),
	DA("Deposit Account");
	
	private String strType;
	
	//RESTRICTING OBJECT CREATION
	private TypeEnum(String string) {
		this.strType = string;
	}
	
	public String getValue() {
		return strType;
	}

}
