package com.bjpygh.glxt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjpygh.glxt.dao.DsInfoDao;
import com.bjpygh.glxt.dao.DsPackageDao;
import com.bjpygh.glxt.entity.DsInformation;
import com.bjpygh.glxt.entity.DsPackage;
import com.bjpygh.glxt.entity.Status;
import com.google.gson.Gson;

@Controller
@RequestMapping(value="/package")
public class PackageController {

	//删除套餐信息
	@RequestMapping(value="/delete", method=RequestMethod.POST, produces="text/html;charset=UTF-8")
	@ResponseBody
	public String deletePackage(String[] packageid) {
			
		    DsPackageDao dsPackageDao = new DsPackageDao();
		    Status status = new Status();
		    if(packageid.length>0){
		    	for(int i=0;i<packageid.length;i++){
		    		dsPackageDao.deleteDsPackage(packageid[i]);
		    	}
			    status.setStatus(0);
			    status.setMsg("删除成功");
			    return new Gson().toJson(status);
		    }else{
		    	status.setStatus(-10);
			    status.setMsg("传入参数错误");
			    return new Gson().toJson(status);
		    }
	}
	
	//插入套餐信息
	@RequestMapping(value="/insert", method=RequestMethod.POST, produces="text/html;charset=UTF-8")
	@ResponseBody
	public String insertPackage(DsPackage dsPackage) {
		
		DsPackageDao dsPackageDao = new DsPackageDao();
		Status status = new Status();
		if(dsPackage.getDsname()!=null&&dsPackageDao.selectDsPackage(dsPackage.getDsname())==null){
			dsPackageDao.insertDsPackage(dsPackage);
			status.setStatus(0);
			status.setMsg("添加成功");
			return new Gson().toJson(status);
		}else{
			status.setStatus(-10);
			status.setMsg("请求数据错误");
			return new Gson().toJson(status);
		}
			   
	}
	
	//删除套餐信息
		@RequestMapping(value="/select", method=RequestMethod.POST, produces="text/html;charset=UTF-8")
		@ResponseBody
		public String selectPackage(String dsname) throws IOException {
			
			DsPackageDao dsPackageDao = new DsPackageDao();
			Status status = new Status();
			if(dsname!=null){
				
				List<DsPackage> dsPackage = dsPackageDao.selectDsPackage(dsname);
				if(dsPackage.size()>0){
					status.setStatus(0);
					status.setMsg(dsname+"获取成功");
					status.setData(dsPackage);
					return new Gson().toJson(status);
				}else{
					status.setStatus(-10);
					status.setMsg("查询信息不存在");
					return new Gson().toJson(status);
				}
			}else{
				status.setStatus(0);
				status.setMsg("获取成功");
				status.setData(dsPackageDao.selectDsPackage(dsname));
				return new Gson().toJson(status);
			}
			     
		}
	
}
