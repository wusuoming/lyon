package net.slowvic.test;

import net.slowvic.modal.domain.User;
import net.slowvic.util.SpringBeanUtil;

public class IocTest {
	public static void main(String[] args){
		User user = SpringBeanUtil.getApplicationContext().getBean("slowUser", User.class);
		System.out.println(user.getAddress());
	}
}
