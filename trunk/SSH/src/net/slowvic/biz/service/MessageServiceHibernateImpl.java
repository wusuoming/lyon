package net.slowvic.biz.service;

import java.util.List;

import net.slowvic.biz.dao.MessageDAO;
import net.slowvic.modal.domain.Message;
import net.slowvic.util.SpringBeanUtil;

public class MessageServiceHibernateImpl implements MessageService {

	private MessageDAO dao;

	public void setDao(MessageDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<Message> getMessages() {
		return dao.getMessages();
	}

	public static void main(String[] args) {
		MessageService service = SpringBeanUtil
				.getBean(MessageServiceHibernateImpl.class);
		List<Message> messages = service.getMessages();
		for (Message message : messages) {
			System.out.println(message.getId() + "," + message.getTitle() + ","
					+ message.getContent());
		}
	}
}
