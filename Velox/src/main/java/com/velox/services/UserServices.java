package com.velox.services;


import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.velox.DTO.UserDTO;
import com.velox.utils.Hash;
import com.velox.entities.Role;
import com.velox.entities.User;
import com.velox.repositories.IUserDAO;

@Service
public class UserServices {

	
	private IUserDAO userDAO;
	private RoleService roleService;
	
	
	@Autowired
	public UserServices(IUserDAO userDAO, RoleService roleService) {
		super();
		this.userDAO = userDAO;
		this.roleService = roleService;
	}
	
	
	public Optional<User> findById(int id) {
		return userDAO.findById(id);
		
	}
	public List<User> findAll(){
		return userDAO.findAll();
		
	}

	public Role findUserRole(int id) {
		Role role = roleService.findById(id);
		return role;
		
	}

	public User updateUser(User p) {
		return userDAO.save(p);
	}


	public User login(String username, String password) {
		String hashedPassword = "";
		try {
			hashedPassword = Hash.generateHash(password, "MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return userDAO.findUserByUsernameAndPassword(username.toLowerCase(), hashedPassword);
	}


	public User addUser(UserDTO p) {
		String password = "";
		try {
			password = Hash.generateHash(p.password, "MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		Role userRole = roleService.findByName("patient");
		User user = new User(p.username.toLowerCase(), password, p.firstName, p.lastName, p.phoneNumber, userRole);
		userDAO.save(user);
		return user;
	}
	
}
