package edu.neu.coe.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="role")
public class Role {
	@Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ROLE_ID", unique=true, nullable=false)
	private Integer roleId;
	
	@Column(name="AUTHORITY",unique=true)
	private String role;
 
	 
//	@JoinTable( name="user_roles",   
//	     joinColumns = {@JoinColumn(name="ROLE_ID", referencedColumnName="ROLE_ID")},  
//	     inverseJoinColumns = {@JoinColumn(name="USER_ID", referencedColumnName="USER_ID")})  
	@OneToMany(cascade=CascadeType.ALL,mappedBy="role") 
	private Set<User> userRoles= new HashSet<User>();  
	public void setRole(String role) {
	this.role = role;
}
	public String getRole() {
	return role;
}
 
	public void setRoleId(Integer roleId) {
	this.roleId = roleId;
}

	public Integer getRoleId() {
	return roleId;
}
 
	public void setUserRoles(Set<User> userRoles) {
	this.userRoles = userRoles;
}

	public Set<User> getUserRoles() {
	return userRoles;
}
}
 