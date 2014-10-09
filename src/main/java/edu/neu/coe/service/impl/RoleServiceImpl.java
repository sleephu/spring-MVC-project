package edu.neu.coe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.coe.dao.RoleDAO;
import edu.neu.coe.domain.Role;
import edu.neu.coe.service.RoleService;

@Service  
@Transactional  
public class RoleServiceImpl implements RoleService {  
      
    @Autowired  
    private RoleDAO roleDAO;  
  
  
    @Override
    @Transactional  
	public Role getRole(int id) {  
        return roleDAO.getRole(id);  
    }



	@Override
	@Transactional  
	public void setRole(Role role) {
		 roleDAO.setRole(role);
		
	}  
  
}  
