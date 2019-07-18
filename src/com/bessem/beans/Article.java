package com.bessem.beans;

import java.io.Serializable;
import java.util.Comparator;

public class Article implements Comparable<Article> {
	
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

	@Override
	public int compareTo(Article art) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static Comparator<Article> compareByRef = new Comparator<Article>() {
	    @Override
	    public int compare(Article o1, Article o2) {
	        return o1.getReference().compareTo(o2.getReference());
	    }
	};
	
	public static Comparator<Article> compareByDes = new Comparator<Article>() {
	    @Override
	    public int compare(Article o1, Article o2) {
	        return o1.getDesignation().compareTo(o2.getDesignation());
	    }
	};
	
	public static Comparator<Article> compareByPrix = new Comparator<Article>() {
	    @Override
	    public int compare(Article o1, Article o2) {
	        return Double.compare(o1.getDecimal(), o2.getDecimal());
	    }
	};
	
	

}
