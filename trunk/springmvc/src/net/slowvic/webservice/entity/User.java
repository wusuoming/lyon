package net.slowvic.webservice.entity;

import net.slowvic.domain.BaseEntity;

public class User extends BaseEntity {

    private static final long serialVersionUID = 4569160956897763669L;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
