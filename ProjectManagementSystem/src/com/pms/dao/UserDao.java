package com.pms.dao;

import java.util.List;
import com.pms.form.User;

public interface UserDao {
	public List<User> getAllUsers();
	public User getUser(int userId);
	
}
