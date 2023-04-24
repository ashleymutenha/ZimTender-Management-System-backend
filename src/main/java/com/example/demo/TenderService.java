package com.example.demo;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class TenderService {
	
	
	public final TenderRepository tenderRepo;
	public final UserRepository userRepo;
	
	public final BidRepository bidRepo;
	
	public final Users user;
	public final Notifications notificationz;
	public final NotificationsRepo notifyRepo;
	

	
	
	
	
	public TenderService(TenderRepository tenderRepo ,UserRepository userRepo, 
			Users user, BidRepository bidRepo, NotificationsRepo notifyRepo ,
			Notifications notificationz
			
			) {
		this.tenderRepo =tenderRepo;
		this.userRepo = userRepo;
		this.user = user;
		this.bidRepo = bidRepo;
		this.notifyRepo = notifyRepo;
		this.notificationz = notificationz;
		
		
		
		
	}
	
	public  GenerateIDs idGenerator(String idGenerationLevel) {
	    GenerateIDs idgenerator = 
	    		new GenerateIDs(userRepo,bidRepo,tenderRepo,notifyRepo,idGenerationLevel);
        return idgenerator;
	}
	
	
	public List<Tenders> getTenders() {
		
		
		return tenderRepo.findAll();
	}


	public Object login(LoginUser user) {
		Object __response = new UserResponse(0,"wrong password");
		Optional<Users> userByname = userRepo.getUserByUsername(user.getUsername());
		
	if(userByname.isPresent()) {
		
		switch(userByname.get().getPassword().compareTo(user.getPassword())) {
		
		case 0:
		
			 String userID = userByname.get().getUserID();
			 String username = userByname.get().getUsername();
			 String organisation = userByname.get().getOrganisation();
			 String category =userByname.get().getCategory();
			__response = new UserResponse(1, new UserLoginResponse(userID,username,organisation,category));
		
		}
		
				
		}
	
	else {
			__response = new UserResponse(2,"wrong credentials");
		}
		
		return __response;
		 
		
	}


	public Object deleteTender(String tenderID) {
		boolean tenderExists = tenderRepo.existsById(tenderID);
		
		
		if(!tenderExists) {
			return new UserResponse(0,"Internal Error");
			
		}
		
		else {
			tenderRepo.deleteById(tenderID);
			return new UserResponse(1,"Tender Successfully deleted");
		}
		
	}


	public Object saveTender(Tenders tender) {
		
		tender.setTenderID(idGenerator("tenderIDGeneration").generateIDNo());
		
		
	  Optional <Tenders> tenderById = tenderRepo.getTendersByTenderID(tender.getTenderID());

 
	  if(tenderById.isPresent()) {
		  return new UserResponse(0 ,"Duplicate Entry");
	  }
	  
	  else {
		  tenderRepo.save(tender);
		  return new UserResponse(1, "Tender Successfully Registered");
	  }
	}


	public Object signup(Users user) {
		
		Optional<Users> userByUsername = userRepo.getUserByUsername(user.getUsername());
		

				
		if(userByUsername.isPresent()) {
			return new UserResponse(0, "Username already taken");
			
		}
		
		else {
			
			
			
			
			user.setUserID(idGenerator("userIDGeneration").generateIDNo());
			userRepo.save(user);
			return new UserResponse(1,"User successfully registered" );
		}
		
	}


	public List<Users> getUsers() {
		
		return userRepo.findAll();
	}


	public Object saveBid(Bid bid) {
		
		Optional <Bid> bidByID = bidRepo.getBidByBidID(bid.getBidID());
		
		if(!bidByID.isPresent()) {
			
			bid.setBidID(idGenerator("bidIDGeneration").generateIDNo());
			bidRepo.save(bid);
			
			return new UserResponse(1,"Bid Successfully Saved");
		}
		
		else {
			return new UserResponse(0,"Bid not saved, internal error");
		}
	}


	public Object getBidsByTenderID(String tenderID) {
		
		return new UserResponse(1, bidRepo.findBidByTenderID(tenderID));
	}


	public Object generateNotification(Notifications notification) {
		Optional<Notifications> notificationByID = 
				notifyRepo.getNotificationsByNotificationID(notification.getNotificationID());
		
		if(!notificationByID.isPresent()) {
			notification.setNotificationID(idGenerator("notificationIDGeneration").generateIDNo());
			notifyRepo.save(notification);
			return new UserResponse(1, "Notification  successfully Generated ");
		}
		
		else {
			return new UserResponse(0, "Notification  not Generated,  Internal Error");
		}
	}


	public Object getNotifications(String userID) {
		return new UserResponse(1, notifyRepo.findNotificationsByUserID(userID));
		
	}


	public Object getTenderByUserID(String userID) {
		
		return new UserResponse(1, tenderRepo.findTendersByUserID(userID));
	}


	public List<Bid> getAllBids() {
		
		return bidRepo.findAll();
	}


	public Object getUserByUsername(String username) {
		Optional<Users> userByusername = userRepo.getUserByUsername(username);
		
		if(userByusername.isPresent()) {
			return new UserResponse(0,"user already exists");
		}
		
		else {
			return new UserResponse(1,"user is unique");
		}
	}


	public Object updateTender(Tenders tender) {
		tenderRepo.save(tender);
		
	    return new UserResponse(1,"tender successfully updated");
	}
    
	
	public Object updateBid(String bidID, String bidSTATUS) {
	   
	   Optional<Bid> bidByID = bidRepo.findById(bidID);
	   if(bidByID.isPresent()) {
		   
		   Bid bid =bidByID.get();
		     bid.setBidSTATUS(bidSTATUS);
		      bidRepo.save(bid);
		      
		      return new UserResponse(1, "Bid successfully Updated");
	   
	   }
	   
	   else {
		   
		   return new UserResponse(0, "Internal Error");
	   }
	   
	 
	}
}
