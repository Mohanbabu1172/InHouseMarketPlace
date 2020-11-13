package com.cg.InHouseMarketPlace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.InHouseMarketPlace.model.User;
@Repository
public interface UserRepository extends JpaRepository<User,String>{
	@Query("select u from User u where user_id=?1 and password=?2")
	public User login(String userId,String password);
}
