package net.slowvic.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringBeanUtil {
    /**
	private static ApplicationContext applicationContext = new FileSystemXmlApplicationContext(
			"WebRoot/WEB-INF/spring-conf.xml");
	**/
	
	private static ApplicationContext applicationContext = new FileSystemXmlApplicationContext(
	    "WebRoot/WEB-INF/springConfWithNoWeb.xml");

	public static <T> T getBean(Class<T> clz) {
		return applicationContext.getBean(clz);
	}
	
	public static ApplicationContext getApplicationContext(){
		return applicationContext;
	}
}