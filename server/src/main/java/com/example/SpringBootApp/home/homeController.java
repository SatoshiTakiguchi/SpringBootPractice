package com.example.SpringBootApp.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class homeController {

    @RequestMapping("/")
	public String getIndex() {
		return "home.html";
	}
	@RequestMapping("/str")
	@ResponseBody
	public String test(){
		return "helloworld";
	}

}
