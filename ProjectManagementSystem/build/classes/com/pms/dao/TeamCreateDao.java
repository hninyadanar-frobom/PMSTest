package com.pms.dao;

import java.util.List;

import com.pms.form.Team;
import com.pms.form.User;

public interface TeamCreateDao {

	public void saveTeam(Team team);

	public List<User> getAllUsers();

	
}
