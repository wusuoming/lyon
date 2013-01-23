package net.slowvic.middleware.jmx;

/**
 * 定义一个MBean，必须是接口，名称以MXBean结尾。该接口内的所有方法都将暴露给JMX。
 * @author xus
 * <p>
 */
public interface HelloWorldMXBean {
    String getName();

    void setName(String name);

    void print(String name);
}
