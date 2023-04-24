package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


@Component
public interface TenderRepository extends JpaRepository<Tenders ,String> {

	Optional <Tenders>getTendersByTenderID(String tenderID);
	
	List<Tenders> findTendersByUserID(String userID);
}
