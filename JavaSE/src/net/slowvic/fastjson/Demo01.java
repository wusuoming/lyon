package net.slowvic.fastjson;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * fastjson 是阿里巴巴的一个开源项目
 * 提供一个将Object转换为json格式的通用解决方案
 * <p>
 * 本例简单演示转换结果，包含普通类型转换、List转换、Map转换、引用类型转换
 */
public class Demo01
{
    public static void main(String[] args)
    {
        // 测试单个类，包含了枚举
        Member m1 = new Member();
        m1.setName("slowvic");
        m1.setAge(24);
        m1.setSex(Member.Sex.MALE);
        String text = JSON.toJSONString(m1);
        System.out.println(text);

        // 测试List
        Member m2 = new Member();
        m2.setName("milky");
        m2.setAge(33);
        m2.setSex(Member.Sex.FEMALE);
        List<Member> list = new ArrayList<Member>();
        list.add(m1);
        list.add(m2);
        text = JSON.toJSONString(list);
        System.out.println(text);

        // 测试类中的list
        Team t = new Team();
        t.setMembers(list);
        text = JSON.toJSONString(t);// pretty format
        System.out.println(text);
    }
}
