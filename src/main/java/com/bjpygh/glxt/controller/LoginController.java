package com.bjpygh.glxt.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjpygh.glxt.entity.Employee;
import com.bjpygh.glxt.entity.Status;
import com.bjpygh.glxt.utils.VerifyCodeUtils;
import com.google.gson.Gson;

@Controller
public class LoginController {

	@RequestMapping(value="/login", method=RequestMethod.POST, produces="text/html;charset=UTF-8")
	@ResponseBody
	public String Login(Employee employee, HttpSession session) {
		String verifyCode = (String) session.getAttribute("verifyCode");
		Status status = new Status();
		if(employee.getAccount()!=null){
			if(employee.getCode().equals(verifyCode)){
				if(employee.getAccount().equals("201707060001")&&employee.getPassword().equals("201701")){
					status.setStatus(0);	
					status.setMsg("登录成功");
					session.setAttribute("login", "true");
					return new Gson().toJson(status);
				}else{
					status.setStatus(-11);
					status.setMsg("登录失败，账号或密码错误");
					return new Gson().toJson(status);
				}
			}else{
				status.setStatus(-10);
				status.setMsg("登录失败，验证码错误");
				return new Gson().toJson(status);
			}
		}else{
			status.setStatus(-20);
			status.setMsg("登录失败，请输入正确信息");
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
	
	@RequestMapping(value = "/isLogin", method=RequestMethod.POST, produces="text/html;charset=UTF-8")
	@ResponseBody
	public String isLogin(HttpSession session){
		Status status = new Status();
		if(session.getAttribute("login")!=null&&session.getAttribute("login").equals("true")){
			status.setStatus(0);
			status.setMsg("已登录");
			return new Gson().toJson(status);
		}else{
			status.setStatus(100);
			status.setMsg("未登录");
			return new Gson().toJson(status);
		}
	}
}
