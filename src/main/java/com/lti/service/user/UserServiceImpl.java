package com.lti.service.user;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.user.UserDaoImpl;
import com.lti.entity.user.User;



@Service
@Transactional
public class UserServiceImpl {

	@Autowired
	UserDaoImpl dao;
	
	public User UserCreation(User usr) {
		return dao.UserCreation(usr);
	}
	
	public List<User> getAllUsers() 
	{
	return dao.getAllUsers();
	}
	
	public User deleteUserById(int id) {

		return dao.deleteUserById(id);
	}
	
	public User getUserById(int id){
		return dao.getUserById(id);
	}
	
public User logoutUser(){
	return dao.logoutUser();
}

public List<User> getUserByEmail(String email){
	return dao.getUserByEmail(email);
}

	
public User UpdateUser(User usr){
		
		return dao.UpdateUser(usr);	
	}

public List<User> UpdateUserByEmail(String email, String pwd){
	return dao.UpdateUserByEmail(email, pwd);
}
	
	
	
	public boolean loginUser(String email,String pwd){
		System.out.println("service login");
		return dao.loginUser(email, pwd);
	}
	
//	public  List<User> uniqueEmail(User usr) {
//		return dao.uniqueEmail(usr);
//	}

	public List<User> loginCheck(User usrc){
		System.out.println("service login");
		return dao.loginCheck(usrc);
	}



	public List<User> resetpwd(User user) {
		// TODO Auto-generated method stub
		return  dao.resetpwd(user);
	}
	
	public String getRole(String email){
		return dao.getRole(email);
	}
	
	
	
	
	
	
	
	
	
}
