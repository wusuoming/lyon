package net.slowvic.middleware.jmx;

import javax.management.Attribute;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;

import mx4j.tools.adaptor.http.HttpAdaptor;

public class HelloWorldAgent {
    public static void main(String[] args) throws Exception {
        MBeanServer server = MBeanServerFactory.createMBeanServer("helloAgent");
        // MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        ObjectName helloWorld = new ObjectName("helloAgent:name=helloWorld");
        HelloWorldMXBean helloWorldMBean = new HelloWorldImpl();
        server.registerMBean(helloWorldMBean, helloWorld);
        ObjectName helloAdaptor = new ObjectName(
            "HelloAgent:name=httpAdaptor");
        HttpAdaptor adapter = new HttpAdaptor();
        server.registerMBean(adapter, helloAdaptor);
        server.setAttribute(helloAdaptor, new Attribute("Port", 8082));
        server.setAttribute(helloAdaptor, new Attribute("Host", "localhost"));
        adapter.start();
    }
}
