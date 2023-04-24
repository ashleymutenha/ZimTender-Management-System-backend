package com.example.demo;

public class UserLoginResponse {
	
	
	private String userID;
	private String username;
	private String organisation;
	private String category;
	
	

	public UserLoginResponse(String userID ,String username , String organisation,String category) {
		
		this.setUserID(userID);
		this.setUsername(username);
		this.setOrganisation(organisation);
		this.category = category;
	}
	
	
	
	public String getUserID() {
		return userID;
	}



	public void setUserID(String userID) {
		this.userID = userID;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getOrganisation() {
		return organisation;
	}



	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}}


	
