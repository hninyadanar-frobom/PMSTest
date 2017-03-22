package com.pms.dao;

import java.util.List;

import com.pms.form.Member;

public interface MemberDao {

	public void updateProjectMemberRole(int projectid, int userid, int teamid);

	public List<Member> getUserIdByTeamId(int teamid);

	public void updateMember(int projectId, int userid, int teamid);

	public List<Member> getUserIdByProjectIdAndTeamId(int projectid, int teamid);

	public List<Member> getProjectIdByUserId(int userid);
	
	
//--------------------------------------------------------------by swe-----------------------------------

	public void saveMember(int userid);

	public List<Member> getAllMembers();

	public void saveTeamCreator(int userId, int teamId);

	public void accessAsMember(int userId, int teamId);

	public void denyAsMember(int userId);

	public int getMemberIdByUserId(int userId);
	
	public int getTeamCreator(int teamId);
//------------------------------------------------------by hnin ---------------------------------------	
	public boolean isMember(int LoginID, int teamid);

	public boolean isProjMember(int projID, int loginID);
//	<!--hsu myat -->
	
	public List<Member> getUserIdByMemberId(int memberid);

	public List<Member> getUseridByProjIdAndMemid(int projectid, int memberid);
	
	public List<Member> getProjectMemberRole(int projectid);

	//public List<Member> getAllMembers();

}
