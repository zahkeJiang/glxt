package com.bjpygh.glxt.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjpygh.glxt.dao.DsInfoDao;
import com.bjpygh.glxt.dao.DsPackageDao;
import com.bjpygh.glxt.entity.DsInformation;
import com.bjpygh.glxt.entity.Status;
import com.google.gson.Gson;

@Controller
@RequestMapping(value="/dsInfo")
public class DsInfoController {

	//删除驾校信息
	@RequestMapping(value="/delete", method=RequestMethod.POST, produces="text/html;charset=UTF-8")
	@ResponseBody
	public String deleteDsInfo(String[] dsname) {
		 DsInfoDao dsInfoDao = new DsInfoDao();
		 DsPackageDao packageDao = new DsPackageDao();
		 Status status = new Status();
		 if(dsname!=null){
			 for(int i=0;i<dsname.length;i++){
				 dsInfoDao.deleteDsInfo(dsname[i]);
				 packageDao.deleteDsPackages(dsname[i]);
			 }
			 status.setStatus(0);
			 status.setMsg("删除成功");
			 return new Gson().toJson(status);
		 }else{
			 status.setStatus(-10);
			 status.setMsg("提交数据为空");
			 return new Gson().toJson(status); 
		 }
	}
	
	//插入驾校信息
	@RequestMapping(value="/insert", method=RequestMethod.POST, produces="text/html;charset=UTF-8")
	@ResponseBody
	public String insertDsInfo(DsInformation dsInfo) {
		DsInfoDao dsInfoDao = new DsInfoDao();
		Status status = new Status();
		if(dsInfo.getDsname()!=null&&dsInfoDao.selectDsInfo(dsInfo.getDsname())==null){
			dsInfoDao.insertDsInfo(dsInfo);
			status.setStatus(0);
			status.setMsg("添加成功");
			return new Gson().toJson(status);
		}else{
			status.setStatus(-10);
			status.setMsg("请求数据错误");
			return new Gson().toJson(status);
		}
	}
	
	//查询驾校信息
		@RequestMapping(value="/select", method=RequestMethod.POST, produces="text/html;charset=UTF-8")
		@ResponseBody
		public String selectDsInfo(String dsname) {
			DsInfoDao dsInfoDao = new DsInfoDao();
		     
			Status status = new Status();
			if(dsname!=null){
				
				DsInformation dsInfo = dsInfoDao.selectDsInfo(dsname);
				if(dsInfo!=null){
					status.setStatus(0);
					status.setMsg(dsname+"获取成功");
					status.setData(dsInfoDao.selectDsInfo(dsname));
					return new Gson().toJson(status);
				}else{
					status.setStatus(-10);
					status.setMsg("查询信息不存在");
					return new Gson().toJson(status);
				}
			}else{
				status.setStatus(0);
				status.setMsg("获取成功");
				status.setData(dsInfoDao.selectDsInfoList());
				return new Gson().toJson(status);
			}
		   	
		}
	
	
}
