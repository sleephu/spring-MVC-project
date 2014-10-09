package edu.neu.coe.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.neu.coe.domain.Address;
import edu.neu.coe.domain.Restaurant;
import edu.neu.coe.domain.User;
import edu.neu.coe.service.AddressService;
import edu.neu.coe.service.RestaurantService;
import edu.neu.coe.service.UserAdminService;

@Controller
@RequestMapping("/user")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;

	@Autowired
	UserAdminService userAdminService;

	@Autowired
	AddressService addressService;

	// @RequestMapping(value="user/restaurant", method = RequestMethod.GET)
	// public ModelAndView printWelcome(ModelMap model) {
	//
	// User user =
	// (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	// String name = user.getUserName();
	//
	// model.addAttribute("userName", name);
	// // model.addAttribute("message",
	// "Spring Security login + database example");
	// System.out.println("Hello:"+name);
	// return new ModelAndView( "user/restaurant/index.jsp");
	//
	// }
	@RequestMapping(value = "restaurant/editProfile", method = RequestMethod.GET)
	public ModelAndView editProfile() {

		return new ModelAndView("user/restaurant/editProfile");
	}

	@RequestMapping(value = "restaurant/updateProfile", method = RequestMethod.POST)
	public String addRestaurant(Model model,
//			Principal principal,
			@RequestParam("restaurantName") String restaurantName,
			@RequestParam("telephoneNo") String telephoneNo,
			@RequestParam("details") String details,
//			@RequestParam String action,
			@RequestParam("country") String country,
			@RequestParam("state") String state,
			@RequestParam("city") String city,
			@RequestParam("street") String street,
			@RequestParam("zipCode") String zipCode) {

		UserDetails userDetails = 
				(UserDetails)SecurityContextHolder.getContext()
			    .getAuthentication().getPrincipal();
		String userName =userDetails.getUsername();
//		User currentUser =null;
//		for(User user: userAdminService.getAllUser()){
//			if (user.getUserName().equals(userName)) {
//				currentUser =user;
//				break;
//			}
//		}
		User user = userAdminService.getUser(userName);
		if(user==null){
			System.out.println("No user found");
		}
		Restaurant restaurant = new Restaurant();
		restaurant.setRestaurantName(restaurantName);
		restaurant.setTelephone(telephoneNo);
		restaurant.setDetail(details);
	
		restaurant.setUser(user);
		Address ad = new Address();
		ad.setCountry(country);
		ad.setCity(city);
		ad.setState(state);
		ad.setStreet(street);
		ad.setZipCode(zipCode);
		
		// restaurantService.create(restaurant);
//		switch (action) {
//		case "update":

			// if(result.hasErrors()){
			//
			// return"/restaurant/editProfile";
			// }
		 List<Restaurant>restaurants = restaurantService.ListRestaurants();
		 for(Restaurant rt: restaurants){
			 if(rt.getUser().getUserId()==user.getUserId()){
				restaurant =rt;
				restaurantService.update(restaurant);
				break;
			 }
		 }
			restaurantService.create(restaurant);
//			userAdminService.update(user);
			ad.setRestaurant(restaurant);
			addressService.create(ad);
			model.addAttribute("restaurant", restaurant);
			model.addAttribute("restaurantList",
					restaurantService.ListRestaurants());
		
		return "user/restaurant/editProfile";
	}

	@RequestMapping(value = "/restaurant/editAddress", method = RequestMethod.GET)
	public String editAddress(Map<String, Object> map,
			@PathVariable Integer restaurantId) {
		User user = new User();
		map.put("user", user);
		// map.put("addressList", userService.getAllUser());
		return "redirect:/manageMenu";
	}

//	@RequestMapping(value = "/{restaurant}/editProfile", method = RequestMethod.POST)
//	public String manageAddress(Map<String, Object> map,
//			@PathVariable Integer restaurantId) {
//		User user = new User();
//		map.put("user", user);
//		// map.put("addressList", userService.getAllUser());
//		return "redirect:/manageMenu";
//	}

//	@RequestMapping(method=RequestMethod.GET)
//	public String listRestaurant(Model model) {
//		model.addAttribute("restaurant", new Restaurant());
//		model.addAttribute("restaurantList", restaurantService.ListRestaurants());
//		
//		return "books";
//	}
//	
	
	
	
	
}
