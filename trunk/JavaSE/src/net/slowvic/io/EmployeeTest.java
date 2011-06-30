package net.slowvic.io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;

public class EmployeeTest
{
	public static void main(String[] args) throws ParseException, FileNotFoundException
	{
		Employee e = new Employee("slowvic","2011-3-7",5000);
		PrintWriter out = new PrintWriter("D:/employee.txt");
		e.writeData(out);
	}
}
