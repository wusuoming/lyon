package net.slowvic.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppContextUtil {
    public static ApplicationContext getApplicationContext() {
        return new ClassPathXmlApplicationContext("spring3-app.xml");
    }
}
