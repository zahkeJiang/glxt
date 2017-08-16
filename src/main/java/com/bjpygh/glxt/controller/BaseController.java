package com.bjpygh.glxt.controller;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

@Controller
public class BaseController{

	public String LoginStatus(HttpSession session){
		
		if(!(boolean) session.getAttribute("loginstatus")){
			return "index";
		}
		return null;
	}
}
