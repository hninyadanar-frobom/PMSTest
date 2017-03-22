package com.pms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.pms.dao.TeamDao;
import com.pms.form.Team;

public class TeamServiceImpl implements TeamService {

	@Autowired
	TeamDao teamdao;

	
	@Override
	public void saveTeam(String teamName) {
		teamdao.saveTeam(teamName);

	}


	@Override
	public List<Team> getAllTeamNames() {
		
		return teamdao.getAllTeamNames();
	}


	@Override
	public int getTeamID(String teamName){
		return teamdao.getTeamID(teamName);
	}

	
}
