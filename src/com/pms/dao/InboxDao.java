package com.pms.dao;

import java.util.List;

import com.pms.form.Inbox;

public interface InboxDao {
	public void saveToInbox(int userId,int teamId);
	public List<Inbox> inboxData(int userId);
	public void access(int userId,int teamId);
	public String getDate(int userId);
	public void deny(int userId);
}
