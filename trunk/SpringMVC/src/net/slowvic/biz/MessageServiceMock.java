package net.slowvic.biz;

import java.util.ArrayList;
import java.util.List;

import net.slowvic.model.bo.Message;

/**
 * Mock对象，实际应该向数据库请求
 */
public class MessageServiceMock implements MessageService {

	public List<Message> getMessages() {
		List<Message> messages = new ArrayList<Message>();
		Message message = new Message();
		message.setId("song001");
		message.setUserId("JS");
		message.setTitle("杀破狼");
		message.setContent("沉睡了千年的身体");
		messages.add(message);
		return messages;
	}
}
