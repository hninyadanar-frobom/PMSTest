package com.pms.form;

public class Team {

	private int teamid;
	private String teamname;
	
	public Team(){
		
	}
	
	public Team(int teamid,String teamname){
		this.teamid=teamid;
		this.teamname=teamname;
	}
	
	public void setTeamid(int teamid){
		this.teamid=teamid;
	}
	
	public int getTeamid(){
		return teamid;
	}
	
	public void setTeamname(String teamname){
		this.teamname=teamname;
	}
	
	public String getTeamname(){
		return teamname;
	}
}
