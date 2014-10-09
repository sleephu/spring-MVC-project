package edu.neu.coe.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.neu.coe.service.RoleService;
import edu.neu.coe.service.UserAdminService;

@Controller
@RequestMapping("/admin/manageUsers")
public class UserAdminController {

	@Autowired
	private UserAdminService userService;

	@Autowired
	private RoleService roleService;

	//
	// @RequestMapping( method =RequestMethod.POST)
	// public String manageUser(Map<String,Object> map)
	// {
	// User user = new User();
	// map.put("user", user);
	// map.put("userList", userService.getAllUser());
	// return"admin/manageUsers";
	// }

	// @RequestMapping(value="/user.do", method =RequestMethod.POST)
	// public String doActions(@ModelAttribute User user, BindingResult
	// result,@RequestParam String action, Map<String,Object> map ){
	// // User userResult = new User();
	// // switch (action) {
	// // case "add":
	// // userService.create(user);
	// // userResult = user;
	// // break;
	// // case"edit":
	// // userService.update(user);
	// // userResult =user;
	// // break;
	// // case"delete":
	// // userService.delete(user.getUserId());
	// // userResult = new User();
	// // break;
	// // case"search":
	// // User searchedUser =userService.find(user.getUserId());
	// // userResult=searchedUser !=null? searchedUser: new User();
	// // break;
	// // }
	// // map.put("user", userResult);
	// // map.put("userList", userService.getAllUser());
	// return "admin";
	// }
	//

	@RequestMapping(method = RequestMethod.GET)
	public String getAllUsers(Model model) {

		model.addAttribute("userList", userService.getAllUser());
		return "admin/manageUsers";

	}
	
	@RequestMapping(value="delete/{userId}", method=RequestMethod.GET)
	public String deleteUser(@PathVariable("userId") Integer userId) {
		userService.delete(userId);
		
		return "redirect:/admin/manageUsers";
	}

//	@RequestMapping(value="{userId}/delete",method = RequestMethod.DELETE)
//	public String deleteCustomer(@PathVariable("userId") Integer userId) {
//
//		System.out.println("Deleting!!~~~~~");
//		userService.delete(userId);
//
//		return "redirect:/admin/manageUsers";
//	}
}
