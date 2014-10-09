//package edu.neu.coe;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//
//import edu.neu.coe.domain.Role;
//
//public class RoleTest {
//	public static void main(String args[]) {
//		
//		Configuration config = new Configuration().configure("hibernate.cfg.xml");
//		SessionFactory sf = config.buildSessionFactory();
//		
//		Session session = sf.openSession();
//		
//		session.beginTransaction();	
//		
//	Role r1 = new Role();
//	r1.setRole("admin");
//	
//	Role r2 = new Role();
//	r2.setRole("customer");
//	
//	Role r3 = new Role();
//	r3.setRole("restaurant");
//	
//
//	session.save(r1);
//
//	session.save(r2);
//
//	session.save(r3);
//	
//	session.getTransaction().commit();
//	session.close();
//	sf.close();
//	}
//}
