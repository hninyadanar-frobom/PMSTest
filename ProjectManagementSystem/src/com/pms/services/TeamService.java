package com.pms.services;

import java.util.List;

import com.pms.form.Team;

public interface TeamService {
	public void saveTeam(String teamName);
	public List<Team> getAllTeamNames();
	public int getTeamID(String teamName);
}
