package com.pms.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.pms.dao.MemberDao;
import com.pms.form.Member;

public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao memberDao;

	@Override
	public void saveMember(int userId) {
		memberDao.saveMember(userId);

	}

	@Override
	public List<Member> getAllMembers() {
		return memberDao.getAllMembers();
	}

	@Override
	public void saveTeamCreator(int userId,int teamId) {
		memberDao.saveTeamCreator(userId,teamId);
		
	}

	@Override
	public void accessAsMember(int userId, int teamId) {
		memberDao.accessAsMember(userId, teamId);
		
	}

	@Override
	public void denyAsMember(int userId) {
		memberDao.denyAsMember(userId);
		
	}

	@Override
	public int getMemberId(int userId) {
		
		return memberDao.getMemberId(userId);
	}

}
