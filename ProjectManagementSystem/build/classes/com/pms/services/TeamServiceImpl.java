package com.pms.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.pms.dao.TeamCreateDao;
import com.pms.form.Team;
import com.pms.form.User;


public class TeamServiceImpl implements TeamService{

	@Autowired
	TeamCreateDao teamCreateDao;
	

	//@Override
	public void saveTeam(Team team) {
		teamCreateDao.saveTeam(team);
	}

	//@Override
	public List<User>  getAllUsers() {
		return teamCreateDao.getAllUsers();
	}

}

