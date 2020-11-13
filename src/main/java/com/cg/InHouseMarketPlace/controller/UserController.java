package com.cg.InHouseMarketPlace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.InHouseMarketPlace.exception.InvalidEmployeeException;
import com.cg.InHouseMarketPlace.model.User;
import com.cg.InHouseMarketPlace.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	/*
	 * login
	 */
	@PostMapping("/login")
	public User login(@RequestBody User user) {
		User user1 = userService.login(user);
		if(user1.getUserId()==null || user1.getPassword()==null)
		{
			throw new InvalidEmployeeException("Login failed chesck your user Id and Password");
		}
		else
		{
			return user1;
		}
		}
	/*
	 * adding user
	 */
	@PostMapping("/addUser")
	public ResponseEntity<User> add(@RequestBody User user) {
		User user1 = userService.addUser(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	/*
	 * updating user
	 */
	@PutMapping("/updateUser")
	public ResponseEntity<User> update(@RequestBody User user) {
		User user1=userService.editUser(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	/*
	 * deleting user
	 */
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<User> delete(@PathVariable String userId) {
		User user=userService.deleteUser(userId);
		return new ResponseEntity<User>(user, HttpStatus.OK);

	}
}
