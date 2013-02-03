package net.slowvic.test.junit;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import net.slowvic.db.biz.UserBiz;
import net.slowvic.domain.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mockito;

/**
 * 参数化测试
 * @author xus
 * <p>
 */
// 表明是参数化测试
@RunWith(Parameterized.class)
public class ParameterTest {

    private SimpleDateFormat dateFormat; // 待测试对象
    private String date; // 参数1
    private String format; // 参数2
    private String expect; // 期望结果

    public ParameterTest() {

    }

    // 必须提供这个构造方法，参数顺序跟@Parameters注解提供的数据顺序保持一致
    public ParameterTest(String date, String format, String expect) {
        this.date = date;
        this.format = format;
        this.expect = expect;
    }

    @Parameters
    @SuppressWarnings("rawtypes")
    public static Collection getParams() {
        String[][] params = new String[][] {
            { "2011-07-01 00:30:59", "yyyyMMdd", "20110701" },
            { "2011-07-01 00:30:59", "yyyy年MM月dd日", "2011年07月01日" } };
        return Arrays.asList(params);
    }

    @Test
    public void testSimpleDateFormat() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = df.parse(date);
        dateFormat = new SimpleDateFormat(format);
        String result = dateFormat.format(d);
        assertEquals(result, expect);
    }

    @Test
    public void testWithMock() {
        // mock一个对象
        UserBiz biz = Mockito.mock(UserBiz.class);
        User expectUser = new User();
        expectUser.setUserName("slowvic");
        // 设置模拟行为
        Mockito.when(biz.getUser(1)).thenReturn(expectUser);
        User resultUser = biz.getUser(1);
        assertEquals(expectUser.getUserName(), resultUser.getUserName());
    }

    public static void main(String[] args) {
        ParameterTest test = new ParameterTest();
        test.testWithMock();
    }
}
