package com.pms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pms.dao.MemberDao;

import com.pms.form.Member;

public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao memberdao;

	public void updateProjectMemberRole(int projectid, int userid, int teamid) {
		memberdao.updateProjectMemberRole(projectid, userid, teamid);
	}

	public List<Member> getUserIdByTeamId(int teamid) {
		return memberdao.getUserIdByTeamId(teamid);
	}

	public void updateMember(int projectId, int userid, int teamid) {
		memberdao.updateMember(projectId, userid, teamid);

	}

	public List<Member> getUserIdByProjectIdAndTeamId(int projectid, int teamid) {
		return memberdao.getUserIdByProjectIdAndTeamId(projectid, teamid);
	}

	public List<Member> getProjectIdByUserId(int userid) {
		return memberdao.getProjectIdByUserId(userid);
	}
//-----------------------------by swe---------------------------
	@Override
	public void saveMember(int userId) {
		memberdao.saveMember(userId);

	}

	@Override
	public List<Member> getAllMembers() {
		return memberdao.getAllMembers();
	}

	@Override
	public void saveTeamCreator(int userId, int teamId) {
		memberdao.saveTeamCreator(userId, teamId);

	}

	@Override
	public void accessAsMember(int userId, int teamId) {
		memberdao.accessAsMember(userId, teamId);

	}

	@Override
	public void denyAsMember(int userId) {
		memberdao.denyAsMember(userId);

	}

	@Override
	public int getMemberIdByUserId(int userId) {
		
		return memberdao.getMemberIdByUserId(userId);
	}
	//------------------------------------by hnin-----------------------------

	public List<Member> getUserIdByMemberId(int memberid) {
		return memberdao.getUserIdByMemberId(memberid);
	}

	public List<Member> getUseridByProjIdAndMemid(int projectid, int memberid) {
		return memberdao.getUseridByProjIdAndMemid(projectid, memberid);
	}

	public List<Member> getProjectMemberRole(int projectid) {
		return memberdao.getProjectMemberRole(projectid);
	}
	//=------------------
	public boolean isMember(int loginID, int teamid) {
		return memberdao.isMember(loginID, teamid);
	}

	public boolean isProjMember(int projID, int loginID) {
		return memberdao.isProjMember(projID, loginID);
	}

}
