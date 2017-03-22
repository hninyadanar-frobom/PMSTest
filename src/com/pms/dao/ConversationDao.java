package com.pms.dao;

import java.util.List;
import com.pms.form.Conversation;

public interface ConversationDao {

	public void insertConv(Conversation conv);

	public List<Conversation> getConvList(int teamID);

	public List<Conversation> checkWriteConvAndDelete(int convID, String postBy, int teamid);

	public List<Conversation> getProjConvList(int projID);
	
	public List<Conversation> checkWriteAndDeleteProjConvs(int convID, String postBy, int projID);	

}
