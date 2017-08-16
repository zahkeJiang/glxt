package com.bjpygh.glxt.mapper;

import java.util.List;

import com.bjpygh.glxt.entity.DsInformation;

public interface DsInfoMapper {

	public void insertDsInfo(DsInformation DsInfo);
	public void deleteDsInfo(String dsname);
	public DsInformation selectDsInfo(String dsname);
	public List<DsInformation> selectDsInfoList();
}
