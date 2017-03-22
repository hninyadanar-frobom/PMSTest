package com.pms.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pms.form.Team;

public class TeamRowMapper implements RowMapper<Team> {

	@Override
	public Team mapRow(ResultSet resultSet, int arg1) throws SQLException {
		TeamExtractor teamExtractor = new TeamExtractor();
		return teamExtractor.extractData(resultSet);
	}

}
