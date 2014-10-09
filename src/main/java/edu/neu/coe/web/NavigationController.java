package edu.neu.coe.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class NavigationController {

	
	@RequestMapping("/admin")
	public ModelAndView defaultAfterLogin(HttpServletRequest request) {
		//
//		request.get
		System.out.println("admin!!!!!!!!!!!!!");
		return new ModelAndView("admin/index");
	}

	@RequestMapping("/user/customer")
	public ModelAndView customerAfterLogin(HttpServletRequest request) {
//		if (request.isUserInRole("ROLE_CUSTOMER")) {
//			return "redirect:/customer/index";
//		}
//		return "redirect:/";
		return new ModelAndView("user/customer/index");
	}

	@RequestMapping("/user/restaurant")
	public ModelAndView restaurantAfterLogin(HttpServletRequest request) {
//		if (request.isUserInRole("ROLE_RESTAURANT")) {
//			return "redirect:/restaurant/index";
//		}
//		return "redirect:/";
		return new ModelAndView("user/restaurant/index");
	}
	@RequestMapping(value="/accessdenied", method=RequestMethod.GET)
	 public ModelAndView accessDenied( HttpServletRequest request, HttpServletResponse response) 
    {
		ModelAndView model = new ModelAndView("denied");
		model.addObject("message", "Permission-Access Denied,please login again");
 
		return model;
    }
	
}
