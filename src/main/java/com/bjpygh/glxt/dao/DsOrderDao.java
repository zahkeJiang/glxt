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
	public List<DsOrder> getOrderPay(DsOrder dsorder){
		List<DsOrder> dsOrder = null;
		try {
			sqlSession = SqlSessionFactoryUtil.openSqlSession();
			DsOrderMapper dsOrderMapper = sqlSession.getMapper(DsOrderMapper.class);
			dsOrder = dsOrderMapper.getOrderPay(dsorder);
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
	
	//鑾峰彇璁㈠崟淇℃伅
	public List<DsOrder> getOrderGet(DsOrder dsorder){
		List<DsOrder> dsOrder = null;
		try {
			sqlSession = SqlSessionFactoryUtil.openSqlSession();
			DsOrderMapper dsOrderMapper = sqlSession.getMapper(DsOrderMapper.class);
			dsOrder = dsOrderMapper.getOrderGet(dsorder);
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

	//鑾峰彇璁㈠崟淇℃伅
	public List<DsOrder> getOrderSign(DsOrder dsorder){
		List<DsOrder> dsOrder = null;
		try {
			sqlSession = SqlSessionFactoryUtil.openSqlSession();
			DsOrderMapper dsOrderMapper = sqlSession.getMapper(DsOrderMapper.class);
			dsOrder = dsOrderMapper.getOrderSign(dsorder);
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

	//鑾峰彇璁㈠崟淇℃伅
	public List<DsOrder> getOrderFinish(DsOrder dsorder){
		List<DsOrder> dsOrder = null;
		try {
			sqlSession = SqlSessionFactoryUtil.openSqlSession();
			DsOrderMapper dsOrderMapper = sqlSession.getMapper(DsOrderMapper.class);
			dsOrder = dsOrderMapper.getOrderFinish(dsorder);
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

	//鑾峰彇璁㈠崟淇℃伅
	public List<DsOrder> getOrders(DsOrder dsorder){
		List<DsOrder> dsOrder = null;
		try {
			sqlSession = SqlSessionFactoryUtil.openSqlSession();
			DsOrderMapper dsOrderMapper = sqlSession.getMapper(DsOrderMapper.class);
			dsOrder = dsOrderMapper.getOrders(dsorder);
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
}
