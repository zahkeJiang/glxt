package com.bjpygh.glxt.mapper;

import java.util.List;

import com.bjpygh.glxt.entity.DsPackage;

public interface DsPackageMapper {
	
	public void insertDsPackage(DsPackage dsPackage);
	public void deleteDsPackage(int packageid);
	public List<DsPackage> selectDsPackage(String dsname);
}
