package net.slowvic.springmvc.model;

import java.io.Serializable;

public class Employee implements Serializable {

	private static final long serialVersionUID = -9004422032412540594L;

	private String userName;

	private int age;

	private Company company;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
}
