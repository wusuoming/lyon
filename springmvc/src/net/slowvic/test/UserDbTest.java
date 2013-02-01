package net.slowvic.test;

import java.util.Date;
import java.util.List;

import net.slowvic.db.biz.UserBiz;
import net.slowvic.db.dao.impl.UserDaoImpl;
import net.slowvic.db.page.PageInfo;
import net.slowvic.domain.User;
import net.slowvic.util.AppContextUtil;

import org.noo.pagination.page.Page;
import org.noo.pagination.page.Pagination;
import org.springframework.context.ApplicationContext;

public class UserDbTest {

    public static void main(String[] args) {
        ApplicationContext ctx = AppContextUtil.getApplicationContext();
        testMultiInParams(ctx);
    }

    public static void testPagination(ApplicationContext ctx) {
        UserBiz biz = ctx.getBean(UserBiz.class);
        Page page = new Pagination();
        page.setPageSize(2);
        PageInfo<User> pageInfo = new PageInfo<User>(page);
        List<User> users = biz.getAllUsers(pageInfo, "slowvic");
        for (User user : users) {
            System.out.println(user.getUserName());
        }
    }

    public static void testMultiInParams(ApplicationContext ctx) {
        UserBiz biz = ctx.getBean(UserBiz.class);
        User user = new User();
        user.setPassword("123456");
        User dbUser = biz.getUser("slowvic%", user);
        System.out.println(dbUser.getBirthday());
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
