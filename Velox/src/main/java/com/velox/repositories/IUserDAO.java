package com.velox.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.velox.entities.Role;
import com.velox.entities.User;

@Repository
public interface IUserDAO  extends JpaRepository<User, Integer>{

	Optional<User> findById(int id);
	User findByUserID(int id);
	User findUserByUsernameAndPassword(String username, String password);
	Role userRole(int id);
	Role findByUserRole(User user);
}
