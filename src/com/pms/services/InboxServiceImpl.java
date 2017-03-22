package com.pms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.pms.dao.InboxDao;
import com.pms.form.Inbox;

public class InboxServiceImpl implements InboxService {

	@Autowired
	InboxDao inboxDao;
	
	@Override
	public void saveToInbox(int userId,int teamId) {
		inboxDao.saveToInbox(userId,teamId);
	}
	
	@Override
	public List<Inbox> inboxData(int userId)  {
		
		return inboxDao.inboxData(userId);
	}

	@Override
	public void access(int userId, int teamId) {
		inboxDao.access(userId, teamId);
		
	}

	@Override
	public String getDate(int userId)  {
		
		return inboxDao.getDate(userId);
	}

	@Override
	public void deny(int userId) {
		inboxDao.deny(userId);
		
	}

}
