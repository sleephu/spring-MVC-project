//package edu.neu.coe;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//
//import edu.neu.coe.domain.Customer;
//import edu.neu.coe.domain.Restaurant;
//import edu.neu.coe.domain.Role;
//import edu.neu.coe.domain.User;
//
//
//
//public class UserTest {
//	public static void main(String args[]) {
//		Configuration config = new Configuration().configure("hibernate.cfg.xml");
//		SessionFactory sf = config.buildSessionFactory();
//		Session session = sf.openSession();
//		session.beginTransaction();
//		
//		Customer c1 = new Customer();
//		c1.setFirstName("hu");
//		c1.setLastName("tu");
//		c1.setGender("F");
//		c1.setTelephoneNo("12334243");
//		c1.setEmail("sleephu@126.com");
//	
//	
//		User user1 = new User();
//		user1.setUserName("hutu");
//		user1.setPassword("123");
//	
//		
//		Role adminRole = new Role();
//		adminRole.setRole("admin");
//		user1.setRole(adminRole);
//		
//		c1.setUser(user1);
//		session.save(c1);
//		session.save(user1);
//		session.save(adminRole);
//		
//		Customer c2 = new Customer();
//		c2.setFirstName("h");
//		c2.setLastName("u");
//		c2.setGender("M");
//		c2.setTelephoneNo("12334243");
//		c2.setEmail("h@126.com");
//		
//		User u2 = new User();
//		u2.setUserName("hu");
//		u2.setPassword("123");
//        c2.setUser(u2);
//		Role customerRole = new Role();
//		customerRole.setRole("customer");
////		u2.setRole(customerRole);
////		u2.setRestaurant(r1);
//		session.save(c2);
//		session.save(u2);
//		session.save(customerRole);
//
//		
//		Restaurant r1 = new Restaurant();
//		r1.setRestaurantName("jiahe");
//		r1.setTelephone("123432");
//		
//		User u3 = new User();
//		u3.setUserName("tu");
//		u3.setPassword("123");
//		r1.setUser(u3);
////		u3.setRestaurant(r1);
//	
//		Role restaurantRole = new Role();
//		restaurantRole.setRole("restaurant");
//		u3.setRole(restaurantRole);
//        session.save(restaurantRole);
//		session.save(u3);
//		session.save(r1);
//		
//		session.getTransaction().commit();
//		session.close();
//		sf.close();
//		
////		User user = (User)session.get(User.class, 1);
////		session.delete(user);
////		session.getTransaction().commit();
//		
//	}
//}
