package edu.neu.coe.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.coe.dao.RoleDAO;
import edu.neu.coe.dao.UserAdminDAO;
import edu.neu.coe.domain.Role;

@Service
@Transactional(readOnly = true)
public class CustomUserDetailsService implements UserDetailsService {

	// @Autowired
	// private UserAdminService userAdminServicerDAO;
	//
	// @Autowired
	// private RoleDAO roleDAO;

	// @Autowired
	// private UserDAO userDAO;

	@Autowired
	private UserAdminDAO userAdminDAO;

	@Autowired
	private RoleDAO roleDAO;

//	@Autowired
//	public CustomUserDetailsService(UserAdminDAO userAdminDAO, RoleDAO roleDAO){
//		this.userAdminDAO =userAdminDAO;
//		this.roleDAO =roleDAO;
//		
//	}
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException, DataAccessException {

		try {
			edu.neu.coe.domain.User domainUser = userAdminDAO.getUser(userName);
			System.out.println(domainUser);
			System.out.println("USER IN CustomerDetails:" + userName);
			System.out.println("USER IN CustomerDetails:"
					+ domainUser.getUserName());

			boolean enabled = true;
			boolean accountNonExpired = true;
			boolean credentialsNonExpired = true;
			boolean accountNonLocked = true;

			return new User(domainUser.getUserName(), domainUser.getPassword(),
					enabled, accountNonExpired, credentialsNonExpired,
					accountNonLocked, getAuthorities(domainUser.getRole()
							.getRoleId()));
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new UsernameNotFoundException(
					"getUserByUserName returned null.");
			
		}

	}

	public Collection<? extends GrantedAuthority> getAuthorities(Integer role) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
		return authList;
	}

	public List<String> getRoles(Integer roleId) {

		List<String> roles = new ArrayList<String>();
		Role role = roleDAO.getRole(roleId);
		if (role.getRoleId().intValue() == 1) {
			roles.add("ROLE_ADMIN");
		} else if (role.getRoleId().intValue() == 2) {
			roles.add("ROLE_CUSTOMER");
		} else if (role.getRoleId().intValue() == 3) {
			roles.add("ROLE_RESTAURANT");
		}

		return roles;
	}

	public static List<GrantedAuthority> getGrantedAuthorities(
			List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}

}
