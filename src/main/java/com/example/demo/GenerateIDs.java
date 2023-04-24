package com.example.demo;

import java.util.Optional;

public class GenerateIDs {
	
	public final UserRepository userRepo;
	public final BidRepository bidRepo;
	public final TenderRepository tenderRepo;
	
	public final NotificationsRepo notifyRepo;
	public String idElement;
	
	public GenerateIDs(UserRepository userRepo,BidRepository bidRepo,
			TenderRepository tenderRepo,
			NotificationsRepo notifyRepo,String idElement) {
		
		this.userRepo = userRepo;
		this.tenderRepo = tenderRepo;
		this.bidRepo = bidRepo;
		this.notifyRepo =notifyRepo;
		this.idElement = idElement;
	}
	
	public String generateIDNo() {
		String id =null;
		String idPrefix =null;
		Long idNo =null;
		
		
		
		if(idElement =="userIDGeneration") {
			idNo = userRepo.count()+1;
			idPrefix = "USR";
			id = idPrefix+idNo;
			
		}
		
		if(idElement =="notificationIDGeneration") {
			idNo = notifyRepo.count()+1;
			idPrefix = "NTF";
			id = idPrefix+idNo;
			
		}
		
		if(idElement =="tenderIDGeneration") {
			idNo = tenderRepo.count()+1;
			idPrefix ="TND";
			id = idPrefix+idNo;
		}
		
		if(idElement =="bidIDGeneration") {
			idNo = bidRepo.count()+1;
			idPrefix ="BID";
			id = idPrefix+idNo;
			
		}
		
		if(validateIDNo(id) ==false) {
			return id;
		}
		
		else {
			
			id = iterateIDNo(idPrefix,idNo);
			return id;
			
		}
		
	}
	
	
	
	public boolean validateIDNo(String id) {
		
		Optional<?> objectByID =null;
		
		if(idElement == "userIDGeneration") {
		Optional<Users> userID = userRepo.getUserByUserID(id);
		objectByID =userID;
		}
		
		if(idElement =="tenderIDGeneration") {
			Optional<Tenders> tenderID = tenderRepo.getTendersByTenderID(id);
			
		objectByID =tenderID;
		
		}
			
		if(idElement =="bidIDGeneration") {
			Optional<Bid> bidID = bidRepo.getBidByBidID(id);
			objectByID =bidID;
		}
		
		if(idElement =="notificationIDGeneration") {
			Optional<Notifications> notiID = notifyRepo.getNotificationsByNotificationID(id);
			objectByID =notiID;
		}
		
		
		if(objectByID.isPresent()) {
			return true;
		}
		
		else {
			return false;
		}
		
		
		
	}
	
	public String iterateIDNo(String idPrefix, Long idNo) {
		String id =idPrefix+idNo;
		while(validateIDNo(id)!=false) {
			idNo+=1;
			id = idPrefix +idNo;
		}
		
		return id;
		
		
	}

}
