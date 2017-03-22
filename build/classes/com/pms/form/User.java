package com.pms.form;

import java.util.List;

public class User {

	private int userid;
	private String username;
	private String useremail;
	private String userpassword;
	private int userphoneno;
	private String usergender;
	private String useraddress;
	private List<User> userList; 
	
	
	public User(){
		super();
	}
	
	public User(int userid,String username,String useremail,String userpassword,int userphoneno,String usergender,String useraddress){
		this.userid=userid;
		this.username=username;
		this.useremail=useremail;
		this.userpassword=userpassword;
		this.userphoneno=userphoneno;
		this.usergender=usergender;
		this.useraddress=useraddress;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public int getUserphoneno() {
		return userphoneno;
	}

	public void setUserphoneno(int userphoneno) {
		this.userphoneno = userphoneno;
	}

	public String getUsergender() {
		return usergender;
	}

	public void setUsergender(String usergender) {
		this.usergender = usergender;
	}

	public String getUseraddress() {
		return useraddress;
	}

	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	

}
