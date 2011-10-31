package net.slowvic.test;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.slowvic.modal.domain.Song;
import net.slowvic.util.SpringBeanUtil;

import org.springframework.jdbc.core.JdbcTemplate;

public class AopTest {

    public static void main(String[] args) {
        aop();
    }

	public static void useJdbcTemplate() {
		JdbcTemplate jdbcTemplate = SpringBeanUtil.getBean(JdbcTemplate.class);
        List<Map<String, Object>> resultList = jdbcTemplate
            .queryForList("select * from t_message");
        for (Map<String, Object> resultMap : resultList) {
            for (Entry<String, Object> entry : resultMap.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
	}

    public static void aop() {
        Song song = SpringBeanUtil.getBean(Song.class);
        System.out.println(song.display("中国风"));
        song.showTime();
    }

}