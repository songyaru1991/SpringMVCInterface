package com.foxlink.realtime.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.foxlink.realtime.service.IEmpService;
import com.foxlink.realtime.service.IAccountService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/Account")
public class AccountController {
	
	private static Logger logger=Logger.getLogger(AccountController.class);
	private IAccountService accountService;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView showMainPage(HttpSession session){
		ModelAndView model = new ModelAndView();
		model.addObject("username", session.getAttribute("username"));
		
	    model.setViewName("index");
	    return model;
	}
	
	@RequestMapping(value="/ShowAllAccount",method=RequestMethod.GET)
	public String ShowAllAccountPage(){
		return "AccountManage";
	}
		
	@RequestMapping(value = "/AllAccount.show", method = RequestMethod.GET)
	public @ResponseBody String ShowAllUsers(){
		String jsonResults="";
		try{
			ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");//ClassPathXmlApplicationContext[只能读放在web-info/classes目录下的配置文件]
			accountService = (IAccountService) context.getBean("accountService");
		    jsonResults=new Gson().toJson(accountService.FindALLUsers());
		}catch(Exception ex){
			logger.error(ex);
			JsonObject exception=new JsonObject();
			exception.addProperty("StatusCode", "500");
			exception.addProperty("ErrorMessage", "取得實時工時賬號列表失敗，原因："+ex.toString());
			jsonResults=exception.toString();
		}
		return jsonResults;
	}
	
	@SuppressWarnings("resource")
	@RequestMapping(value = "/AllEmps.show", method = RequestMethod.GET)
	public @ResponseBody String ShowAllEmps() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:Beans.xml");
		IEmpService  message = (IEmpService) context.getBean("empService");
		String jsonResults=new Gson().toJson(message.FindAllRecords());
		return jsonResults;
	}
	
	@RequestMapping(value="/ShowText.show",method=RequestMethod.GET)
	public @ResponseBody String ShowText() {
		return "實時工時系統";		
	}
	
}
