package com.pms.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.pms.form.User;

public class UserExtractor implements ResultSetExtractor<User> {

	@Override
	public User extractData(ResultSet rs) throws SQLException, DataAccessException {
		User user=new User();
		user.setUserId(rs.getInt(1));
		user.setUserName(rs.getString(2));
		user.setUserEmail(rs.getString(3));
		user.setUserPassword(rs.getString(4));
		user.setUserPhoneno(rs.getString(5));
		user.setUserGender(rs.getString(6));
		user.setUserAddress(rs.getString(7));
		
		return user;
	}

}
