package com.pms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pms.dao.UserDao;
import com.pms.form.User;

public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userdao;

	public String getProjectCreatorIdByCreatorName(String creatorname) {
		return userdao.getProjectCreatorIdByCreatorName(creatorname);
	}

	public List<User> getUserNameByUserId(int userid) {
		return userdao.getUserNameByUserId(userid);
	}

	public User getUserName(int userid) {
		return userdao.getUserName(userid);
	}
	public List<User> getAllUsers() {
		return userdao.getAllUsers();
	}

	@Override
	public User getUser(int userId) {
		
		return userdao.getUser(userId);
	}
	public boolean getUser(String email, String password) {
		return userdao.getUser(email, password);
	}

	@Override
	public void insertData(User user) {
		userdao.insertData(user);
	}

	public String getUserIdByEmail(String email) {
		return userdao.getUserIdByEmail(email);

	}

	public List<User> getAllUser() {
		return userdao.getAllUser();
	}

}
