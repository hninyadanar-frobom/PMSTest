package com.pms.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.pms.dao.UserDao;
import com.pms.form.User;

public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userdao;

	public List<User> getAllUsers() {
		return userdao.getAllUsers();
	}

	@Override
	public User getUser(int userId) {
		
		return userdao.getUser(userId);
	}

	

}
