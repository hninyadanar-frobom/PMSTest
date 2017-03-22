package com.pms.form;

public class Task {
	private int taskid;

	private String taskname;

	private String sectionname;

	private int taskstatus;

	private String taskstartdate;

	private String taskenddate;

	private int projectid;

	private int memberid;

	public Task() {
	}

	public Task(int taskid, String taskname, String sectionname, int taskstatus, String taskstartdate,
			String taskenddate, int projectid, int memberid) {
		this.taskid = taskid;
		this.taskname = taskname;
		this.sectionname = sectionname;
		this.taskstatus = taskstatus;
		this.taskstartdate = taskstartdate;
		this.taskenddate = taskenddate;
		this.projectid = projectid;
		this.memberid = memberid;
	}

	public int getTaskid() {
		return taskid;
	}

	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}

	public String getTaskname() {
		return taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public String getSectionname() {
		return sectionname;
	}

	public void setSectionname(String sectionname) {
		this.sectionname = sectionname;
	}

	public int getTaskstatus() {
		return taskstatus;
	}

	public void setTaskstatus(int taskstatus) {
		this.taskstatus = taskstatus;
	}

	public String getTaskstartdate() {
		return taskstartdate;
	}

	public void setTaskstartdate(String taskstartdate) {
		this.taskstartdate = taskstartdate;
	}

	public String getTaskenddate() {
		return taskenddate;
	}

	public void setTaskenddate(String taskenddate) {
		this.taskenddate = taskenddate;
	}

	public int getProjectid() {
		return projectid;
	}

	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}

	public int getMemberid() {
		return memberid;
	}

	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}

}
