package com.bjpygh.glxt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bjpygh.glxt.dao.DsInfoDao;
import com.bjpygh.glxt.entity.DsInformation;
import com.bjpygh.glxt.entity.Status;
import com.google.gson.Gson;

@Controller
@RequestMapping(value="/dsInfo")
public class DsInfoController {

	//删除驾校信息
	@RequestMapping(value="/delete")
	public void deleteDsInfo(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        response.setContentType("text/html;charset=utf-8");   
		String dsname = request.getParameter("dsname");
		 DsInfoDao dsInfoDao = new DsInfoDao();
	     dsInfoDao.deleteDsInfo(dsname);
	     
	}
	
	//插入驾校信息
	@RequestMapping(value="/insert")
	public void insertDsInfo(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        response.setContentType("text/html;charset=utf-8");   
		String dsname = request.getParameter("dsname");
        String dsimage = request.getParameter("dsimage");
        String dsintro = request.getParameter("dsintro");
        String address = request.getParameter("address");
        
        DsInfoDao dsInfoDao = new DsInfoDao();
        
        DsInformation dsInfo = new DsInformation();
        dsInfo.setDsname(dsname);
        dsInfo.setDsimage(dsimage);
        dsInfo.setAddress(address);
        dsInfo.setDsintro(dsintro);
        
        dsInfoDao.insertDsInfo(dsInfo);
	     
	}
	
	//删除驾校信息
		@RequestMapping(value="/select")
		public void selectDsInfo(HttpServletRequest request, HttpServletResponse response) {
			
			PrintWriter out;
			try {
				request.setCharacterEncoding("utf-8");
		        response.setContentType("text/html;charset=utf-8");   
				out = response.getWriter();
				DsInfoDao dsInfoDao = new DsInfoDao();
		        
		        Status status = new Status();
		        List<DsInformation> dspInfolist = dsInfoDao.selectDsInfoList();
				status.setDspInfolist(dspInfolist);
		        
				Gson gson = new Gson();
				out.print(gson.toJson(status));
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	
}
