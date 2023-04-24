package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;

@Entity
@Table

public class Bid {
 
 private String tenderID;
 @Id
 private String bidID;
 private String bidderNAME;
 private String bidderLOCATION;
 private String organisationTYPE;
 private String phone;
 private float bidVALUE;
 private String bidSTATUS;
 
 
 public Bid() {
	 
 }
public String getTenderID() {
	return tenderID;
}
public void setTenderID(String tenderID) {
	this.tenderID = tenderID;
}

public String getBidID() {
	return bidID;
}
public void setBidID(String bidID) {
	this.bidID = bidID;
}


public float getBidValue() {
	return bidVALUE;
}
public void setBidValue(float bidValue) {
	this.bidVALUE = bidValue;
}
public String getBidderNAME() {
	return bidderNAME;
}
public void setBidderName(String bidderName) {
	this.bidderNAME = bidderName;
}
public String getBidderLocation() {
	return bidderLOCATION;
}
public void setBidderLocation(String bidderLocation) {
	this.bidderLOCATION = bidderLocation;
}
public String getOrganisationType() {
	return organisationTYPE;
}
public void setOrganisationType(String organisationType) {
	this.organisationTYPE = organisationType;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getBidSTATUS() {
	return bidSTATUS;
}
public void setBidSTATUS(String bidSTATUS) {
	this.bidSTATUS = bidSTATUS;
}

}
