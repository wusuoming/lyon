package net.slowvic.beanutils;

import java.lang.reflect.InvocationTargetException;

import net.slowvic.fastjson.Member;

import org.apache.commons.beanutils.BeanUtils;

/**
 * BeanUtils需要两个jar包，commons-beanutils-1.8.3.jar和commons-logging-1.0.3.jar
 * 
 */
public class BeanUtilTest {
	public static void main(String[] args) throws IllegalAccessException,
			InvocationTargetException {
		Member member = new Member();
		BeanUtils.setProperty(member, "name", "haha");
		System.out.println(member.getName());
	}
}
