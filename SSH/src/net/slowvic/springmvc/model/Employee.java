package net.slowvic.springmvc.model;

import java.io.Serializable;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class Employee implements Serializable {

	private static final long serialVersionUID = -9004422032412540594L;

	@Pattern(regexp = "\\w{4,20}")
	private String userName;

	private int age;

	private Company company;

	@NumberFormat(style = Style.CURRENCY, pattern = "##.##")
	@DecimalMin("3000")
	private double salary;

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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(128);
		sb.append("员工姓名：").append(userName).append("\n");
		sb.append("年龄：").append(age).append("\n");
		sb.append("公司：").append(company.getCompanyName()).append("\n");
		sb.append("薪酬：").append(salary).append("\n");
		return sb.toString();
	}
}
