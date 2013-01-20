package net.slowvic.webservice;

import javax.jws.WebService;

import net.slowvic.webservice.entity.User;

@WebService(endpointInterface = "net.slowvic.webservice.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    public String sayHi(String text) {
        System.out.println("sayHi called");
        return "Hello," + text;
    }

    public String sayHello(User user) {
        System.out.println("sayHello called");
        return "Hello," + user.getUserName();
    }

}
