package net.slowvic.biz.dao;

import java.util.List;

import net.slowvic.modal.domain.Message;
import net.slowvic.modal.domain.MessageRowMapper;
import net.slowvic.util.SpringBeanUtil;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class MessageDaoJdbcImpl extends JdbcDaoSupport implements MessageDAO {

	@Override
	public List<Message> getMessages() {
		return getJdbcTemplate().query("select * from t_message",
				new MessageRowMapper());
	}

	public static void main(String[] args) {
		MessageDAO dao = SpringBeanUtil.getBean(MessageDaoJdbcImpl.class);
		List<Message> messages = dao.getMessages();
		for (Message message : messages) {
			System.out.println(message.getId() + "," + message.getTitle() + ","
					+ message.getContent());
		}
	}

	@Override
	public void addMessage(Message message) {
		// TODO Auto-generated method stub
	}
}
