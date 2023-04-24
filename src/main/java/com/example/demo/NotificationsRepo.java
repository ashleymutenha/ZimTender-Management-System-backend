package com.example.demo;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
@Component
public interface NotificationsRepo extends JpaRepository<Notifications,String> {
	
	Optional<Notifications> getNotificationsByNotificationID(String notificationID);
	
	List<Notifications> findNotificationsByUserID(String userID);
	
	
	


}
