package com.pms.dao;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.pms.form.User;
import com.pms.jdbc.UserRowMapper;

public class UserDaoImpl implements UserDao {

	@Autowired
	DataSource dataSource;

	@Override
	public List<User> getAllUsers() {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<User> userList = new ArrayList<User>();
		String sql = "select * from user";
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		return userList;
	}
	
	@Override
	public User getUser(int userId) {
		List<User> userList = new ArrayList<User>();
		String sql = "select * from user where userid= " + userId;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		return userList.get(0);
	}
	
	
}

