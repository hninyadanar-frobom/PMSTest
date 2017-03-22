package com.pms.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.pms.form.Team;

public class TeamExtractor implements ResultSetExtractor<Team> {

	@Override
	public Team extractData(ResultSet resultSet) throws SQLException, DataAccessException {
		Team team=new Team();
		
		team.setTeamId(resultSet.getInt(1));
		team.setTeamName(resultSet.getString(2));
		return team;
	}

}
