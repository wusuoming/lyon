package net.slowvic.test.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

// 表明该类是一个套件
@RunWith(Suite.class)
// 要执行的测试类或者测试套件
@SuiteClasses({ ParameterTest.class })
/**
 * 测试套件
 * @author xus
 * <p>
 */
public class TestSuite {

}
