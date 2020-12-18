package com.velox.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velox.entities.Role;
import com.velox.repositories.IRoleDAO;

@Service
public class RoleService {
	
	
	private IRoleDAO roleDao;
	
	@Autowired
	public RoleService(IRoleDAO roleDAO) {
		super();
		this.roleDao = roleDAO;
	}
	
	public Role findById(int roleId) {
		return roleDao.findRoleByRoleID(roleId);
	}
	
	public Role findByName(String name) {
		return roleDao.findRoleByRole(name);
	}
}
