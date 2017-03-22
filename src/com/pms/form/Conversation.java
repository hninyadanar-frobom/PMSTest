package com.pms.form;

public class Conversation {

	private int conversationid;

	private String message;

	private String postBy;

	private int teamid;

	private int projectid;

	private String convPostDate;

	public Conversation() {

	}

	public Conversation(int conversationid, String message, String postBy, int teamid, int projectid,
			String convPostDate) {

		this.conversationid = conversationid;
		this.message = message;
		this.postBy = postBy;
		this.teamid = teamid;
		this.projectid = projectid;
		this.convPostDate = convPostDate;
	}

	public int getConversationid() {
		return conversationid;
	}

	public void setConversationid(int conversationid) {
		this.conversationid = conversationid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPostBy() {
		return postBy;
	}

	public void setPostBy(String postBy) {
		this.postBy = postBy;
	}

	public int getTeamid() {
		return teamid;
	}

	public void setTeamid(int teamid) {
		this.teamid = teamid;
	}

	public int getProjectid() {
		return projectid;
	}

	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}

	public String getConvPostDate() {
		return convPostDate;
	}

	public void setConvPostDate(String convPostDate) {
		this.convPostDate = convPostDate;
	}

}