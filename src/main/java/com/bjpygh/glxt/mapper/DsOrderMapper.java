package com.bjpygh.glxt.mapper;

import java.util.List;
import java.util.Map;

import com.bjpygh.glxt.entity.DsOrder;

public interface DsOrderMapper {

	public List<DsOrder> getOrderPay(DsOrder dsorder);
	public List<DsOrder> getOrderGet(DsOrder dsorder);
	public List<DsOrder> getOrderSign(DsOrder dsorder);
	public List<DsOrder> getOrderFinish(DsOrder dsorder);
	public List<DsOrder> getOrders(DsOrder dsorder);
	public void changeStatus(Map<String, String> map);
}
