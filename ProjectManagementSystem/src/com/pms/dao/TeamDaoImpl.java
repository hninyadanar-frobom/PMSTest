
package com.pms.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.pms.form.Team;
import com.pms.jdbc.TeamRowMapper;

public class TeamDaoImpl implements TeamDao {

	@Autowired
	DataSource dataSource;

	@Override
	public void saveTeam(String teamName) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String query = "insert into team (teamname) values(?)";
		jdbcTemplate.update(query, teamName);

	}

	@Override
	public List<Team> getAllTeamNames() {
		List teamList = new ArrayList();
		String sql = "select * from team";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		teamList = jdbcTemplate.query(sql, new TeamRowMapper());
		return teamList;

	}

	@Override
	public int getTeamID(String teamName) {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select teamid from team where teamname=?";
		String teamId = jdbcTemplate.queryForObject(sql, new Object[] {teamName},String.class);
		System.out.println(teamId);
		return Integer.parseInt(teamId);
	}

}
