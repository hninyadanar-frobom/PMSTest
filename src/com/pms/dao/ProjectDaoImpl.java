package com.pms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.pms.form.Project;
import com.pms.jdbc.ProjectRowMapper;

public class ProjectDaoImpl implements ProjectDao {

	@Autowired
	DataSource dataSource;

	public List<Project> getAllProjectName() {
		String sql = "select * from project";
		List<Project> projectList = new ArrayList<Project>();

		JdbcTemplate template = new JdbcTemplate(dataSource);
		projectList = template.query(sql, new ProjectRowMapper());
		return projectList;
	}

	public void saveProject(String projectName, String startDate, String endDate, int teamId) {

		String sql = "INSERT INTO project "
				+ "(projectname,projectstartdate, projectenddate, teamid) VALUES (?, ?, ?,?)";

		JdbcTemplate template = new JdbcTemplate(dataSource);

		template.update(sql, new Object[] { projectName, startDate, endDate, teamId });

	}

	public String getProjectIdbyName(String projectName) {
		JdbcTemplate template = new JdbcTemplate(dataSource);
		String sql = "select projectid from project where projectname=?";
		String projectid = template.queryForObject(sql, new Object[] { projectName }, String.class);

		return projectid;

	}
	
	public void deleteProject(int projectid) {
		String sql = "delete from project where projectid=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql, new Object[] { projectid });
	}

	public List<Project> getAllProjects() {
		String sql = "select * from project";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		List<Project> projectList = jdbcTemplate.query(sql, new RowMapper<Project>() {

			public Project mapRow(ResultSet rs, int rownum) throws SQLException {
				Project project = new Project();
				project.setProjectId(rs.getInt(1));
				project.setProjectName(rs.getString(2));
				project.setProjectStartDate(rs.getString(3));
				project.setProjectEndDate(rs.getString(4));
				project.setTeamId(rs.getInt(5));

				return project;
			}

		});
		return projectList;

	}

}
