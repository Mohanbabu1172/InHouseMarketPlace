package com.cg.InHouseMarketPlace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.InHouseMarketPlace.model.User;
import com.cg.InHouseMarketPlace.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	/*
	 * login
	 */
	public User login(User user)
	{
		User loggedUser=userRepository.login(user.getUserId(), user.getPassword());
		if(loggedUser!=null) {
			return loggedUser;
		}
		else
		{
			return new User();
		}
	}
	/*
	 * adding user
	 */
	public User addUser(User user)
	{
		return userRepository.save(user);
	}
	
	/*
	 * updating user
	 */
	public User editUser(User user)
	{
		if(userRepository.findById(user.getUserId()) != null){
			return userRepository.save(user);
		}
		else {
			return null;
		}
	}
	/*
	 * deleting user
	 */
	public User deleteUser(String id)
	{
		userRepository.deleteById(id);
		return null;
	}
}
