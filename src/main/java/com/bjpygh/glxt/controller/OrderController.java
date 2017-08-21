package com.bjpygh.glxt.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjpygh.glxt.dao.DsInfoDao;
import com.bjpygh.glxt.dao.DsOrderDao;
import com.bjpygh.glxt.entity.DsInformation;
import com.bjpygh.glxt.entity.DsOrder;
import com.bjpygh.glxt.entity.Status;
import com.google.gson.Gson;

@Controller
@RequestMapping(value="/dsOrder")
public class OrderController {

	
	//获取已支付的订单
	@RequestMapping(value="/payed", method=RequestMethod.POST, produces="text/html;charset=UTF-8")
	@ResponseBody
	public String payed(DsOrder dsOrder) {
		DsOrderDao dsOrderDao = new DsOrderDao();
		Status status = new Status();
		List<DsOrder> order = dsOrderDao.getOrderPay(dsOrder);
		if(order!=null){
			status.setStatus(0);
			status.setMsg("获取成功");
			status.setData(order);
			return new Gson().toJson(status);
		}else{
			status.setStatus(-10);
			status.setMsg("查询信息不存在");
			return new Gson().toJson(status);
		}
		
	}
	
	//获取收到材料的订单
	@RequestMapping(value="/getmat", method=RequestMethod.POST, produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getMat(DsOrder dsOrder) {
		DsOrderDao dsOrderDao = new DsOrderDao();
		Status status = new Status();
		List<DsOrder> order = dsOrderDao.getOrderGet(dsOrder);
		if(order!=null){
			status.setStatus(0);
			status.setMsg("获取成功");
			status.setData(order);
			return new Gson().toJson(status);
		}else{
			status.setStatus(-10);
			status.setMsg("查询信息不存在");
			return new Gson().toJson(status);
		}	
	}
	
	//获取已完成报名的订单
	@RequestMapping(value="/sign", method=RequestMethod.POST, produces="text/html;charset=UTF-8")
	@ResponseBody
	public String Sign(DsOrder dsOrder) {
		DsOrderDao dsOrderDao = new DsOrderDao();
		Status status = new Status();
		List<DsOrder> order = dsOrderDao.getOrderSign(dsOrder);
		if(order!=null){
			status.setStatus(0);
			status.setMsg("获取成功");
			status.setData(order);
			return new Gson().toJson(status);
		}else{
			status.setStatus(-10);
			status.setMsg("查询信息不存在");
			return new Gson().toJson(status);
		}	
	}
	
	//获取返还材料的订单
	@RequestMapping(value="/finish", method=RequestMethod.POST, produces="text/html;charset=UTF-8")
	@ResponseBody
	public String Finish(DsOrder dsOrder) {
		DsOrderDao dsOrderDao = new DsOrderDao();
		Status status = new Status();
		List<DsOrder> order = dsOrderDao.getOrderFinish(dsOrder);
		if(order!=null){
			status.setStatus(0);
			status.setMsg("获取成功");
			status.setData(order);
			return new Gson().toJson(status);
		}else{
			status.setStatus(-10);
			status.setMsg("查询信息不存在");
			return new Gson().toJson(status);
		}	
	}
	
	//获取返还材料的订单
	@RequestMapping(value="/all", method=RequestMethod.POST, produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getAll(DsOrder dsOrder) {
		DsOrderDao dsOrderDao = new DsOrderDao();
		Status status = new Status();
		List<DsOrder> order = dsOrderDao.getOrders(dsOrder);
		if(order!=null){
			status.setStatus(0);
			status.setMsg("获取成功");
			status.setData(order);
			return new Gson().toJson(status);
		}else{
			status.setStatus(-10);
			status.setMsg("查询信息不存在");
			return new Gson().toJson(status);
		}	
	}
	
}
