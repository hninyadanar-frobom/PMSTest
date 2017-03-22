package com.pms.form;

public class Inbox {
	private int inboxId;
	private int inboxStatus;
	private String inboxDate;
	private int userId;
	private int teamId;
	
	public Inbox(){
		
	}
	
	public Inbox(int inboxId,int inboxStatus,String inboxDate,int userId,int teamId){
		this.inboxId=inboxId;
		this.inboxStatus=inboxStatus;
		this.inboxDate=inboxDate;
		this.userId=userId;
		this.teamId=teamId;
	}

	public int getInboxId() {
		return inboxId;
	}

	public void setInboxId(int inboxId) {
		this.inboxId = inboxId;
	}

	public int getInboxStatus() {
		return inboxStatus;
	}

	public void setInboxStatus(int inboxStatus) {
		this.inboxStatus = inboxStatus;
	}

	public String getInboxDate() {
		return inboxDate;
	}

	public void setInboxDate(String inboxDate) {
		this.inboxDate = inboxDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	
	
}
