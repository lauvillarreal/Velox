package com.velox.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.velox.entities.Role;

@Repository
public interface IRoleDAO  extends JpaRepository<Role, Integer> {

	public Role findRoleByRoleID(int roleId);
	public Role findRoleByRole(String role);
}
