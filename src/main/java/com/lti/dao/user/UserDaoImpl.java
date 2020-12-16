package com.lti.dao.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.entity.user.User;

@Repository
@SuppressWarnings("unchecked")
public class UserDaoImpl implements UserDao {

	@PersistenceContext	
	 EntityManager em;
	
	
	@Override
	public User UserCreation(User usr) {
		User u=em.merge(usr);
		return u;
	}
	
	
	@Override
	public List<User> getAllUsers() {
		Query q=em.createQuery("select m from User m");
		List<User> usrlist=q.getResultList();
		return usrlist;
		
	}
	

	
	@Override
	public User deleteUserById(int id) {
		User u=em.find(User.class,id);
		
		if(u!=null)
			{
			em.remove(u);
			}
        return u;
	}
	
	

	public User getUserById(int id) {
		return em.find(User.class,id);
		
	}

	@Override
	public User logoutUser() {
		
		System.out.println("Logged out Successfully");
		return null;
	}

	@Override
	public List<User> getUserByEmail(String email) {
		String sql = "select u from User u where email="+email;
		Query query = em.createQuery(sql);
		List<User> lt = query.getResultList();
		return lt;
		
		
	}
	
	


	@Override
	public User UpdateUser(User usr) {
		System.out.println("inside dao");
		User u=em.find(User.class,usr.getId());
		if(u!=null)
		{
			//u.setId(u.getId());
			
			u.setFirst_name(usr.getFirst_name());
			
			u.setLast_name(usr.getLast_name());
			
			u.setContact(usr.getContact());
			
			u.setEmail(usr.getEmail());
			
			u.setPwd(usr.getPwd());
			
			u.setGender(usr.getGender());
			
			u.setDate_of_birth(usr.getDate_of_birth());
			
			
			
			
			u.setRole(usr.getRole());
			
			
		}
		
		return u;
	}

	@SuppressWarnings("null")
	@Override
	public List<User> UpdateUserByEmail(String email, String pwd) { //method to be implemented for forgotPassword
		// TODO Auto-generated method stub
		String sql = "select u from User u where email ='"+email+"'";
		Query query = em.createQuery(sql);
		List<User> usr = query.getResultList();
		if(usr!=null || !usr.isEmpty()){
			usr.get(0).setPwd(pwd); //pwd input from angular form
		}
		return usr;
	}
	
	

	@SuppressWarnings("null")
	@Override
	public boolean loginUser(String email, String pwd) {     //method for login
		String sql = "select u from User u where email ='"+email+"'";
		boolean check = false;
		
		Query query = em.createQuery(sql);
		List<User> usr = query.getResultList();
		if(usr!=null || !usr.isEmpty()){
			String userPass = usr.get(0).getPwd();
			if(pwd.equals(userPass)){
				check = true;
				System.out.println("Logged in successfully");
			}
			else{
				System.out.println("Invalid credentials");
			}
		}
		else{
			System.out.println("user null"); //checking reachability
		}
		return check;
		
		
	}

	
	
	
	
	
	

	/*@Override
	public UserRegistration loginUser(String email, String pwd) {
		try{
			System.out.println("dao login");
		Query query = em.createNamedQuery("loginUser");
		    query.setParameter("username", email);
		    query.setParameter("password", pwd);
		    System.out.println("dao login");
           return (UserRegistration) query.getSingleResult();
		}
		
		catch(Exception e){
			System.out.println( "Wrong Username or Password. ");
			return null;
		}
		
		
	}*/
	
	@SuppressWarnings("null")
	@Override
	public List<User> loginCheck(User usrc) {     //method for login
		
		String e=usrc.getEmail();
		String p=usrc.getPwd();
		
		System.out.println("e-userlogin:"+e);
		System.out.println("p-"+p);
		try{
		String sql = "select u from User u where email ='"+e+"'";
		
		boolean check = false;
		
		Query query = em.createQuery(sql);
		List<User> usr = query.getResultList();
		if(usr!=null || !usr.isEmpty()){
			String userPass = usr.get(0).getPwd();
			System.out.println("db:"+userPass);
			System.out.println("check:"+p.equals(userPass));
			if(p.equals(userPass)){
				check = true;
				System.out.println("Logged in successfully");
			}
			else{
				System.out.println("Invalid credentials");
			}
			System.out.println(usr);
		}
		else{
			System.out.println("user null"); //checking reachability
		}
		return usr;
		
		
	}
		catch(Exception e1){
			System.out.println("Invalid Credentials");
		}
		return null;
		
	}

	

	@SuppressWarnings("null")
	public List<User> resetpwd(User user) {
		
		String e=user.getEmail();
		String p=user.getPwd();
		
		System.out.println("old mail: "+e);
		System.out.println("new pass: "+p);
		try{
		String sql = "select u from User u where email ='"+e+"'";
		Query query = em.createQuery(sql);
		List<User> usr = query.getResultList();
		if(usr!=null || !usr.isEmpty()){
			String userPass = usr.get(0).getPwd();
			System.out.println("old pass:"+userPass);
			usr.get(0).setPwd(p);
			System.out.println("updated password");
			System.out.println(usr);
		}
		return usr;
		
		}
		catch(Exception e1){
			System.out.println("Wrong username");
		}
		return null;
	}

	public String getRole(String email){
		String sql = "select role from User u where email ='"+email+"'";
		Query query = em.createQuery(sql);
		List<String> role = query.getResultList();
		if(role!=null || !role.isEmpty()){
			System.out.println("user role:"+role);
			return role.get(0);
		}
			
		else
			return null;
		
	}
	
	

}
