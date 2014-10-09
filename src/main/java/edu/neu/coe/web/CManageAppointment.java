package edu.neu.coe.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.neu.coe.domain.Appointment;
import edu.neu.coe.domain.Food;
import edu.neu.coe.domain.Menu;
import edu.neu.coe.domain.OrderedFood;
import edu.neu.coe.domain.Restaurant;
import edu.neu.coe.domain.User;
import edu.neu.coe.service.AppointmentService;
import edu.neu.coe.service.CustomerService;
import edu.neu.coe.service.FoodService;
import edu.neu.coe.service.OrderedFoodService;
import edu.neu.coe.service.RestaurantService;
import edu.neu.coe.service.UserAdminService;

@Controller
@RequestMapping("/user/customer/manageAppointment")
public class CManageAppointment {
	@Autowired
	UserAdminService userAdminService;

	@Autowired
	RestaurantService restaurantService;

	@Autowired
	CustomerService customerService;

	@Autowired
	AppointmentService appointmentService;

	@Autowired
	FoodService foodService;

	@Autowired
	OrderedFoodService orderedFoodService;


	@RequestMapping(method = RequestMethod.GET)
	public String listAppointments(Model model) {

		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		String userName = userDetails.getUsername();
		User user = userAdminService.getUser(userName);
		if (user == null) {
			System.out.println("No user found");
		}
		Appointment appointment = null;
		ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
		for (Appointment a : appointmentService.listAppointment()) {
			if (a.getUser().getUserId() == user.getUserId()) {
				appointmentList.add(a);
				if (appointment == null) {
					appointment = a;
				}
			}

		}

		model.addAttribute("appointment", appointment);
		model.addAttribute("appointmentList", appointmentList);
		System.out.println(appointmentList.size() + "tttttest");
		return "user/customer/manageAppointment";
	}


	@RequestMapping(value = "delete/{appointmentId}")
	public// @ResponseBody
	String deleteAppointment(
			@PathVariable("appointmentId") Integer appointmentId) {

		System.out.println("Deleting!!~~~~~");

		appointmentService.delete(appointmentId);

		return "redirect:/user/customer/manageAppointment";
		// "Appointment Canceled!";
	}

	// @RequestMapping(value="/{appointmentId}", method=RequestMethod.DELETE)
	// public @ResponseBody String deleteApp(@PathVariable Integer
	// appointmentId) {
	// appointmentService.delete(appointmentId);
	//
	// return "";
	// }

	@RequestMapping(value = "{appointmentId}/orderFood", method = RequestMethod.GET)
	public String orderFood(
			@PathVariable("appointmentId") Integer appointmentId, Model model) {

		Appointment currentAppointment = appointmentService.find(appointmentId);
		if (currentAppointment == null) {
			return "redirect:/user/customer/manageAppointment";
		}
		Restaurant restaurant = currentAppointment.getRestaurant();
		Menu menu = restaurant.getMenu();
		List<Food> foodList = menu.getFoods();
		Food food = null;
		for (Food f : foodList) {
			food = f;
			break;
		}
		model.addAttribute("currentAppointment", currentAppointment);
		model.addAttribute("menu", menu);
		model.addAttribute("food", food);
		model.addAttribute("foodList", foodList);
		// model.addAttribute("orderedFood",orderedFood);
		return "user/customer/manageAppointment";
	}

	@RequestMapping(value = "{appointmentId}/orderFood/{foodId}/ordering", method = RequestMethod.GET)
	public String ordering(@PathVariable("foodId") Integer foodId, Model model,
			@ModelAttribute("currentAppointment") Appointment a) {

		Food food = foodService.find(foodId);
		if (food == null) {
			return "redirect:/user/customer/manageAppointment";
		}

		OrderedFood orderedFood = new OrderedFood();
		orderedFood.setFood(food);
		orderedFood.setAppointment(a);
		ArrayList<OrderedFood> orderedFoodList = new ArrayList<OrderedFood>();
		orderedFoodList.add(orderedFood);
		Menu menu = food.getMenu();
		model.addAttribute("menu", menu);
		model.addAttribute("orderedFood", orderedFood);
		// model.addAttribute("food", food);
		model.addAttribute("currentAppointment", a);
		model.addAttribute("orderedFoodList", orderedFoodList);
		return "user/customer/manageAppointment";
	}

	@RequestMapping(value = "{appointmentId}/orderFood/{foodId}/create", method = RequestMethod.POST)
	public @ResponseBody
	String create(@PathVariable("foodId") Integer foodId, Model model,
			@ModelAttribute("currentAppointment") Appointment a,
			@ModelAttribute("orderedFood") OrderedFood orderedFood,
			BindingResult result) {

		if (result.hasErrors()) {
			return "some error";
		}
		// orderedFood = new OrderedFood();
		Food food = foodService.find(foodId);
		if (food == null) {
			return "redirect:/user/customer/manageAppointment";
		}

		orderedFood.setAppointment(a);
		orderedFood.setFood(food);
		ArrayList<OrderedFood> orderedFoodList = new ArrayList<OrderedFood>();
		orderedFoodList.add(orderedFood);
		orderedFoodService.create(orderedFood);

		model.addAttribute("orderedFood", orderedFood);
		model.addAttribute("orderedFoodList", orderedFoodList);

		return "Dish Added!";
	}

	@RequestMapping(value = "{appointmentId}/viewOrderedFood", method = RequestMethod.GET)
	public String vieworderFood(
			@PathVariable("appointmentId") Integer appointmentId, 
			
			Model model) {

		Appointment app = appointmentService.find(appointmentId);
		if (app == null) {
			return "null";
		}

		OrderedFood currentOrderedFood = null;
		ArrayList<OrderedFood> currentOrderedFoodList = new ArrayList<OrderedFood>();

		for (OrderedFood f : orderedFoodService.listFood()) {
			if (f.getAppointment().getAppointmentId() == app.getAppointmentId()) {
				currentOrderedFoodList.add(f);
				currentOrderedFood = f;
				currentOrderedFood.setAppointment(app);
				
			}
		}

		model.addAttribute("app", app);
		model.addAttribute("currentOrderedFood", currentOrderedFood);
		model.addAttribute("currentOrderedFoodList", currentOrderedFoodList);

		return "user/customer/manageAppointment";
	}

	@RequestMapping(value = "viewOrderedFood/${orderedFood.foodId}/delete", method = RequestMethod.GET)
	public String deleteOrderedFood(@PathVariable("foodId") Integer foodId) {

		orderedFoodService.delete(foodId);
		System.out.println("DeletingFFFFFFFood!!~~~~~");
		return "redirect:/user/customer/manageAppointment";
	}

}
