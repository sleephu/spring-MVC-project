package edu.neu.coe.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.neu.coe.domain.Appointment;
import edu.neu.coe.domain.OrderedFood;
import edu.neu.coe.domain.Restaurant;
import edu.neu.coe.domain.User;
import edu.neu.coe.service.AddressService;
import edu.neu.coe.service.AppointmentService;
import edu.neu.coe.service.CustomerService;
import edu.neu.coe.service.FoodService;
import edu.neu.coe.service.MenuService;
import edu.neu.coe.service.OrderedFoodService;
import edu.neu.coe.service.RestaurantService;
import edu.neu.coe.service.UserAdminService;

@Controller
@RequestMapping("/user/restaurant/manageCustomer")
public class ViewCustomerAppointmentController {
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
	
	@Autowired 
	OrderedFoodService orderedFoodService;


	@RequestMapping(method = RequestMethod.GET)
	public String listCustomerApp(Model model) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		String userName = userDetails.getUsername();
		User user = userAdminService.getUser(userName);
		if (user == null) {
			System.out.println("No user found");
		}
		Restaurant restaurant = null;
		for(Restaurant r: restaurantService.ListRestaurants()){
			if(r.getUser().getUserId()==user.getUserId()){
				restaurant =r;
				break;
			}
			
		}
		if(restaurant ==null){
			return "user/restaurant/manageCustomer";
		}
		
		ArrayList<Appointment>appointmentList =new ArrayList<Appointment>();
		Appointment appointment = null;
		for(Appointment a: appointmentService.listAppointment()){
			if(a.getRestaurant().getRestaurantId()==restaurant.getRestaurantId()){
				appointment =a;
				appointmentList.add(a);
//				break;
			}
		}
		
		
        model.addAttribute("appointment",appointment);
        model.addAttribute("appointmentList",appointmentList);
		model.addAttribute("restaurant", restaurant);
		model.addAttribute("restaurantList", restaurantService.ListRestaurants());

		return "user/restaurant/manageCustomer";
	}

	
	
	@RequestMapping(value="${appointmentId}/viewOrder",method = RequestMethod.GET)
	public String viewDetail(@PathVariable("appointmentId") Integer appointmentId,Model model) {
		
		Appointment currentAppointment = appointmentService.find(appointmentId);
		if (currentAppointment == null) {
			return "";
		}
		OrderedFood orderedFood = null;
		ArrayList<OrderedFood>orderedFoodList = new ArrayList<OrderedFood>();
//		if(orderedFood ==null){
//			return "user/restaurant/manageCustomer";
//		}
		
		for(OrderedFood o: orderedFoodService.listFood()){
			if(o.getAppointment().getAppointmentId()==currentAppointment.getAppointmentId()){
				orderedFood=o;
				orderedFoodList.add(o);	
			}
		}
		
		
//      model.addAttribute("currentAppointment",currentAppointment);
		model.addAttribute("orderedFood", orderedFood);
		model.addAttribute("orderedFoodList", orderedFoodList);

		return "user/restaurant/manageCustomer";
	}


}
