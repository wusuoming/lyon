package net.slowvic.biz.dao;

import java.util.List;

import net.slowvic.modal.domain.Message;

public interface MessageDAO {
	List<Message> getMessages();
	
	void addMessage(Message message);
}
