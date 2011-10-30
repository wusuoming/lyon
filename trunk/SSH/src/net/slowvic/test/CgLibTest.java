package net.slowvic.test;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CgLibTest {
    public static void main(String[] args){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Requestable.class);
        enhancer.setCallback(new RequestCtrlCallBack());
        
        Requestable proxy = (Requestable)enhancer.create();
        proxy.request();
    }
}

class Requestable {
    void request() {
        System.out.println("相应请求");
    }
}

class RequestCtrlCallBack implements MethodInterceptor {

    @Override
    public Object intercept(Object proxy, Method method, Object[] args,
        MethodProxy proxyMethod) throws Throwable {
        if (method.getName().equals("request")) {
            return proxyMethod.invokeSuper(proxy, args);
        }
        return null;
    }
}