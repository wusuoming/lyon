package net.slowvic.jvm;

/**
 * 一个静态工厂的简单例子
 */
public class StaticFactory
{
    public static void main(String[] args)
    {
        Service service = Service.newInstance();
        System.out.println(service);
    }
}

class Service
{
    private Service() {
    };// 禁止从外部初始化

    private static final Service INSTANCE = new Service();

    public static Service newInstance()
    {
        return new Service();// 每次返回一个新实例
    }

    public static Service getInstance()
    {
        return INSTANCE;// 每次返回同样的实例，单例模式
    }
}