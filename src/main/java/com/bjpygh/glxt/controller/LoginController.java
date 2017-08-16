package com.bjpygh.glxt.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjpygh.glxt.entity.Employee;
import com.bjpygh.glxt.entity.Status;
import com.bjpygh.glxt.utils.VerifyCodeUtils;
import com.google.gson.Gson;

@Controller
public class LoginController {

	@RequestMapping(value="/login")
	@ResponseBody
	public String Login(Employee employee) {
		String account = employee.getAccount();
		String password = employee.getPassword();
		Status status = new Status();
		if(account.equals("201707060001")&&password.equals("201701")){
			status.setStatus(0);
			return new Gson().toJson(status);
		}else{
			status.setStatus(100);
			return new Gson().toJson(status);
		}
	}
	
	
	@RequestMapping(value="/verifi_code")
	public void getVerifiCode(HttpServletRequest request,HttpServletResponse response) throws IOException {
		 response.setHeader("Pragma", "No-cache");  
	        response.setHeader("Cache-Control", "no-cache");  
	        response.setDateHeader("Expires", 0);  
	        response.setContentType("image/jpeg");  
	          
	        //鐢熸垚闅忔満瀛椾覆  
	        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);  
	        //瀛樺叆浼氳瘽session  
	        HttpSession session = request.getSession(true);  
	        //鍒犻櫎浠ュ墠鐨�
	        session.removeAttribute("verifyCode");
	        session.setAttribute("verifyCode", verifyCode.toLowerCase());  
	        //鐢熸垚鍥剧墖  
	        int w = 100, h = 30;  
	        try {
				VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	}
}
