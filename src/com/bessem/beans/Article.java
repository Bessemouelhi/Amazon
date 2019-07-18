package com.bessem.beans;

import java.io.Serializable;

public class Article {
	
	/*(reference varchar(30) NOT NULL,
			designation varchar(200) NOT NULL,
			prix decimal(8, 2) NOT NULL,*/
	
	private String reference;
	private String designation;
	private double prix;

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getDecimal() {
		return prix;
	}

	public void setDecimal(double decimal) {
		this.prix = decimal;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) throws BeanException {
		if (reference.length() > 30) {
			throw new BeanException("La reference est trop grande ! (30 caractères maximum)");
		}
		
		this.reference = reference;
	}
	
	

}
