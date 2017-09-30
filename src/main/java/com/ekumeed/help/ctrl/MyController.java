package com.ekumeed.help.ctrl;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MyController {
	
	@RequestMapping(value="/welcome" , method=RequestMethod.GET)
	public String welcomeMsg(){
		return "Welocme to Spring Boot App";
	}
	
	@RequestMapping(value="/getUser",method={RequestMethod.GET,RequestMethod.POST})
	public String getUserName(@RequestParam(value="myName") String Name){
		return "Welcome to my youtube channel EkUmeed Help "+Name;
	}
	
}
