package com.pms.services;

import java.util.List;

import javax.sql.DataSource;

import com.pms.form.Conversation;

public interface ConversationService {
	public void insertConv(Conversation conv);

	public List<Conversation> getConvList(int teamID);

	public List<Conversation> checkWriteConvAndDelete(int convid, String postBy, int teamid);

	public List<Conversation> getProjConvList(int projID);
	
	public List<Conversation> checkWriteAndDeleteProjConvs(int convid, String postBy, int projID);
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * public boolean isMember(int loginId, int teamid);
	 * 
	 */

	/* public String findOutName(int loginId); */

}
