package com.bjpygh.glxt.mapper;

import java.util.List;
import java.util.Map;

import com.bjpygh.glxt.entity.DsOrder;

public interface DsOrderMapper {

	public List<DsOrder> getOrderByRealName(String realname);
	public void changeStatus(Map<String, String> map);
}
