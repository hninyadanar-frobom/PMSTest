package com.pms.services;

import java.util.List;

import com.pms.form.Team;

public interface TeamService {

	public int getTeamIdByName(String teamname);
	public void saveTeam(String teamName);
	public List<Team> getAllTeamNames();
	public int getTeamID(String teamName);
}


