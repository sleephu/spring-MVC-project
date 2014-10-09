package edu.neu.coe.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.neu.coe.domain.Role;
import edu.neu.coe.domain.User;
import edu.neu.coe.service.RoleService;
import edu.neu.coe.service.UserAdminService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	private UserAdminService userService;

	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}
	
	@RequestMapping(value = "/coe/home", method = RequestMethod.GET)
	public String logout( Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);

//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
//				DateFormat.LONG, locale);
//
//		String formattedDate = dateFormat.format(date);
        String message ="successfully loggedOut";
		model.addAttribute("message",message);

		return "home";
	}

	@RequestMapping(value = "/news", method = RequestMethod.GET)
	public @ResponseBody
	String byPath() {
		return "it is news";
	}

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public @ResponseBody
	String byPathAbout() {
		return "It is a platform for customers and restaurants to save time for a delicious meal!";
	}





	@RequestMapping(value = "/registerC", method = RequestMethod.GET)
	public String registerC(Model model) {
//		// model.addAttribute("user", new User());
//		// model.addAttribute("userList",userService.getAllUser());
		model.addAttribute("user", new User());
//		// model.addAttribute("role",new Role());
//		// System.out.println("user");
//		// return new ModelAndView("user/registerC");
		return "registerC";

	}

	@RequestMapping(value = "registerC", method = RequestMethod.POST)
	public String signUpC(
			@ModelAttribute("user") User user,
	// @RequestParam("userName") String userName,
	// @RequestParam("password") String password,
	// @RequestParam("role") String role,
	// @ModelAttribute("role") Role role,
			Model model, BindingResult result) {
      
		for(User u: userService.getAllUser()){
			if(user.getUserName().equals(u.getUserName())){
				return"registerFailed";
			}
			
		}
		
		if (result.hasErrors()) {
			System.out.println("error" + result.toString());
			model.addAttribute("error", "true");
			return "registerC";
		}

		Role customerRole = roleService.getRole(2);
	
		user.setRole(customerRole);
		userService.create(user);

		model.addAttribute("user", user);

		System.out.println("User Name:" + user.getUserName() + "Password:"
				+ user.getPassword() + "Role" + user.getRole());
		return "registerC";

	}

	@RequestMapping(value = "/registerE", method = RequestMethod.GET)
	public String registerE(Model model) {
		// model.addAttribute("user", new User());
		// model.addAttribute("userList",userService.getAllUser());
		model.addAttribute("user", new User());
		// model.addAttribute("role",new Role());
		// System.out.println("user");
		// return new ModelAndView("user/registerE");
		return "registerE";
		// return "user/register";
	}

	@RequestMapping(value = "registerE", method = RequestMethod.POST)
	public String signUpE(
			@ModelAttribute("user") User user,
	// @RequestParam("userName") String userName,
	// @RequestParam("password") String password,
	// @RequestParam("role") String role,
	// @ModelAttribute("role") Role role,
			Model model, 
			BindingResult result) {
		for(User u: userService.getAllUser()){
			if(user.getUserName().equals(u.getUserName())){
				return"registerFailed";
			}
			
		}
		
		if (result.hasErrors()) {
			System.out.println("error" + result.toString());
//			model.addAttribute("error", "true");
			return "registerE";
		}

		Role restaurantRole = roleService.getRole(3);
		
		user.setRole(restaurantRole);
		userService.create(user);

		model.addAttribute("user", user);

		System.out.println("User Name:" + user.getUserName() + "Password:"
				+ user.getPassword() + "Role" + user.getRole());
		return "registerE";

	}
	

	@RequestMapping(value="/user/restaurant/index", method = RequestMethod.GET)
	public ModelAndView printWelcome(ModelMap model) {
 
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name = user.getUserName();
	
		model.addAttribute("userName", name);
//		model.addAttribute("message", "Spring Security login + database example");
		System.out.println("Hello:"+name);
		return new ModelAndView( "user/restaurant/index");
 
	}
}
