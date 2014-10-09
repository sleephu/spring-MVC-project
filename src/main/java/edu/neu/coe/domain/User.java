package edu.neu.coe.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User 
//implements UserDetails
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="USER_ID", unique=true, nullable=false)
	private Integer userId;
	@Column(name="USER_NAME", nullable = false, unique= true)
	private String userName;
	@Column(name="PASS_WORD", length =50)
    private String password;
//	
//	@Column(name="ENABLED")
//	private Boolean enabled;
//	
//	@JoinTable(name = "USER_AUTHORITIES", joinColumns = { @JoinColumn(name="USER_ID")},
//			inverseJoinColumns={@JoinColumn(name="AUTHORITY_ID")})
	
	
//    @JoinTable(name="user_roles",  
//        joinColumns = {@JoinColumn(name="USER_ID", referencedColumnName="USER_ID")},  
//        inverseJoinColumns = {@JoinColumn(name="ROLE_ID", referencedColumnName="ROLE_ID")}) 
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="ROLE_ID")
    private Role role;  
	
//	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//    @JoinTable(name="user_Authority",  
//        joinColumns = {@JoinColumn(name="USER_ID")},  
//        inverseJoinColumns = {@JoinColumn(name="AUTHORITY_ID")})  
//	private Set<Authority> authoritySet;
  
	
//	public Set<Authority> getAuthoritySet() {
//		return authoritySet;
//	}
//	public void setAuthoritySet(Set<Authority> authoritySet) {
//		this.authoritySet = authoritySet;
//	}
//	private transient Collection<GrantedAuthority> authorities;
//	@OneToOne(fetch=FetchType.LAZY, mappedBy="user")
//	@JoinTable(name="user_customers", joinColumns = @JoinColumn(name="USER_ID"),
//	inverseJoinColumns = @JoinColumn(name="CUSTOMER_ID"))  
//    private Customer customer;
    
//	@OneToOne(fetch=FetchType.LAZY, mappedBy="user")
//	@JoinTable(name="user_restaurants",  
//    joinColumns = {@JoinColumn(name="USER_ID", referencedColumnName="USER_ID")},  
//    inverseJoinColumns = {@JoinColumn(name="RESTAURANT_ID", referencedColumnName="RESTAURANT_ID")})  
//	private Restaurant restaurant;
    
//	@OneToMany(fetch=FetchType.LAZY, mappedBy="user", cascade=CascadeType.ALL)
//	private Set<Address> addresses= new HashSet<Address>();
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="user")
	private Set<Appointment>appointments = new HashSet<Appointment>();
	
	public Set<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}
//	public Set<Address> getAddresses() {
//		return addresses;
//	}
//	public void setAddresses(Set<Address> addresses) {
//		this.addresses = addresses;
//	}
//	public Boolean getEnabled() {
//		return enabled;
//	}
//	public void setEnabled(Boolean enabled) {
//		this.enabled = enabled;
//	}
	
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
//	public Restaurant getRestaurant() {
//		return restaurant;
//	}
//	public void setRestaurant(Restaurant restaurant) {
//		this.restaurant = restaurant;
//	}
    public Integer getUserId() {
		return userId;
	}
    public void setUserId(Integer userId) {
		this.userId = userId;
	}

//    public Customer getCustomer() {
//	return customer;
//}
//
//    public void setCustomer(Customer customer) {
//	this.customer = customer;
//}
    
    public void setUserName(String userName) {
		this.userName = userName;
	}
    public String getUserName() {
		return userName;
	}
    public void setPassword(String password) {
		this.password = password;
	}
    public String getPassword() {
		return password;
	}
    
//    @Transient
//    public Collection<? extends GrantedAuthority> getAuthorities(Integer role) {
//		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
//		return authList;
//	}
//    @Transient
//	public List<String> getRoles(Integer roleId) {
//
//		List<String> roles = new ArrayList<String>();
////		Role role = roleDAO.getRole(roleId);
//		if (roleId.intValue() == 1) {
//			roles.add("ROLE_ADMIN");
//		} 
//		else if (roleId.intValue()== 2) {
//			roles.add("ROLE_CUSTOMER");
//		} 
//		else if (roleId.intValue() == 3) {
//			roles.add("ROLE_RESTAURANT");
//		}
//		
//		return roles;
//	}
//	@Transient
//	public static List<GrantedAuthority> getGrantedAuthorities(
//			List<String> roles) {
//		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//
//		for (String role : roles) {
//			authorities.add(new SimpleGrantedAuthority(role));
//		}
//		return authorities;
//	}
//
//	@Transient
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//	@Transient
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//	@Transient
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//	@Transient
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//	
//	@Transient
//	public Collection<GrantedAuthority> getAuthorities() {
//	return authorities;
//	}
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return null;
//	}
    
    

}
