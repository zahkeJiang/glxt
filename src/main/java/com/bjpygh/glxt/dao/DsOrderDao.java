package com.bjpygh.glxt.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bjpygh.glxt.entity.DsOrder;
import com.bjpygh.glxt.mapper.DsOrderMapper;
import com.bjpygh.glxt.utils.SqlSessionFactoryUtil;


public class DsOrderDao {

	SqlSession sqlSession = null;

	
	//鑾峰彇璁㈠崟淇℃伅
	public List<DsOrder> getOrderByRealName(String realname){
		List<DsOrder> dsOrder = null;
		try {
			sqlSession = SqlSessionFactoryUtil.openSqlSession();
			DsOrderMapper dsOrderMapper = sqlSession.getMapper(DsOrderMapper.class);
			dsOrder = dsOrderMapper.getOrderByRealName(realname);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}finally{
			if (sqlSession != null){
				sqlSession.close();
			}
		}
		return dsOrder;
	}
		
	
		//鎻掑叆璁㈠崟
				public void changeStatus(Map<String, String> map){
					try {
						sqlSession = SqlSessionFactoryUtil.openSqlSession();
						DsOrderMapper dsOrderMapper = sqlSession.getMapper(DsOrderMapper.class);
						dsOrderMapper.changeStatus(map);
						sqlSession.commit();
					} catch (Exception e) {
						e.printStackTrace();
						sqlSession.rollback();
					}finally{
						if (sqlSession != null){
							sqlSession.close();
						}
					}
				}
}
