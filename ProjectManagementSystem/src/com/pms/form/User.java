package com.pms.form;

import java.util.List;

public class User {

	private int userId;
	private String userName;
	private String userEmail;
	private String userPassword;
	private String userPhoneno;
	private String userGender;
	private String userAddress;
	private List<User> userList; 
	
	
	public User(){
		super();
	}
	
	public User(int userId,String userName,String userEmail,String userPassword,String userPhoneno,String userGender,String userAddress){
		this.userId=userId;
		this.userName=userName;
		this.userEmail=userEmail;
		this.userPassword=userPassword;
		this.userPhoneno=userPhoneno;
		this.userGender=userGender;
		this.userAddress=userAddress;
	}

	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserPhoneno() {
		return userPhoneno;
	}

	public void setUserPhoneno(String userPhoneno) {
		this.userPhoneno = userPhoneno;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String useraAddress) {
		this.userAddress = useraAddress;
	}

/*	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}*/
	
	

}
