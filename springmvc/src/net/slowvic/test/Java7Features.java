package net.slowvic.test;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Java7Features {

    @Test
    public void underlineNumber() {
        // 可以使用下划线分隔数字
        int i = 1_200_3;
        assertEquals(i, 12003);
    }

    @Test
    public void autoReleaseResouce() {
        // try支持表达式了，支持自动资源管理，必须实现Closeable接口
        try (BufferedReader br = new BufferedReader(new FileReader("test.xml"))) {
            br.read();
        }
        // 一个catch，多个异常
        catch (IOException | NullPointerException e) {

        }
    }

    @Test
    public void genericType() {
        // 类型推断
        List<String> list = new ArrayList<>();
        list.add("1");
        assertEquals(list.get(0), "1");
    }

    @Test
    public void stringSwitch() {
        // switch支持String了
        switch ("1") {
            case "1":
                assertEquals(1, 1);
                break;
            default:
                assertEquals(1, 2);
                break;
        }
    }
}
