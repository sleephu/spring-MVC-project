//package edu.neu.coe;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//
//import edu.neu.coe.domain.Restaurant;
//import edu.neu.coe.domain.Role;
//import edu.neu.coe.domain.User;
//
//public class RestaurantTest {
//
//	public static void main(String args[]) {
//		Configuration config = new Configuration().configure("hibernate.cfg.xml");
//		SessionFactory sf = config.buildSessionFactory();
//		
//		Session session = sf.openSession();
//		
//		session.beginTransaction();
//		
//		
//		
//		Restaurant r1 = new Restaurant();
//		r1.setRestaurantName("jiahe");
//		r1.setTelephone("123432");
//		User u3 = new User();
//		u3.setUserName("tu");
//		u3.setPassword("123");
////		u3.setRestaurant(r1);
//		
//		
//		
//		Role restaurantRole = new Role();
//		restaurantRole.setRole("restaurant");
//		u3.setRole(restaurantRole);
//
//		
//		session.save(r1);
//		session.save(u3);
//		session.save(restaurantRole);
//		
//		session.getTransaction().commit();
//		session.close();
//		sf.close();
//	}
//}
