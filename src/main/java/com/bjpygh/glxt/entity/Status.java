package com.bjpygh.glxt.entity;

import java.util.List;

public class Status {

	private int status;
	private Object data;
	private List<Object> datas;
	private List<DsInformation> dspInfolist;
	private List<DsPackage> dsplist;
	private List<DsOrder> dsolist;
	private String msg;
	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public List<Object> getDatas() {
		return datas;
	}

	public void setDatas(List<Object> datas) {
		this.datas = datas;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<DsOrder> getDsolist() {
		return dsolist;
	}

	public void setDsolist(List<DsOrder> dsolist) {
		this.dsolist = dsolist;
	}

	public List<DsPackage> getDsplist() {
		return dsplist;
	}

	public void setDsplist(List<DsPackage> dsplist) {
		this.dsplist = dsplist;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<DsInformation> getDspInfolist() {
		return dspInfolist;
	}

	public void setDspInfolist(List<DsInformation> dspInfolist) {
		this.dspInfolist = dspInfolist;
	}
	
}
