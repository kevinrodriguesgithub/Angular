package com.lti.dao.user;

import java.util.List;

import com.lti.entity.user.User;



public interface UserDao {
	
	User UserCreation(User usr); //create a user
	
	List<User> getAllUsers();     //admin can view all users
	
	User deleteUserById(int id);   //admin can delete a user
	
	User getUserById(int id);      //view user by id
	
	User logoutUser(); //log out user
	
	List<User> getUserByEmail(String email);  //not working
	
	User UpdateUser(User usr);  /// to change password -byId
	
	List<User> UpdateUserByEmail(String email, String pwd);
	
	
	/*List<UserRegistration> loginUser(String email, String pwd);*/
	boolean loginUser(String email, String pwd);

	List<User> loginCheck(User usrc);
	
	List<User> resetpwd(User usrc);
	
	public String getRole(String email);
	
	/*
	  
	 UserRegistration loginUser(String email, String pwd);
	
	
	   
	
	
	
	
	

	*/

	

	
	

}

