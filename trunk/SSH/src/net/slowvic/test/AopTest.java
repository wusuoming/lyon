package net.slowvic.test;

import net.slowvic.modal.domain.Song;
import net.slowvic.util.SpringBeanUtil;

public class AopTest {

	public static void main(String[] args) {
		Song song = SpringBeanUtil.getBean(Song.class);
		song.display("中国风");
		song.showTime();
	}
}
