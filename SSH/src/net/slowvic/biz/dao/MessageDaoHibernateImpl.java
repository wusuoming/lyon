package net.slowvic.biz.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import net.slowvic.modal.domain.Message;
import net.slowvic.util.SpringBeanUtil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class MessageDaoHibernateImpl extends HibernateDaoSupport implements
		MessageDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Message> getMessages() {
		return getHibernateTemplate().find("from Message");
	}

	public void addMessage(final Message message) {
		getHibernateTemplate().execute(new HibernateCallback<Serializable>() {
			@Override
			public Serializable doInHibernate(Session session)
					throws HibernateException, SQLException {
				return session.save(message);
			}
		});
		throw new RuntimeException("回滚");
	}

	public static void main(String[] args) {
		MessageDAO dao = SpringBeanUtil.getBean(MessageDaoHibernateImpl.class);
		Message message = new Message();
		message.setId("msg005");
		message.setUserId("001");
		message.setTitle("烟花易冷");
		message.setContent("雨轻轻草木深");
		dao.addMessage(message);
	}
}