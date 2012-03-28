package net.slowvic.springmvc.model;

import java.io.Serializable;

public class Company implements Serializable {

	private static final long serialVersionUID = -565011192782699483L;

	private String companyName;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}
