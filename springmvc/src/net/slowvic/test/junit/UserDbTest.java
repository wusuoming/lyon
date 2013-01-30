package net.slowvic.test.junit;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import net.slowvic.db.biz.UserBiz;
import net.slowvic.domain.User;
import net.slowvic.util.AppContextUtil;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

public class UserDbTest {
    private static ApplicationContext ctx;
    private static UserBiz biz;

    private User user;

    @BeforeClass
    /**
     * @BeforeClass、@AfterClass必须是public static void，且无入参
     */
    public static void initContext() {
        ctx = AppContextUtil.getApplicationContext();
        biz = ctx.getBean(UserBiz.class);
    }

    @Before
    /**
     * @Before、@After必须是public void，且无入参
     */
    public void createUser() {
        user = new User();
        user.setUserName("slowvic");
        user.setPassword("123456");
        user.setBirthday(new Date());
    }

    @Test
    public void testUserBiz() {
        User dbUser = biz.getUser(1);
        assertEquals(dbUser.getUserName(), user.getUserName());
    }

    @Test(expected = RuntimeException.class)
    public void testUserBizWithException() {
        biz.addUser(user);
    }
}
