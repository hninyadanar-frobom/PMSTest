package com.pms.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.pms.form.Conversation;
import com.pms.jdbc.ConversationRowMapper;

public class ConversationDaoImpl implements ConversationDao {

	@Autowired
	DataSource dataSource;

	public void insertConv(Conversation conv) {

		String sql = "INSERT INTO conversation " + "(message, postBy, teamid, projectid, convPostDate) "
				+ "VALUES (?, ?, ?, ?, ?)";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(sql, new Object[] { conv.getMessage(), "ddd", 1, 1, conv.getConvPostDate() });
	}

	public List<Conversation> getConvList(int teamID) {

		List<Conversation> convList = new ArrayList<Conversation>();

		String sql = "select * from conversation where teamid= " + teamID+" order by conversationid desc";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		convList = jdbcTemplate.query(sql, new ConversationRowMapper());
		return convList;
	}

	public void deleteConv(int convID) {

		String sql = "delete from conversation where conversationid= " + convID;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql);
	}

	public List<Conversation> checkWriteConvAndDelete(int conversationid, String postBy, int teamid) {

		List<Conversation> convList = new ArrayList<Conversation>();
		String sql = "select * from conversation where conversationid=? and postBy=? and teamid=? order by conversationid desc";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		convList = jdbcTemplate.query(sql, new Object[] { conversationid, postBy, teamid },
				new ConversationRowMapper());

		if (!convList.isEmpty()) {
			deleteConv(conversationid);
			convList = getConvList(teamid);
		} else {
			convList = getConvList(teamid);
		}
		return convList;
	}

	public List<Conversation> getProjConvList(int projID) {

		List<Conversation> convList = new ArrayList<Conversation>();

		String sql = "select * from conversation where projectid= " + projID+" order by conversationid desc";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		convList = jdbcTemplate.query(sql, new ConversationRowMapper());
		return convList;
	}

	public List<Conversation> checkWriteAndDeleteProjConvs(int conversationid, String postBy, int projID) {

		List<Conversation> convList = new ArrayList<Conversation>();
		String sql = "select * from conversation where conversationid=? and postBy=? and projectid=? order by conversationid desc";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		convList = jdbcTemplate.query(sql, new Object[] { conversationid, postBy, projID },
				new ConversationRowMapper());

		if (!convList.isEmpty()){
			deleteConv(conversationid);
			convList = getConvList(projID);
		} else {
			convList = getConvList(projID);
		}
		return convList;
	}

}