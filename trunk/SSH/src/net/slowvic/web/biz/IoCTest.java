package net.slowvic.web.biz;

import net.slowvic.web.domainmodal.Song;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * IOC容器使用
 */
public class IoCTest {
	public static void main(String[] args) {
		//ApplicationContext context = getApplicationContextByClassPath();
		ApplicationContext context = getApplicationContextByFilePath();
		Song song = (Song) context.getBean("song");
		System.out.printf("《%s》时长：%ds，演奏者%s，%d岁", song.getName(), song
				.getSeconds(), song.getArtist().getName(), song.getArtist()
				.getAge());
	}

	public static ApplicationContext getApplicationContextByClassPath() {
		// 顾名思义，读取的是classPath(编译后的文件存放得根目录，如bin，WEB-INF/classes)下的配置
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"springConfig.xml");
		return context;
	}

	public static ApplicationContext getApplicationContextByFilePath() {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"WebRoot/WEB-INF/springConfig.xml");
		return context;
	}
}