package com.bjpygh.glxt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	@RequestMapping(value="/delete")
	public void deletePackage(HttpServletRequest request, HttpServletResponse response) {
			PrintWriter out;
		try {
			out = response.getWriter();
			String packageid = request.getParameter("packageid");
		    DsPackageDao dsPackageDao = new DsPackageDao();
		    dsPackageDao.deleteDsPackage(packageid);
		    Status status = new Status();
		    status.setStatus(1);
		    out.print(new Gson().toJson(status));
		    out.flush();
		    out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		     
	}
	
	//插入套餐信息
	@RequestMapping(value="/insert")
	public void insertPackage(HttpServletRequest request, HttpServletResponse response) {
			PrintWriter out;
		try {
			out = response.getWriter();
		       
		    String dsname = request.getParameter("dsname");
		    String dstype = request.getParameter("dstype");
		    String models = request.getParameter("models");
		    String traintime = request.getParameter("traintime");
		    String price = request.getParameter("price");
		    String description = request.getParameter("description");
		        
		    DsPackageDao dsPackageDao = new DsPackageDao();
		        
		    DsPackage dsPackage = new DsPackage();
		    dsPackage.setDsname(dsname);
		    dsPackage.setDstype(dstype);
		    dsPackage.setModels(models);
		    dsPackage.setTraintime(traintime);
		    dsPackage.setPrice(Integer.parseInt(price));
		    dsPackage.setDescription(description);
		        
		    dsPackageDao.insertDsPackage(dsPackage);
		        
		    Status status = new Status();
		    status.setStatus(1);
		    out.print(new Gson().toJson(status));
		    out.flush();
		    out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			     
	}
	
	//删除套餐信息
		@RequestMapping(value="/select")
		public void selectPackage(HttpServletRequest request, HttpServletResponse response) throws IOException {
			PrintWriter out = response.getWriter();
			String dsname = request.getParameter("dsname");
			DsPackageDao dsPackageDao = new DsPackageDao();
			 Gson gson = new Gson();
			 Status status = new Status();
			    try {
			    	DsInfoDao dsInfoDao = new DsInfoDao();
			           
			        DsInformation dsInfo = dsInfoDao.selectDsInfo(dsname);
			        dsInfo.setDspList(dsPackageDao.selectDsPackage(dsname));
			        out.print(gson.toJson(dsInfo));
			    } catch (NullPointerException e) {
					
			        status.setStatus(1);
			        status.setDsplist(dsPackageDao.selectDsPackage(dsname));
			        out.print(gson.toJson(status));
				}finally{
					out.flush();
					out.close();
				}
			     
		}
	
}
