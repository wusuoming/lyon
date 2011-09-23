package net.slowvic.web.form;

import org.apache.struts.action.ActionForm;

public class UserForm extends ActionForm {

	private static final long serialVersionUID = -9057424334553447659L;

	private String userName;
	private String password;
	private String email;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
