package net.slowvic.fastjson;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * fastjson �ǰ���Ͱ͵�һ����Դ��Ŀ
 * �ṩһ����Objectת��Ϊjson��ʽ��ͨ�ý������
 * <p>
 * ��������ʾת�������������ͨ����ת����Listת����Mapת������������ת��
 */
public class Demo01
{
    public static void main(String[] args)
    {
        // ���Ե����࣬������ö��
        Member m1 = new Member();
        m1.setName("slowvic");
        m1.setAge(24);
        m1.setSex(Member.Sex.MALE);
        String text = JSON.toJSONString(m1);
        System.out.println(text);

        // ����List
        Member m2 = new Member();
        m2.setName("milky");
        m2.setAge(33);
        m2.setSex(Member.Sex.FEMALE);
        List<Member> list = new ArrayList<Member>();
        list.add(m1);
        list.add(m2);
        text = JSON.toJSONString(list);
        System.out.println(text);

        // �������е�list
        Team t = new Team();
        t.setMembers(list);
        text = JSON.toJSONString(t);// pretty format
        System.out.println(text);
    }
}
