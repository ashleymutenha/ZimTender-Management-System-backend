package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TenderRestController {
	
	public final TenderService service;
	
	
	
	public TenderRestController(TenderService service) {
		this.service = service;
	}
	
	
	@GetMapping("/getTenders")
	public List<Tenders> getTenders(){
		return service.getTenders();
	}
	
	@GetMapping("/getUsers")
	public List<Users> getUsers(){
		return service.getUsers();
		
	}
	
	
//	@GetMapping("/entities")
//	
//	public Long numberofEntities() {
//		return service.generateUserID();
//	}
	
	@GetMapping("/getUser/{username}")
	public Object getUserByUserName(@PathVariable("username") String username) {
		
		return service.getUserByUsername(username);
	}
	
	@GetMapping("/getTenders/{userID}")
	public Object getTenderByUserID(@PathVariable("userID") String userID){
		
		return service.getTenderByUserID(userID);
	}
	
	
	@PostMapping("/login")
		
		public Object login(@RequestBody LoginUser user){
			return service.login(user);
		}
	
	@PostMapping("/signup")
	public Object signup(@RequestBody Users user) {
		
		
		
		return service.signup(user);
	}
	
	

	
	
	@PostMapping("/saveTender")
	
	public Object saveTender(@RequestBody Tenders tender) {
		return service.saveTender(tender);
	}
	
	
	@DeleteMapping("/{tenderID}")
	public Object deleteTender(@PathVariable("tenderID") String tenderID) {
		
		return service.deleteTender(tenderID);
	}
	@GetMapping("/getBidByTenderId/{tenderID}")
	public Object getBidsByTenderID(@PathVariable("tenderID") String tenderID){
		return service.getBidsByTenderID(tenderID);
	}
	
	@PostMapping("/saveBid")
	public Object saveBid(@RequestBody Bid bid) {
		
		return service.saveBid(bid);
	}
	

	@GetMapping("/getBids")
	public List<Bid> getAllBids(){
		return service.getAllBids();
	}
	
	@PutMapping("/updatebid/{bidID}/{bidSTATUS}")
	public Object updateBid(@PathVariable("bidID") String bidID, @PathVariable("bidSTATUS")String bidSTATUS) {
		
		return service.updateBid(bidID,bidSTATUS);
		
	}
	
	
	@PostMapping("/generateNotification")
	public Object generateNotification(@RequestBody Notifications notification) {
		
		return service.generateNotification(notification);
		
	}
	
	@GetMapping("/getNotifications/{userID}")
	public Object getNotifications(@PathVariable("userID") String userID) {
		
		return service.getNotifications(userID);
	}
	
	
	@PostMapping("/updateTender")
	public Object updateTender(@RequestBody Tenders tender) {
	
		return service.updateTender(tender);
	}
		

}
