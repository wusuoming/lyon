package net.slowvic.middleware.jmx;

public class HelloWorldImpl implements HelloWorldMXBean {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void print(String name) {
        System.out.println(name);
    }

}
