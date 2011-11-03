package net.slowvic.model.bo;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = -7098252469267264830L;

	private String id;
	private String userName;
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}