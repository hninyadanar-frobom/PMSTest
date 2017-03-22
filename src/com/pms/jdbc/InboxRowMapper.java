package com.pms.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pms.form.Inbox;

public class InboxRowMapper implements RowMapper<Inbox> {

	@Override
	public Inbox mapRow(ResultSet result, int arg1) throws SQLException {
		
		InboxExtrator inboxExtractor=new InboxExtrator();
		return inboxExtractor.extractData(result);
	}

}
