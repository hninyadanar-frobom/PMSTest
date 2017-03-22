package com.pms.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.pms.form.Inbox;
import com.pms.form.Member;
import com.pms.form.User;
import com.pms.jdbc.InboxRowMapper;
import com.pms.jdbc.MemberRowMapper;
import com.pms.jdbc.UserRowMapper;

public class InboxDaoImpl implements InboxDao {

	@Autowired
	DataSource dataSource;

	DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	Date dateobj = new Date();
	
	@Override
	public void saveToInbox(int userId,int teamId) {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "INSERT INTO inbox " + "(inboxstatus,inboxdate,userid,teamid) VALUES (?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] { 0, df.format(dateobj), userId, teamId });
	}

	@Override
	public List<Inbox> inboxData(int userId) {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Inbox> inboxList=new ArrayList<Inbox>();
		String sql="select inboxdate from inbox where userId="+userId;
		inboxList=jdbcTemplate.query(sql, new InboxRowMapper());
		return inboxList;
		
	}

	@Override
	public void access(int userId, int teamId) {
		String sql="Update inbox set inboxstatus=?,teamId=? where userId=?";
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql,new Object[]{1,teamId,userId});
		
	}

	@Override
	public String getDate(int userId) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select inboxdate from inbox where userId=?";
		String date = jdbcTemplate.queryForObject(sql, new Object[] {userId},String.class);
		return date;
	}

	@Override
	public void deny(int userId) {
		String sql = "delete from inbox where userid=" + userId;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql);
		
	}
	
	@Override
	public int getInviteTeamId(int userId) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select teamId from inbox where userId=?";
		String teamId = jdbcTemplate.queryForObject(sql, new Object[] {userId},String.class);
		return Integer.parseInt(teamId);
	}

}

