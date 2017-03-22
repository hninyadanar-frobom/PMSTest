package com.pms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pms.dao.ConversationDao;
import com.pms.form.Conversation;

public class ConversationServiceImpl implements ConversationService {

	@Autowired
	ConversationDao convdao;

	public void insertConv(Conversation conv) {
		convdao.insertConv(conv);
	}

	public List<Conversation> getConvList(int teamid) {
		return convdao.getConvList(teamid);
	}

	public List<Conversation> checkWriteConvAndDelete(int convid, String postBy, int teamid) {
		return convdao.checkWriteConvAndDelete(convid, postBy, teamid);
	}

	public List<Conversation> getProjConvList(int projID) {
		return convdao.getProjConvList(projID);
	}

	public List<Conversation> checkWriteAndDeleteProjConvs(int convid, String postBy, int projID) {
		return convdao.checkWriteAndDeleteProjConvs(convid, postBy, projID);
	}

}
