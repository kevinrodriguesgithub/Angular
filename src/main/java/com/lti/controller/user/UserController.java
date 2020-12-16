package com.lti.controller.user;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.user.User;
import com.lti.service.user.UserServiceImpl;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class UserController {

	@Autowired
	UserServiceImpl serviceobj;

	// Create User
	@PostMapping("/UserCreation")
	public ResponseEntity<String> UserCreation(@RequestBody User usr) {
		User u = serviceobj.UserCreation(usr);
		if (u == null) {
			return null;
		} else {
			return new ResponseEntity<String>("User created successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}

	// Get all users
	@GetMapping("/GetAllUsers")
	private ResponseEntity<List<User>> getAllUsers() {
		List<User> usrlist = serviceobj.getAllUsers();
		return new ResponseEntity<List<User>>(usrlist, new HttpHeaders(), HttpStatus.OK);

	}

	@PutMapping("/UpdateUser")
	public ResponseEntity<String> UpdateUser(@RequestBody User usr) {

		User u = serviceobj.UpdateUser(usr);

		if (u == null) {
			return null;
			// throw new IdNotFoundException("Update Operation
			// Unsuccessful,Provided username does not exist");
		} else {
			return new ResponseEntity<String>("User updated successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}

	@DeleteMapping("/DeleteUser/{id}")
	private ResponseEntity<String> deleteUserById(@PathVariable("id") int id) {

		User e = serviceobj.deleteUserById(id);
		if (e == null) {
			return null;
			// throw new IdNotFoundException("Delete Operation
			// Unsuccessful,Provided Id does not exist");
		} else {

			return new ResponseEntity<String>("User deleted successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}

	@GetMapping("/GetUser/{id}")
	private ResponseEntity<User> getUserById(@PathVariable("id") int id) {

		User u = serviceobj.getUserById(id);
		if (u == null) {
			return null;
			// throw new IdNotFoundException("Id does not exist,so we couldn't
			// fetch details");
		} else {
			return new ResponseEntity<User>(u, new HttpHeaders(), HttpStatus.OK);
		}

	}

	@PostMapping("/logoutUser")
	private ResponseEntity<String> logoutUser() {
		System.out.println("logged out Successfully");
		return new ResponseEntity<String>("logged out successfully", new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/getByEmail/{email}")
	public String getByEmail(@PathVariable String email) {
		List<User> ur = serviceobj.getUserByEmail(email);
		System.out.println(ur);
		return ur.toString();
	}

	@PostMapping(value = "/updateByEmail", consumes = "application/json")
	public String updateByEmail(@RequestBody Map<String, String> json) {
		System.out.println("INSIDE UPDATE BY EMAIL");
		List<User> usr = serviceobj.UpdateUserByEmail(json.get("email"), json.get("pwd"));
		return usr.toString();
	}

	@PostMapping(value = "/loginUser", consumes = "application/json")
	public String loginUser(@RequestBody Map<String, String> json) {
		System.out.println("INSIDE Login BY EMAIL");
		boolean check = false;
		check = serviceobj.loginUser(json.get("email"), json.get("pwd")); // getting
																			// user
																			// object,
																			// hence
																			// printing
		String res = "Logged in successfully!";
		if (check)
			return res;
		else
			return "Invalid credentials";

	}
	
	@PostMapping(value="/logincheck",consumes="application/json")
	public List<User> logincheck(@RequestBody User usrc) {
		
		System.out.println("controller: "+usrc.getEmail());
		System.out.println(usrc.getPwd());
		System.out.println(usrc);
		System.out.println("INSIDE Login BY EMAIL");
		boolean check = false;
//		check = serviceobj.loginCheck(usrc);
		System.out.println("check in controll: "+check);
		//String res = "Logged in successfully!"; 
		List<User> ul = serviceobj.loginCheck(usrc);
		System.out.println(ul);
		return  ul;
		
	}
	
	
	@PostMapping(value="/resetpwd",consumes="application/json")
	private ResponseEntity<String> resetpwd(@RequestBody User user){
	
		List<User> u=serviceobj.resetpwd(user);
		
		System.out.println(u);
		if(u!=null){
		return new ResponseEntity<String>("Updated password", new HttpHeaders(), HttpStatus.OK); 
		}
		else{
			return new ResponseEntity<String>("Wrong username", new HttpHeaders(), HttpStatus.OK);
		}
	}
	
	@GetMapping(value="/getRole")
	public ResponseEntity<String> getRole(@RequestParam String username){
		String uname = serviceobj.getRole(username);
		if(uname != null)
			return new ResponseEntity<String>(uname, new HttpHeaders(), HttpStatus.OK);
		else
			return new ResponseEntity<String>("Couldn't return"+uname, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
