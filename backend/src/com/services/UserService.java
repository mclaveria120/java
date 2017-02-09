package com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dao.UserDAO;
import com.exceptions.InvalidInputData;
import com.model.Role;
import com.model.User;
import com.util.Util;


@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private Util util;
	
	
	public void saveUser(User user) throws InvalidInputData {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		if(validUser(user) && !isUserAlreadyResiter(user.getEmail())){
			this.userDAO.persist(user);
		}else{
			throw new InvalidInputData();
		}
	}

	public boolean isUserAlreadyResiter(String email) {
		return  userDAO.isUserRegister(email);
	}
	
	public User getUserByName(String name){
		User user = this.userDAO.getUserByEmail(name);
		return user;
	}
	
	private boolean validUser(User user) {
		 String email = user.getEmail();
		 String name = user.getName();	
		 String password = user.getPassword();
		 String phone = user.getPhone();
		 String role = user.getRole();
		 String surname = user.getSurname();
		 
		return util.isParameterValid(email) 
				&& util.isParameterValid(name)
				&& util.isParameterValid(password)
				&& util.isParameterValid(phone)
				&& util.isParameterValid(role)
				&& (Role.ADMIN.toString().equals(role) || Role.USER.toString().equals(role))
				&& util.isParameterValid(surname);
	}
}
