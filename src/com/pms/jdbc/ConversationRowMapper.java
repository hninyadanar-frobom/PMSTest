package com.pms.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pms.form.Conversation;
import com.pms.jdbc.ConversationExtractor;

public class ConversationRowMapper implements RowMapper<Conversation> {

	public Conversation mapRow(ResultSet resultSet, int line) throws SQLException {

		ConversationExtractor convExtractor = new ConversationExtractor();
		return convExtractor.extractData(resultSet);
	}

}
