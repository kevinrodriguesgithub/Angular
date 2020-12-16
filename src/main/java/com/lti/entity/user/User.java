



package com.lti.entity.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;                                       
	 private String first_name;                                      
	 private String last_name;                                          
	 private long contact;                                            
	 private String email;                                            
	 private String pwd;                                                
	 private String gender; 
	 private Date date_of_birth;
	 private String role;
	 
	public User(){
		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User(int id, String first_name, String last_name, long contact, String email, String pwd,
			String gender, Date date_of_birth, String role) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.contact = contact;
		this.email = email;
		this.pwd = pwd;
		this.gender = gender;
		this.date_of_birth = date_of_birth;
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserRegistration [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", contact="
				+ contact + ", email=" + email + ", pwd=" + pwd + ", gender=" + gender + ", date_of_birth="
				+ date_of_birth + ", role=" + role + "]";
	}
	
	
	 
	 
	 
	 
}
