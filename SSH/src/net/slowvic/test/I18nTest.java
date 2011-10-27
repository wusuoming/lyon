package net.slowvic.test;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import net.slowvic.util.SpringBeanUtil;

import org.springframework.context.ApplicationContext;

public class I18nTest {
	public static void main(String[] args) {
		ResourceBundle resouceBundle = ResourceBundle.getBundle(
				"MessageResources", Locale.ENGLISH);
		System.out.println(resouceBundle.getString("reg.success"));
		System.out.println(MessageFormat.format(
				resouceBundle.getString("reg.failure"), "slowvic"));
		ApplicationContext ctx = SpringBeanUtil.getApplicationContext();
		System.out.println(ctx.getMessage("reg.success", null, Locale.ENGLISH));
		System.out.println(ctx.getMessage("reg.failure",
				new String[] { "slowvic" }, Locale.ENGLISH));
	}
}
