package com.bjpygh.glxt.dao;

import com.bjpygh.glxt.entity.DsOrder;
import com.google.gson.Gson;

public class Main {

	public static void main(String[] args){
		DsOrder dsOrder = new DsOrder();
		dsOrder.setAddress("北京");
		
		DsOrderDao dsOrderDao = new DsOrderDao();
		System.out.println(new Gson().toJson(dsOrderDao.getOrderPay(dsOrder)));
	}
}
