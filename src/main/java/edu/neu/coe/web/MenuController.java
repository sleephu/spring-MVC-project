package edu.neu.coe.web;

import java.util.ArrayList;
import java.util.List;

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

import edu.neu.coe.domain.Food;
import edu.neu.coe.domain.Menu;
import edu.neu.coe.domain.Restaurant;
import edu.neu.coe.domain.User;
import edu.neu.coe.service.FoodService;
import edu.neu.coe.service.MenuService;
import edu.neu.coe.service.RestaurantService;
import edu.neu.coe.service.UserAdminService;

@Controller
@RequestMapping("/user/restaurant/manageMenu")
public class MenuController {

	@Autowired
	private MenuService menuService;

	@Autowired
	private RestaurantService restaurantService;

	@Autowired
	private UserAdminService userAdminService;

	@Autowired
	private FoodService foodService;

	@RequestMapping(method = RequestMethod.GET)
	public String addMeunu(Model model) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		String userName = userDetails.getUsername();
		User user = userAdminService.getUser(userName);
		if (user == null) {
			System.out.println("No user found");

		}
		Restaurant restaurant = null;
		
		List<Restaurant> restaurants = restaurantService.ListRestaurants();
		for (Restaurant rt : restaurants) {
			if (rt.getUser().getUserId() == user.getUserId()) {
				restaurant = rt;
				break;
			}
		}
		if (restaurant == null) {
			model.addAttribute("restaurant",restaurant);
			return "user/restaurant/manageMenu";
		}

		Menu exsitedMenu = null;
		
		List<Menu> menus = menuService.listMenu();
		for (Menu m : menus) {
			if (m.getRestaurant().getRestaurantId() == restaurant
					.getRestaurantId()) {
				exsitedMenu = m;
				break;
			}
		}
	
		if(exsitedMenu==null){
			model.addAttribute("menu", new Menu());
			model.addAttribute("restaurant",restaurant);
			return"user/restaurant/manageMenu";
		}
		Food exsitedfood = null;

		ArrayList<Food> menuFood = new ArrayList<Food>();
		for(Food f : foodService.listFood()){
			if(f.getMenu().getMenuId()==exsitedMenu.getMenuId()){
				exsitedfood =f;
				menuFood.add(f);
//				break;
			}
		}
//		if(exsitedfood==null){
//			
//			return"user/restaurant/manageMenu";
//		}
		model.addAttribute("menu", new Menu());
		model.addAttribute("exsitedfood", exsitedfood);
		model.addAttribute("menuFood", menuFood);
		model.addAttribute("restaurant",restaurant);
		model.addAttribute("exsitedMenu", exsitedMenu);
		return "user/restaurant/manageMenu";
	}

	@RequestMapping(value = "updateMenu", method = RequestMethod.POST)
	public String addMenu(
			Model model,
			@RequestParam("menuName") String menuName
//			@RequestParam("foodName") String foodName,
//			@RequestParam("price") double price
			) {

		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		String userName = userDetails.getUsername();
		User user = userAdminService.getUser(userName);
		if (user == null) {
			System.out.println("No user found");

		}
		Restaurant restaurant = null;
		
		List<Restaurant> restaurants = restaurantService.ListRestaurants();
		for (Restaurant rt : restaurants) {
			if (rt.getUser().getUserId() == user.getUserId()) {
				restaurant = rt;
				break;
			}
		}
		if (restaurant == null) {
			return "user/restaurant/manageMenu";
		}

		Menu menu = null;
		
		List<Menu> menus = menuService.listMenu();
		for (Menu m : menus) {
			if (m.getRestaurant().getRestaurantId() == restaurant
					.getRestaurantId()) {
				menu = m;
				menu.setMenuName(menuName);
				menuService.updateMenu(menu);
				break;
			}
		}
		
		if(menu==null){
			menu = new Menu();
			menu.setMenuName(menuName);
			menu.setRestaurant(restaurant);
			menuService.createMenu(menu);		
		}
		
//		 List<Food> foods = foodService.listFood();
//	        ArrayList<Food> menuFood = new ArrayList<>();
//	        Food food = new Food();
//			food.setFoodName(foodName);
//			food.setPrice(price);
//			food.setMenu(menu);
//	        foodService.create(food);
//	        
//	        // food in the menu ---> useless
//	        for(Food f: foods){
//	        	if(f.getMenu().getMenuId()==menu.getMenuId()){
//	        		menuFood.add(f);
//	        	}
//	        }
        model.addAttribute("restaurant", restaurant);
		model.addAttribute("menu", menu);
//		model.addAttribute("food",food);
//		model.addAttribute("foodList", menuFood);

		return "user/restaurant/manageMenu";
	}
	

	
	
	@RequestMapping(value = "{menuId}/addFood", method = RequestMethod.GET)
	public String makeAppointment(@PathVariable("menuId") Integer menuId, Model model) {
		
		Menu exsitedMenu= menuService.getMenu(menuId);
		if(exsitedMenu==null){
			System.out.println("No restaurant found");
			return "";
		}
			
		Food food = new Food();
		food.setMenu(exsitedMenu);;

		List<Food>foodList = foodService.listFood();
		
		model.addAttribute("food", food);
		model.addAttribute("foodList",foodList);
		model.addAttribute("exsitedMenu", exsitedMenu);
		return  "user/restaurant/manageMenu";
	}

	
	
	@RequestMapping(value = "{menuId}/create",method = RequestMethod.POST)
	public @ResponseBody String addFood(@PathVariable("menuId") Integer menuId,
			@ModelAttribute("food") Food food,
			@RequestParam("foodName") String foodName,
			@RequestParam("price") double price,
			Model model
//			BindingResult result
			) {


		Menu menu = menuService.getMenu(menuId);

		
		if(menu==null){
			return"No menu Yet";	
		}
		
	    food = new Food();
		food.setMenu(menu);
		
        food.setFoodName(foodName);
        food.setPrice(price);
        foodService.create(food);
        model.addAttribute("food", food);

		return "Food Added!";
	}

}
