package net.slowvic.modal.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MessageRowMapper implements RowMapper<Message>{

	@Override
	public Message mapRow(ResultSet resultSet, int cloNum)
			throws SQLException {
		Message message = new Message();
		message.setId(resultSet.getString(1));
		message.setUserId(resultSet.getString(2));
		message.setTitle(resultSet.getString(3));
		message.setContent(resultSet.getString(4));
		return message;
	}
}
