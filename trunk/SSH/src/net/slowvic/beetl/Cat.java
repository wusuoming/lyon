package net.slowvic.beetl;

import java.util.Date;

public class Cat {
	private String name;
	private Date bir;
	private Cat parent;

	public Cat(String name, Date bir, Cat parent) {
		this.name = name;
		this.bir = bir;
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBir() {
		return bir;
	}

	public void setBir(Date bir) {
		this.bir = bir;
	}

	public Cat getParent() {
		return parent;
	}

	public void setParent(Cat parent) {
		this.parent = parent;
	}
}