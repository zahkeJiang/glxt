package com.bjpygh.glxt.controller;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

@Controller
public class BaseController{

	public boolean isLogin(HttpSession session){
		
		if(!(session.getAttribute("login").equals("true"))){
			return true;
		}else{
			return false;
		}
		
	}
}
