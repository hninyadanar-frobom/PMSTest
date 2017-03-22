package com.pms.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.pms.form.Conversation;

public class ConversationExtractor implements ResultSetExtractor<Conversation> {

	public Conversation extractData(ResultSet resultSet) throws SQLException, DataAccessException {

		Conversation conv = new Conversation();
		conv.setConversationid(resultSet.getInt(1));
		conv.setMessage(resultSet.getString(2));
		conv.setPostBy(resultSet.getString(3));
		conv.setTeamid(resultSet.getInt(4));
		conv.setProjectid(resultSet.getInt(5));
		conv.setConvPostDate(resultSet.getString(6));
		return conv;
	}

}
