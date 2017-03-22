package com.pms.dao;

import java.util.List;

import com.pms.form.Project;

public interface ProjectDao {

	public List<Project> getAllProjectName();

	public void saveProject(String projectName, String startDate, String endDate, int teamId);
	
	public String getProjectIdbyName(String projectName);
	
	public void deleteProject(int projectid);

	public List<Project> getAllProjects();

}
