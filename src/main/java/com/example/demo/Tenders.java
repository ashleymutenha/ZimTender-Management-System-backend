package com.example.demo;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Tenders {
	@Id
	@SequenceGenerator(
			name ="tender_sequence",
			sequenceName = "tender_sequence",
			allocationSize =1
			)
	
	private String tenderID;
	private String title;
	private String category;
	private String description;
	private String userID;
	
	
	
	public String getTenderID() {
		return tenderID;
	}
	public void setTenderID(String tenderID) {
		this.tenderID = tenderID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	

}
