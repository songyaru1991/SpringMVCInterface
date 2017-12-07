package com.foxlink.realtime.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;


@Controller
//@RequestMapping("/login")
public class LoginController implements ServletContextAware {
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		// TODO Auto-generated method stub
		
	}
	
	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView defaultPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Login Form - Database Authentication");
		model.addObject("message", "This is default page!");
		model.addObject("user", GetPrincipal());  
		model.setViewName("hello");
		return model;

	}
	
	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {

	  ModelAndView model = new ModelAndView();
	  if (error != null) {
		model.addObject("error", "Invalid username and password!");
	  }
	  
	  if (logout != null) {
		model.addObject("msg", "You've been logged out successfully.");
	  }
		model.setViewName("Login");
	  
	  return model;
	}
	
	   @RequestMapping(value = "/index", method = RequestMethod.GET)  
	    public String homePage(HttpSession session) {  
		   session.setAttribute("username", GetPrincipal());  
	        return "index";  
	    } 
	
	@RequestMapping(value="/403",method=RequestMethod.GET)
	public ModelAndView AccessDenied(){
		ModelAndView model = new ModelAndView();
		//check if user is login
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		  if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();	
			model.addObject("username", userDetail.getUsername());
		  }
			
		  model.setViewName("403");
		  return model;
	}
	
	 private String GetPrincipal(){
	        String userName = null;
	        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 
	        if (principal instanceof UserDetails) {
	            userName = ((UserDetails)principal).getUsername();
	        } else {
	            userName = principal.toString();
	        }
	        return userName;
	    }

}
