package test.slowvic.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

public class SimpleRealm implements Realm {

    @Override
    public String getName() {
        return "simpleRealm";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token)
        throws AuthenticationException {
        String userName = (String) token.getPrincipal();
        String password = new String((char[]) (token.getCredentials()));
        if (!"zhang".equals(userName)) {
            throw new UnknownAccountException();
        }
        else if (!"123".equals(password)) {
            throw new IncorrectCredentialsException();
        }
        return new SimpleAuthenticationInfo(token, userName, getName());
    }

}
