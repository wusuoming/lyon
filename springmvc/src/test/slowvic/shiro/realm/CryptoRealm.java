package test.slowvic.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class CryptoRealm extends AuthorizingRealm {

    private PasswordService passwordService;

    public void setPasswordService(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
        PrincipalCollection paramPrincipalCollection) {
        // 授权代码
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
        AuthenticationToken token) throws AuthenticationException {
        // 认证
        String password = new String((char[]) token.getCredentials());
        System.out.println(passwordService.encryptPassword(password));
        return null;
    }

}
