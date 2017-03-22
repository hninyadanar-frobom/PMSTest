package com.pms.services;

import java.util.List;

import com.pms.form.Project;

public interface ProjectService {

	public void saveProject(String projectName, String startDate, String endDate, int teamId);

	public List<Project> getAllProjectName();
	
	public String getProjectIdbyName(String projectName);
	
	public void deleteProject(int projectid);

	public List<Project> getAllProjects();

}
