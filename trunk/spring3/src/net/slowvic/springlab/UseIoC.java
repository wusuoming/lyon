package net.slowvic.springlab;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class UseIoC {
	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource(
				"applicationContext.xml"));
		Song song = (Song) factory.getBean("song");
		System.out.printf("¡¶%s¡·Ê±³¤£º%ds£¬ÑÝ×àÕß%s£¬%dËê", song.getName(), song
				.getSeconds(), song.getArtist().getName(), song.getArtist()
				.getAge());
	}
}
