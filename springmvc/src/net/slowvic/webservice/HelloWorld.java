package net.slowvic.webservice;

import javax.jws.WebService;

import net.slowvic.webservice.entity.User;

@WebService
// 这个注解是必须的
public interface HelloWorld {
    String sayHi(String text);

    String sayHello(User user);
}