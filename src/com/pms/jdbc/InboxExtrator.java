package com.pms.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.pms.form.Inbox;

public class InboxExtrator implements ResultSetExtractor<Inbox> {

	@Override
	public Inbox extractData(ResultSet result) throws SQLException, DataAccessException {
		Inbox inbox=new Inbox();
		inbox.setInboxId(result.getInt(1));
		inbox.setInboxStatus(result.getInt(1));
		inbox.setInboxDate(result.getString(3));
		inbox.setUserId(result.getInt(4));
		inbox.setTeamId(result.getInt(5));
		return inbox;
	}

}
