package com.pms.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.pms.form.Member;
import com.pms.jdbc.MemberRowMapper;
import com.pms.services.MemberService;
import com.pms.services.UserService;

public class MemberDaoImpl implements MemberDao {
	@Autowired
	DataSource dataSource;

	@Override
	public void saveMember(int userId) {

		/*List<Member> members = getAllMembers();	
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<members.size();i++){
			list.add(members.get(i).getMemberId());
			System.out.println(members.get(i).getMemberId());
		}
		

		for (int i=0;i<list.size();i++) {
		
			if (userId == list.get(i)) {
				
				
				System.out.println("This user has been added to member list.");
				
			}
			

		}
			
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
	public void accessAsMember(int userId,int teamId) {
		String sql="Update member set teamId=? where userId=?";
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql,new Object[]{teamId,userId});
	}

	@Override
	public void denyAsMember(int userId) {
		String sql = "delete from member where userid=" + userId;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql);

		
	}

	@Override
	public int getMemberId(int userId) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql="select memberId fom member where userId="+userId;
		String memberId=jdbcTemplate.queryForObject(sql, new Object[] {userId},String.class);
		return Integer.parseInt(memberId);
	}

}
