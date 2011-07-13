package net.slowvic.lang.io;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee
{
	private String name;
	private Date hireDay;
	private double salary;
	
	public Employee(String name,String hireDay,double salary) throws ParseException
	{
		this.name = name;
		this.salary = salary;
		this.hireDay = new SimpleDateFormat("yyyy-MM-dd").parse(hireDay);
	}
	
	public void writeData(PrintWriter out)
	{
		out.write(name);
		//流一定要关闭
		out.close();
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public Date getHireDay()
	{
		return hireDay;
	}
	public void setHireDay(Date hireDay)
	{
		this.hireDay = hireDay;
	}
	public double getSalary()
	{
		return salary;
	}
	public void setSalary(double salary)
	{
		this.salary = salary;
	}
}
