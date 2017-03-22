package com.pms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.pms.form.Team;
import com.pms.form.User;

public class TeamCreateDaoImpl {
	
	@Autowired
	DataSource dataSource;
	private JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	//@Override
	public void saveTeam(Team team) {
		String query = "insert into team (teamName) values(?)";
		jdbcTemplate.update(query, team.getTeamname());
		
	}
	
	
	//@Override
		public List<User> getAllUsers() {
			return jdbcTemplate.query("select * from employee", new ResultSetExtractor<List<User>>() {
				//@Override
				public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<User> list = new ArrayList<User>();
					while (rs.next()) {
						User user = new User();
						user.setUserid(rs.getInt(1));
						user.setUsername(rs.getString(2));
						user.setUseremail(rs.getString(3));
						user.setUserpassword(rs.getString(4));
						user.setUserphoneno(rs.getInt(5));
						user.setUsergender(rs.getString(6));
						user.setUseraddress(rs.getString(7));
						list.add(user);

					}

					return list;
				}
			});
		}
}
