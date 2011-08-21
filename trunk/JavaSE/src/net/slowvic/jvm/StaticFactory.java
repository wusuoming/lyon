package net.slowvic.jvm;

/**
 * һ����̬�����ļ�����
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
    };// ��ֹ���ⲿ��ʼ��

    private static final Service INSTANCE = new Service();

    public static Service newInstance()
    {
        return new Service();// ÿ�η���һ����ʵ��
    }

    public static Service getInstance()
    {
        return INSTANCE;// ÿ�η���ͬ����ʵ��������ģʽ
    }
}