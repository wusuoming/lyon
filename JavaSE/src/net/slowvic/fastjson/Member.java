package net.slowvic.fastjson;

/**
 * 一个简单的JavaBean，包含String、int和enum实例域
 */
public class Member
{
    private String name;
    private int age;
    private Sex sex;

    public static enum Sex
    {
        MALE, FEMALE;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setSex(Sex sex)
    {
        this.sex = sex;
    }

    public Sex getSex()
    {
        return sex;
    }
}
