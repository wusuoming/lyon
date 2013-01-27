package net.slowvic.test;

import java.util.Date;

import net.slowvic.db.biz.UserBiz;
import net.slowvic.db.dao.impl.UserDaoImpl;
import net.slowvic.domain.User;
import net.slowvic.util.AppContextUtil;

import org.springframework.context.ApplicationContext;

public class UserDbTest {

    public static void main(String[] args) {
        ApplicationContext ctx = AppContextUtil.getApplicationContext();
        testUserBiz(ctx);
    }

    public static void testUserDaoImpl(ApplicationContext ctx) {
        UserDaoImpl daoImpl = ctx.getBean(UserDaoImpl.class);
        User user = daoImpl.getUser(1);
        System.out.println(user.getUserName());
    }

    public static void testUserBiz(ApplicationContext ctx) {
        UserBiz biz = ctx.getBean(UserBiz.class);
        User user = new User();
        user.setUserName("slowvic");
        user.setPassword("123456");
        user.setBirthday(new Date());
        biz.addUser(user);
        // User userFromDb = biz.getUser(1);
        // System.out.println(userFromDb.getUserName());
    }

}
