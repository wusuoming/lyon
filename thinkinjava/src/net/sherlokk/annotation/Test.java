package net.sherlokk.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.sherlokk.enumerate.OzWitch;

/**
 * @Target 被注解的目标，可以是方法、类、字段等<br>
 * @Retention 定义注解在哪一个级别可用，比如源代码、类文件，运行时<BR>
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
	/**
	 * 这个元素最常见。没有default值的元素必须被填充
	 * 
	 * @return
	 */
	String value();

	int type() default 0;

	OzWitch[] direct() default OzWitch.EAST;
}
