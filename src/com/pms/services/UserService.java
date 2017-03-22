package com.pms.services;

import java.util.List;

import com.pms.form.User;

public interface UserService {
	
	public String getProjectCreatorIdByCreatorName(String creatorname);

	public List<User> getUserNameByUserId(int userid);

	public User getUserName(int userid);
	
	public List<User> getAllUsers();
	public User getUser(int userId);
	
	
	
	public boolean getUser(String email, String password);

	public void insertData(User user);
	public String getUserIdByEmail(String email);
	
	public List<User> getAllUser();

}
