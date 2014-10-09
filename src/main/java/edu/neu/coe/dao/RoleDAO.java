package edu.neu.coe.dao;

import edu.neu.coe.domain.Role;

public interface RoleDAO {

	public Role getRole(int id);
	
	public void setRole(Role role);
}
