package com.pms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.pms.form.Member;
import com.pms.jdbc.MemberRowMapper;

public class MemberDaoImpl implements MemberDao {

	@Autowired
	DataSource dataSource;

	public void updateProjectMemberRole(int projectid, int userid, int teamid) {

		JdbcTemplate template = new JdbcTemplate(dataSource);
		int projectmemberrole = 1;

		String sql = "UPDATE member" + " SET projectid=?, projectmemberrole=?" + " WHERE userid=? AND teamid=?";

		template.update(sql, new Object[] { projectid, projectmemberrole, userid, teamid });
	}

	public List<Member> getUserIdByTeamId(int teamid) {

		String sql = "select * from member where teamid=?";
		List<Member> memberList = new ArrayList<Member>();

		JdbcTemplate template = new JdbcTemplate(dataSource);
		memberList = template.query(sql, new Object[] { teamid }, new MemberRowMapper());
		return memberList;

	}

	public void updateMember(int projectId, int userid, int teamid) {

		JdbcTemplate template = new JdbcTemplate(dataSource);

		String query = "update member set projectid='" + projectId + "'" + "where userid='" + userid + "'"
				+ " and teamid='" + teamid + "'";
		template.update(query);

	}

	public List<Member> getUserIdByProjectIdAndTeamId(int projectid, int teamid) {

		String sql = "select * from member where projectid=? and teamid=?";
		List<Member> memberList = new ArrayList<Member>();

		JdbcTemplate template = new JdbcTemplate(dataSource);
		memberList = template.query(sql, new Object[] { projectid, teamid }, new MemberRowMapper());
		return memberList;
	}

	public List<Member> getProjectIdByUserId(int userid) {
		String sql = "select * from member where userid=?";
		List<Member> memberList = new ArrayList<Member>();

		JdbcTemplate template = new JdbcTemplate(dataSource);
		memberList = template.query(sql, new Object[] { userid }, new MemberRowMapper());
		return memberList;
	}

	@Override
	public void saveMember(int userId) {

		/*
		 * List<Member> members = getAllMembers(); List<Integer> list=new
		 * ArrayList<Integer>(); for(int i=0;i<members.size();i++){
		 * list.add(members.get(i).getMemberId());
		 * System.out.println(members.get(i).getMemberId()); }
		 * 
		 * 
		 * for (int i=0;i<list.size();i++) {
		 * 
		 * if (userId == list.get(i)) {
		 * 
		 * 
		 * System.out.println("This user has been added to member list.");
		 * 
		 * }
		 * 
		 * 
		 * }
		 * 
		 */
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "INSERT INTO member "
				+ "(memberrole,projectid, teamid, userid, projectmemberrole) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] { 0, null, 0, userId, 0 });

	}

	@Override
	public List<Member> getAllMembers() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Member> memberList = new ArrayList<Member>();
		String sql = "select * from member";
		memberList = jdbcTemplate.query(sql, new MemberRowMapper());
		return memberList;

	}

	@Override
	public void saveTeamCreator(int userId, int teamId) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "INSERT INTO member "
				+ "(memberrole,projectid, teamid, userid, projectmemberrole) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] { 1, null, teamId, userId, 0 });

	}

	@Override
	public void accessAsMember(int userId, int teamId) {
		String sql = "Update member set teamId=? where userId=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql, new Object[] { teamId, userId });
	}

	@Override
	public void denyAsMember(int userId) {
		String sql = "delete from member where userid=" + userId;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql);

	}

	public List<Member> getUserIdByMemberId(int memberid) {
		String sql = "select * from member where memberid=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Member> memberList = jdbcTemplate.query(sql, new Object[] { memberid }, new RowMapper<Member>() {

			public Member mapRow(ResultSet rs, int rownum) throws SQLException {
				Member member = new Member();
				member.setMemberId(rs.getInt(1));
				member.setMemberRole(rs.getInt(2));
				member.setProjectId(rs.getInt(3));
				member.setTeamId(rs.getInt(4));
				member.setUserId(rs.getInt(5));
				member.setProjectMemberRole(rs.getInt(6));

				return member;
			}

		});
		return memberList;

	}
	
	@Override
	public int getMemberIdByUserId(int userId) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql="select memberId fom member where userId="+userId;
		String memberId=jdbcTemplate.queryForObject(sql, new Object[] {userId},String.class);
		return Integer.parseInt(memberId);
	}

	public List<Member> getProjectMemberRole(int projectid) {
		String sql = "select * from member where projectid=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Member> memberList = jdbcTemplate.query(sql, new Object[] { projectid }, new RowMapper<Member>() {

			public Member mapRow(ResultSet rs, int rownum) throws SQLException {
				Member member = new Member();
				member.setMemberId(rs.getInt(1));
				member.setMemberRole(rs.getInt(2));
				member.setProjectId(rs.getInt(3));
				member.setTeamId(rs.getInt(4));
				member.setUserId(rs.getInt(5));
				member.setProjectMemberRole(rs.getInt(6));

				return member;
			}

		});
		return memberList;

	}

	public List<Member> getUseridByProjIdAndMemid(int projectid, int memberid) {
		String sql = "select * from member where projectid=? and memberid=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Member> memberList = jdbcTemplate.query(sql, new Object[] { projectid, memberid },
				new RowMapper<Member>() {

					public Member mapRow(ResultSet rs, int rownum) throws SQLException {
						Member member = new Member();
						member.setMemberId(rs.getInt(1));
						member.setMemberRole(rs.getInt(2));
						member.setProjectId(rs.getInt(3));
						member.setTeamId(rs.getInt(4));
						member.setUserId(rs.getInt(5));
						member.setProjectMemberRole(rs.getInt(6));

						return member;
					}

				});
		return memberList;
	}
	
	public boolean isMember(int loginID, int teamid) {

		List<Member> memberList = new ArrayList<Member>();
		boolean isTeamMem = false;
		String sql = "select * from member where teamid= " + teamid;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		memberList = jdbcTemplate.query(sql, new MemberRowMapper());

		for (Member member : memberList) {

			if (member.getMemberId() == loginID) {
				System.out.println("is team member");
				isTeamMem = true;
			}
		}

		return isTeamMem;
	}

	public boolean isProjMember(int projid, int loginid) {

		List<Member> memberList = new ArrayList<Member>();
		boolean isProjMem = false;
		String sql = "select * from member where projectid= " + projid;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		memberList = jdbcTemplate.query(sql, new MemberRowMapper());

		for (Member member : memberList) {

			if (member.getMemberId() == loginid) {
				System.out.println("is project member");
				isProjMem = true;
			}
		}

		return isProjMem;
	}


}
