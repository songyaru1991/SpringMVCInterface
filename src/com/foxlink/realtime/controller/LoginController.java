package com.foxlink.realtime.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.foxlink.realtime.service.IEmpService;
import com.foxlink.realtime.service.IUserService;
import com.google.gson.Gson;

@Controller
//@RequestMapping("/login")
public class LoginController {

	
	@RequestMapping(value = "/AllUsers.show", method = RequestMethod.GET)
	public @ResponseBody String ShowAllUsers(){
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
		IUserService  message = (IUserService) context.getBean("userService");
		String jsonResults=new Gson().toJson(message.FindALLUsers());
		return jsonResults;
	}
	
	@RequestMapping(value = "/AllEmps.show", method = RequestMethod.GET)
	public @ResponseBody String ShowAllEmps() {
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
		IEmpService  message = (IEmpService) context.getBean("empService");
		String jsonResults=new Gson().toJson(message.FindAllRecords());
		return jsonResults;
	}
	
	@RequestMapping(value="/ShowText.show",method=RequestMethod.GET)
	public @ResponseBody String ShowText() {
		return "實時工時系統";
		
	}
}
