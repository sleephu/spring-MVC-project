//package edu.neu.coe;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//
//import edu.neu.coe.domain.Food;
//import edu.neu.coe.domain.Menu;
//
//public class MenuTest {
//
//	public static void main(String args[]) {
//		Configuration config = new Configuration().configure("hibernate.cfg.xml");
//		SessionFactory sf = config.buildSessionFactory();
//		Session session = sf.openSession();
//		session.beginTransaction();
//		
//		Menu m1 = new Menu();
//		m1.setMenuName("r's menu");
////		Menu m2 = new Menu();
//		
//		Food f1 = new Food();
//		f1.setFoodName("beef");
//		f1.setPrice(8.50);
//		
//		Food f2 = new Food();
//		f2.setFoodName("water");
//	    f2.setPrice(3.50);
//	    Set<Food> foods = new HashSet<Food>();
//	    foods.add(f1);
//	    foods.add(f2);
//	    
//
//	    m1.setFoods(foods);
//	    
//		session.save(m1);
////		session.save(m2);
//		
//		
//		session.getTransaction().commit();
//		
//
//	}
//	
//}
