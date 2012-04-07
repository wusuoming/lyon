package net.slowvic.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterTest {
    // 被测试的对象
    private String dateReg;
    private Pattern pattern;

    // 测试数据和期望值
    private String phase;
    private boolean match;

    // 以测试数据为参数的构造方法
    public ParameterTest(String phase, boolean match) {
        this.phase = phase;
        this.match = match;
    }

    // 准备测试数据对
    @Parameters
    public static Collection<Object[]> setParameters() {
        return Arrays.asList(new Object[][] { { "2010-1-2", true },
            { "2010-10-2", true }, { "2010-123-1", false },
            { "2010-12-45", true } });
    }

    @Before
    public void init() {
        dateReg = "^\\d{4}(\\-\\d{1,2}){2}";
        pattern = Pattern.compile(dateReg);
    }

    @Test
    public void test() {
        Matcher matcher = pattern.matcher(phase);
        assertEquals(matcher.matches(), match);
    }
}
