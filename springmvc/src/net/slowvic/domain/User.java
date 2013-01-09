package net.slowvic.domain;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

public class User implements Serializable {

    private static final long serialVersionUID = 8527132904005484115L;

    @NotBlank(message="{validate.username.notblank}")
    private String userName;

    @NotBlank
    @Size(min = 6, max = 20, message = "{validate.password.size}")
    private String password;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
