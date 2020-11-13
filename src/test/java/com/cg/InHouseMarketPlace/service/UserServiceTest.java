package com.cg.InHouseMarketPlace.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.cg.InHouseMarketPlace.model.User;



@ExtendWith(MockitoExtension.class)
class UserServiceTest 
{
	UserService userservice=mock(UserService.class);
	User user=new User("123","Sai");

	@Test
	void login() 
	{
		when(userservice.login(user)).thenReturn(user);
		assertNotNull(userservice);
		assertEquals(user,userservice.login(user));
	}
		
	@Test
	void addUser() 
	{
		when(userservice.addUser(user)).thenReturn(user);
		assertNotNull(userservice);
		assertEquals(user,userservice.addUser(user));
	}
	@Test
	void editUser() 
	{
		when(userservice.editUser(user)).thenReturn(user);
		assertNotNull(userservice);
		assertEquals(user,userservice.editUser(user));
	}
	
	@Test
	void removeUser() 
	{
		when(userservice.deleteUser("123")).thenReturn(user);
		assertNotNull(userservice);
		assertEquals(user,userservice.deleteUser("123"));
	}

}
