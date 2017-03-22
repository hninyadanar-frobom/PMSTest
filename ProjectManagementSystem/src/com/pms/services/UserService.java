package com.pms.services;

import java.util.List;
import com.pms.form.User;

public interface UserService {
	public List<User> getAllUsers();
	public User getUser(int userId);
}
