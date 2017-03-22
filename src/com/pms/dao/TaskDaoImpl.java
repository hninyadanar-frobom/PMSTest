package com.pms.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import java.sql.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.pms.dao.TaskDao;
import com.pms.form.Task;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

public class TaskDaoImpl implements TaskDao {

	@Autowired
	DataSource dataSource;

	public List<Task> getTaskId(int memberid) {
		String sql = "select * from task where memberid=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Task> taskList = jdbcTemplate.query(sql, new Object[] { memberid }, new RowMapper<Task>() {

			public Task mapRow(ResultSet rs, int rownum) throws SQLException {
				Task task = new Task();
				task.setTaskid(rs.getInt("taskid"));
				task.setTaskname(rs.getString("taskname"));
				task.setSectionname(rs.getString("sectionname"));
				task.setTaskstatus(rs.getInt("taskstatus"));
				task.setTaskstartdate(rs.getString("taskstartdate"));
				task.setTaskenddate(rs.getString("taskenddate"));
				task.setProjectid(rs.getInt("projectid"));
				task.setMemberid(rs.getInt("memberid"));

				return task;
			}

		});
		return taskList;

	}

	public List<Task> getTaskId(int projectid, int memberid) {
		String sql = "select * from task where projectid=? and memberid=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Task> taskList = jdbcTemplate.query(sql, new Object[] { projectid, memberid }, new RowMapper<Task>() {

			public Task mapRow(ResultSet rs, int rownum) throws SQLException {
				Task task = new Task();
				task.setTaskid(rs.getInt("taskid"));
				task.setTaskname(rs.getString("taskname"));
				task.setSectionname(rs.getString("sectionname"));
				task.setTaskstatus(rs.getInt("taskstatus"));
				task.setTaskstartdate(rs.getString("taskstartdate"));
				task.setTaskenddate(rs.getString("taskenddate"));
				task.setProjectid(rs.getInt("projectid"));
				task.setMemberid(rs.getInt("memberid"));

				return task;
			}

		});
		return taskList;

	}

	public void UpdateTaskStatus(int taskid) {
		String sql = "update task set taskstatus=? where taskid=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql, new Object[] { 1, taskid });
	}

	public List<Task> getMemberId(int taskid) {
		String sql = "select memberid from task where taskid=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Task> taskList = jdbcTemplate.query(sql, new Object[] { taskid }, new RowMapper<Task>() {

			public Task mapRow(ResultSet rs, int rownum) throws SQLException {
				Task task = new Task();
				task.setTaskid(rs.getInt("taskid"));
				task.setTaskname(rs.getString("taskname"));
				task.setSectionname(rs.getString("sectionname"));
				task.setTaskstatus(rs.getInt("taskstatus"));
				task.setTaskstartdate(rs.getString("taskstartdate"));
				task.setTaskenddate(rs.getString("taskenddate"));
				task.setProjectid(rs.getInt("projectid"));
				task.setMemberid(rs.getInt("memberid"));

				return task;
			}

		});
		return taskList;

	}

	public List<Task> getAllTasks() {
		// TODO Auto-generated method stub
		String sql = "select * from task where taskstatus=0";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		List<Task> taskList = jdbcTemplate.query(sql, new RowMapper<Task>() {

			public Task mapRow(ResultSet rs, int rownum) throws SQLException {
				Task task = new Task();
				task.setTaskid(rs.getInt("taskid"));
				task.setTaskname(rs.getString("taskname"));
				task.setSectionname(rs.getString("sectionname"));
				task.setTaskstatus(rs.getInt("taskstatus"));
				task.setTaskstartdate(rs.getString("taskstartdate"));
				task.setTaskenddate(rs.getString("taskenddate"));
				task.setProjectid(rs.getInt("projectid"));
				task.setMemberid(rs.getInt("memberid"));

				return task;
			}

		});
		return taskList;

	}

	public List<Task> getAllTasks1() {
		// TODO Auto-generated method stub
		String sql = "select * from task where taskstatus=1";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		List<Task> taskList = jdbcTemplate.query(sql, new RowMapper<Task>() {

			public Task mapRow(ResultSet rs, int rownum) throws SQLException {
				Task task = new Task();
				task.setTaskid(rs.getInt("taskid"));
				task.setTaskname(rs.getString("taskname"));
				task.setSectionname(rs.getString("sectionname"));
				task.setTaskstatus(rs.getInt("taskstatus"));
				task.setTaskstartdate(rs.getString("taskstartdate"));
				task.setTaskenddate(rs.getString("taskenddate"));
				task.setProjectid(rs.getInt("projectid"));
				task.setMemberid(rs.getInt("memberid"));

				return task;
			}

		});
		return taskList;

	}

	@Override
	public String getTaskName(int taskid) {
		String sql = "select taskname from task where taskid=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String taskName = jdbcTemplate.queryForObject(sql, new Object[] { taskid }, String.class);
		return taskName;
	}

}
