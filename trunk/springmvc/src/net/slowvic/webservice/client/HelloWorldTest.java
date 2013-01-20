package net.slowvic.webservice.client;

import net.slowvic.domain.User;
import net.slowvic.util.AppContextUtil;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.context.ApplicationContext;

public class HelloWorldTest {

    public static void main(String[] args) throws Exception {
        test02();
    }

    public static void test01() {
        ApplicationContext ctx = AppContextUtil.getApplicationContext();
        HelloWorldClient client = ctx.getBean("helloClient",
            HelloWorldClient.class);
        System.out.println(client.sayHi("World!"));
        RestHelloWorldClient client1 = ctx.getBean("helloWorldClient",
            RestHelloWorldClient.class);
        System.out.println(client1.sayHi("China!"));
    }

    public static void test02() throws Exception {
        JaxWsDynamicClientFactory clientFactory = JaxWsDynamicClientFactory
            .newInstance();
        Client client2 = clientFactory
            .createClient("http://localhost:8080/spring3/cxf/hello?wsdl");
        User user = new User();
        user.setUserName("塘檐");
        Object[] result = client2.invoke("sayHello", user);
        System.out.println(result[0]);
    }

}
