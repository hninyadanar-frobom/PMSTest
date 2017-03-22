package com.pms.dao;

import java.util.List;

import com.pms.form.Team;

public interface TeamDao {

	public int getTeamIdByName(String teamname);
	public void saveTeam(String teamName);

	public List<Team> getAllTeamNames();
	
	public int getTeamID(String teamName);
	
	public String getTeamName(int teamId);

}
