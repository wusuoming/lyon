package test.slowvic.shiro;

import static org.junit.Assert.assertEquals;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

public class LoginoutTest {

    @Test
    public void testLogin() {
        // 获取工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(
            "classpath:shiro.ini");
        // 从工厂获取SecurityManager
        SecurityManager securityManager = factory.getInstance();
        // 将SecurityManager绑定到
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new UsernamePasswordToken("zhang", "123");
        subject.login(token);
        assertEquals(true, subject.isAuthenticated());
        subject.logout();
        assertEquals(false, subject.isAuthenticated());
    }
}
