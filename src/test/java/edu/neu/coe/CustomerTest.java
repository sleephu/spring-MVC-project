//package edu.neu.coe;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//
//import edu.neu.coe.domain.Role;
//import edu.neu.coe.domain.User;
//
//public class CustomerTest {
//	public static void main(String args[]) {
//	Configuration config = new Configuration().configure("hibernate.cfg.xml");
//	SessionFactory sf = config.buildSessionFactory();
//	
//	Session session = sf.openSession();
//	
//	session.beginTransaction();
//	
////	Customer c1 = new Customer();
////	c1.setFirstName("hu");
////	c1.setLastName("tu");
////	c1.setGender("F");
////	c1.setTelephoneNo("12334243");
////	c1.setEmail("sleephu@126.com");
//
////	session.save(c1);
//	
////	Role customerRole = new Role();
////	customerRole.setRole("customer");
////	session.save(customerRole);
////	User u2 = new User();
////	u2.setUserName("hu");
////	u2.setPassword("123");
//////	u2.setCustomer(c1);
////	
////	Restaurant r1 = new Restaurant();
////	r1.setRestaurantName("jiahe");
////	r1.setTelephone("123432");
////	session.save(r1);
//	
////	
////	Role restaurantRole = new Role();
////	restaurantRole.setRole("restaurant");
////	
////	
////	u2.setRole(customerRole);
//	User user1 = new User();
//	user1.setUserName("admin");
//	user1.setPassword("admin");
//	
////	c1.setUser(user1);
////session.save(user1);
//	//
////	User u3 = new User();
////	u3.setUserName("tu");
////	u3.setPassword("123");
////	u3.setRestaurant(r1);
////	u3.setRole(restaurantRole);
////	
////	Customer c2 = new Customer();
////	c2.setFirstName("h");
////	c2.setLastName("u");
////	c2.setGender("M");
////	c2.setTelephoneNo("12334243");
////	c2.setEmail("h@126.com");
////	
////	
//	Role adminRole = new Role();
//	adminRole.setRole("admin");
//	user1.setRole(adminRole);
////	
//	session.save(user1);
////	session.save(adminRole);
////	
////	
////
////	
////	
////	
////	
////	u2.setRestaurant(r1);
////	session.save(c2);
////	session.save(u2);
////
////
////	session.save(u3);
////	session.save(restaurantRole);
//	
//	session.getTransaction().commit();
//	session.close();
//	sf.close();
//	
//}
//}
