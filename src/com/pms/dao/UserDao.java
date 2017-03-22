package com.pms.dao;

import java.util.List;

import com.pms.form.User;

public interface UserDao {

	public String getProjectCreatorIdByCreatorName(String creatorname);

	public List<User> getUserNameByUserId(int userid);

	public User getUserName(int userid);

	public List<User> getAllUsers();

	public User getUser(int userId);

	// public List<User> getUserNameByUserId(long userid);

	// public List<User> getAllUsers();
	public void insertData(User user);

	public boolean getUser(String email, String password);

	public String getUserIdByEmail(String email);

	public List<User> getAllUser();

}
