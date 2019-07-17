package com.bessem.beans;

import java.io.Serializable;

public class Article implements Serializable {
	
	/*(reference varchar(30) NOT NULL,
			designation varchar(200) NOT NULL,
			prix decimal(8, 2) NOT NULL,*/
	
	private String reference;
	private String designation;
	private double decimal;

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getDecimal() {
		return decimal;
	}

	public void setDecimal(double decimal) {
		this.decimal = decimal;
	}

	public String getReference() {
		return reference;
	}

}
