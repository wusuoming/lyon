package net.slowvic.web.actionform;

import org.apache.struts.action.ActionForm;

public class UserForm extends ActionForm {

	private static final long serialVersionUID = -9057424334553447659L;

	private String userName;
	private int bornYear;
	private String gender;
	private String password;
	private String email;
	private String[] favorites;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getBornYear() {
		return bornYear;
	}

	public void setBornYear(int bornYear) {
		this.bornYear = bornYear;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String[] getFavorites() {
		return favorites;
	}

	public void setFavorites(String[] favorites) {
		this.favorites = favorites;
	}

}
