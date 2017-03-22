package com.pms.services;

import java.util.List;
import com.pms.form.Member;

public interface MemberService {
	public void saveMember(int userId);
	public List<Member> getAllMembers();
	public void saveTeamCreator(int userId,int teamId);
	public void accessAsMember(int userId,int teamId);
	public void denyAsMember(int userId);
	public int getMemberId(int userId); 
}
