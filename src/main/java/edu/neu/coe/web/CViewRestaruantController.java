package edu.neu.coe.web;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.neu.coe.domain.Address;
import edu.neu.coe.domain.Appointment;
import edu.neu.coe.domain.Food;
import edu.neu.coe.domain.Menu;
import edu.neu.coe.domain.Restaurant;
import edu.neu.coe.domain.User;
import edu.neu.coe.service.AddressService;
import edu.neu.coe.service.AppointmentService;
import edu.neu.coe.service.CustomerService;
import edu.neu.coe.service.FoodService;
import edu.neu.coe.service.MenuService;
import edu.neu.coe.service.RestaurantService;
import edu.neu.coe.service.UserAdminService;

@Controller
@RequestMapping("/user/customer/viewRestaurant")
public class CViewRestaruantController {
	@Autowired
	UserAdminService userAdminService;

	@Autowired
	RestaurantService restaurantService;

	@Autowired
	CustomerService customerService;
	
	@Autowired 
	AppointmentService appointmentService;
	
	@Autowired 
	AddressService addressService;
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	FoodService foodService;


	@RequestMapping(method = RequestMethod.GET)
	public String listRestaurant(Model model) {
		
		Restaurant restaurant = null;
		for(Restaurant r: restaurantService.ListRestaurants()){
			restaurant =r;
//			break;
		}
		if(restaurant ==null){
			return "user/customer/viewRestaurant";
		}
//		Address address = null;
//		ArrayList<Address> rAddress = new ArrayList<Address>();
//		for(Address a : addressService.listAddress()){
//			if(a.getRestaurant().getRestaurantId()==restaurant.getRestaurantId()){
//				address =a;
//				rAddress.add(a);
////				break;
//			}
//		}
//        model.addAttribute("address",address);
//        model.addAttribute("addressList",rAddress);
		model.addAttribute("restaurant", restaurant);
		model.addAttribute("restaurantList", restaurantService.ListRestaurants());

		return "user/customer/viewRestaurant";
	}

	
	@RequestMapping(value = "{restaurantId}/viewAddress", method = RequestMethod.GET)
	public String getAddress(@PathVariable("restaurantId") Integer restaurantId, Model model) {
		
		Restaurant restaurant = restaurantService.find(restaurantId);
		if(restaurant==null){
			return "";
		}
		
		Address address = null;
		ArrayList<Address> addressList = new ArrayList<Address>();
		for(Address a : addressService.listAddress()){
			if(a.getRestaurant().getRestaurantId()==restaurant.getRestaurantId()){
				address =a;
				addressList.add(a);
//				break;
			}
			}
//		model.addAttribute("restaurant", restaurant);
		model.addAttribute("address",address);
	    model.addAttribute("addressList",addressList);
		return "user/customer/viewRestaurant";
	}
	
	@RequestMapping(value = "{restaurantId}/viewMenu", method = RequestMethod.GET)
	public String getMenu(@PathVariable("restaurantId") Integer restaurantId, Model model) {
		
		Restaurant restaurant = restaurantService.find(restaurantId);
		if(restaurant==null){
			return "";
		}
		
		List<Menu>menuList = menuService.listMenu();
		Menu menu= null;
		for(Menu m:menuList){
			if(m.getRestaurant().getRestaurantId()==restaurantId){
				menu = m;
				break;
			}
		}
		if(menu==null){
			return"redirect:/user/customer/viewRestaurant";
		}
		ArrayList<Food>foodList = new ArrayList<Food>();
		Food food = null;
		for(Food f: foodService.listFood()){
			if(f.getMenu().getMenuId()==menu.getMenuId()){
				food=f;
				foodList.add(f);
//				break;
			}
		}
		
		model.addAttribute("food",food);
		model.addAttribute("foodList",foodList);
        model.addAttribute("menu",menu);
        model.addAttribute("menuList",menuList);
		return "user/customer/viewRestaurant";
	}

	
	@RequestMapping(value = "{restaurantId}/makeAppointment", method = RequestMethod.GET)
	public String makeAppointment(@PathVariable("restaurantId") Integer restaurantId, Model model) {
		
		Restaurant restaurant = restaurantService.find(restaurantId);
		if(restaurant==null){
			System.out.println("No restaurant found");
			return "";
		}
			
		Appointment appointment = new Appointment();
		appointment.setRestaurant(restaurant);
//		appointmentService.create(appointment);
		
		List<Appointment>appointmentList = appointmentService.listAppointment();
		model.addAttribute("appointment", appointment);
		model.addAttribute("appointmentList",appointmentList);
		model.addAttribute("restaurant", restaurant);
		return  "user/customer/viewRestaurant";
	}

	
	
	@RequestMapping(value = "{restaurantId}/create",method = RequestMethod.POST)
	public @ResponseBody String addAppointment(@PathVariable("restaurantId") Integer restaurantId,
			@ModelAttribute("appointment") Appointment appointment,
			Locale locale, 
			@RequestParam("startTime") String st,
			@RequestParam("endTime") String et,
			@RequestParam("detail") String detail,
			Model model
//			BindingResult result
			) {

//		if (result.hasErrors()) {
//
//			return "user/customer/viewRestaurant";
//		}
		Restaurant restaurant = restaurantService.find(restaurantId);
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		String userName = userDetails.getUsername();
		User user = userAdminService.getUser(userName);
		if (user == null) {
			System.out.println("No user found");
			return "No User!";
		}
		appointment = new Appointment();
		appointment.setUser(user);
		appointment.setRestaurant(restaurant);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
        appointment.setStartTime(st);
        appointment.setEndTime(et);
        appointment.setDetail(detail);
		appointment.setCreateTime(formattedDate);
		appointmentService.create(appointment);
        model.addAttribute("appointment", appointment);
        ArrayList<Appointment>appointmentList = new ArrayList<Appointment>();
        appointmentList.add(appointment);
        model.addAttribute("appointmentList", appointmentList);
		return "Appointment made!";
	}
	

}
