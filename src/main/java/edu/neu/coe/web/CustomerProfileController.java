package edu.neu.coe.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import edu.neu.coe.domain.Customer;
import edu.neu.coe.domain.User;
import edu.neu.coe.service.CustomerService;
import edu.neu.coe.service.UserAdminService;

@Controller
@RequestMapping("/user/customer/editProfile")
public class CustomerProfileController {
	@Autowired
	UserAdminService userAdminService;

	@Autowired
	CustomerService customerService;

	
	@RequestMapping(method = RequestMethod.POST)
	public String addCustomer(
			@Valid Customer customer,
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("gender") String gender,
			@RequestParam("telephoneNo") String telephoneNo,
			@RequestParam("email") String email,
			
			Model model) {

//		if (result.hasErrors()) {
//
//			return "user/customer/editProfile";
//		}
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		String userName = userDetails.getUsername();
		User user = userAdminService.getUser(userName);
		if (user == null) {
			System.out.println("No user found");
		}
		 customer = new Customer();
		
		List<Customer> customers = customerService.listCustomer();
		for(Customer c: customers){
			if(c.getUser().getUserId()==user.getUserId()){
				customer =c;
				customerService.update(customer);
				break;
			}
			
		}
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmail(email);
		customer.setGender(gender);
		customer.setTelephoneNo(telephoneNo);
		customer.setUser(user);
		customerService.create(customer);
	    model.addAttribute("customer", customer);
		return "user/customer/editProfile";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listCustomer(Model model) {

//		UserDetails userDetails = (UserDetails) SecurityContextHolder
//				.getContext().getAuthentication().getPrincipal();
//		String userName = userDetails.getUsername();
//		User user = userAdminService.getUser(userName);
//		if (user == null) {
//			System.out.println("No user found");
//		}
//		Customer customer = null;
//		List<Customer> customers = customerService.listCustomer();
//		for(Customer c: customers){
//			if(c.getUser().getUserId()==user.getUserId()){
//				customer =c;
//				customerService.update(customer);
//				break;
//			}
//			
//		}
		
		
		model.addAttribute("customer", new Customer());
		model.addAttribute("customerList", customerService.listCustomer());

		return "user/customer/editProfile";
	}
	
	

	
	@RequestMapping(value = "{customerId}", method = RequestMethod.GET)
	public String getCustomer(@PathVariable Integer customerId, Model model) {
		model.addAttribute("customer", customerService.find(customerId));

		return "user/customer/editProfile";
	}


	@RequestMapping(value = "delete/{customerId}")
	public 
	String deleteCustomer(@PathVariable("customerId") Integer customerId) {
		
		System.out.println("Deleting!!~~~~~");
		customerService.delete(customerId);

		return "redirect:/user/customer/editProfile";
	}

}
