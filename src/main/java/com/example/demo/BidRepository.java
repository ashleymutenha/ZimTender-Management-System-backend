package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public interface BidRepository extends JpaRepository<Bid ,String> {
	
	Optional<Bid> getBidByBidID(String bidID);
	
	List<Bid> findBidByTenderID(String tenderID);
	
	

}
