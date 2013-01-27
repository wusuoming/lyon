package net.slowvic.middleware.cache;

import net.slowvic.util.AppContextUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class CacheTest {
    @Autowired
    private CacheExample cacheExample;

    public void getUser(String name) {
        cacheExample.createUser(name);
    }

    public static void main(String[] args) {
        ApplicationContext ctx = AppContextUtil.getApplicationContext();
        CacheTest ct = ctx.getBean("cacheTest", CacheTest.class);
        ct.getUser("slowvic");
        ct.getUser("slowvic");
    }
}
