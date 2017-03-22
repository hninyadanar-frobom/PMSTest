package com.pms.services;

import java.util.List;

import com.pms.form.Team;
import com.pms.form.User;

public interface TeamService {
	public void saveTeam(Team team);
	public List<User> getAllUsers();
}
