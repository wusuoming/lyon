package net.slowvic.beetl;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.bee.tl.core.BeeException;
import org.bee.tl.core.GroupTemplate;
import org.bee.tl.core.Template;

public class SimpleTest {
	public static void main(String[] args) throws IOException, BeeException {
		test04();
	}

	/**
	 * 循环
	 * 
	 * @throws IOException
	 * @throws BeeException
	 */
	public static void test05() throws IOException, BeeException {
		String input = "<% for(cat in cats){ %>${cat.name}的生日是${cat.bir,dateFormat='yyyy年MM月dd日'} \n<% } %>";
		GroupTemplate group = new GroupTemplate();
		Template template = group.getStringTemplate(input);
		Cat cat1 = new Cat("撒赖", new Date(), null);
		Cat cat2 = new Cat("撒猫", new Date(), null);
		// template.set("cats", new Cat[] { cat1, cat2 });
		template.set("cats", Arrays.asList(new Cat[] { cat1, cat2 }));
		System.out.println(template.getTextAsString());
	}

	/**
	 * 引用变量
	 * 
	 * @throws IOException
	 * @throws BeeException
	 */
	public static void test04() throws IOException, BeeException {
		String input = "${cat.name!'撒赖'}的生日是${cat.bir!'1984年10月24日',dateFormat='yyyy年MM月dd日'}";
		GroupTemplate group = new GroupTemplate();
		Template template = group.getStringTemplate(input);
		// Cat cat = new Cat("撒赖", new Date(), null);
		// template.set("cat", cat);
		template.set("cat", null);
		System.out.println(template.getTextAsString());
	}

	/**
	 * 计算表达式
	 * 
	 * @throws IOException
	 * @throws BeeException
	 */
	public static void test03() throws IOException, BeeException {
		GroupTemplate group = new GroupTemplate();
		String input = "<% var i=2,j=3; %>\n" + "sum is ${i+j}";
		Template template = group.getStringTemplate(input);
		System.out.println(template.getTextAsString());
	}

	/**
	 * 渲染文件
	 * 
	 * @throws IOException
	 * @throws BeeException
	 */
	public static void test02() throws IOException, BeeException {
		String home = System.getProperty("user.dir") + File.separator
				+ "WebRoot" + File.separator + "template" + File.separator;
		GroupTemplate group = new GroupTemplate(new File(home));
		group.setCharset("UTF-8");
		group.enableOptimize();
		group.config("<!--:", "-->", "${", "}");
		// Template template = group.getFileTemplate("helloworld.txt");
		Template template = group.getFileTemplate("helloworld.html");
		template.set("allName", new String[] { "sherlokk", "milkysnowdance" });
		template.set("lyric", "向南流");
		System.out.println(template.getTextAsString());
	}

	/**
	 * 基础应用
	 * 
	 * @throws IOException
	 * @throws BeeException
	 */
	public static void test01() throws IOException, BeeException {
		GroupTemplate group = new GroupTemplate();
		group.config("<%", "%>", "${", "}");
		Template template = group.getStringTemplate("hello,${name}");
		template.set("name", "sherlokk");
		System.out.println(template.getTextAsString());
	}
}