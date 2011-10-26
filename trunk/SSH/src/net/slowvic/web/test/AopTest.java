package net.slowvic.web.test;

import net.slowvic.web.domainmodal.Song;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class AopTest {
    private static BeanFactory getBeanFactory() {
        return new FileSystemXmlApplicationContext(
            "WebRoot/WEB-INF/spring-conf.xml");
    }

    public static void main(String[] args) {
        BeanFactory beanFactory = getBeanFactory();
        Song song = beanFactory.getBean(Song.class);
        song.display("中国风");
    }
}
