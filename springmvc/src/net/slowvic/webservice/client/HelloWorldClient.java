package net.slowvic.webservice.client;

import javax.jws.WebService;

import net.slowvic.webservice.entity.User;

/**
 * 通过指定endpointInterface，模拟服务端接口，从而避免依赖服务端代码
 * @author xus
 * <p>
 */
@WebService(endpointInterface = "net.slowvic.webservice.HelloWorld")
public interface HelloWorldClient {
    String sayHi(String text);

    String sayHello(User user);
}
