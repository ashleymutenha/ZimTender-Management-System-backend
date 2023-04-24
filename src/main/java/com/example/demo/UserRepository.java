package com.example.demo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<Users, String> {
	
	Optional<Users> getUserByUsername(String username);
    Optional<Users> getUserByPassword(String password);
    Optional<Users> getUserByUserID(String userID);
    
   
	
    
	
}
