package com.softfz.service.impl;

import java.util.Date;
import java.util.List;

import com.softfz.dao.IAreaDAO;
import com.softfz.dao.ICooperationDAO;
import com.softfz.dao.factory.DAOFactory;
import com.softfz.jdbc.JdbcUtils;
import com.softfz.jdbc.TransactionManager;
import com.softfz.model.Area;
import com.softfz.model.Cooperation;
import com.softfz.model.PageModel;
import com.softfz.model.Role;
import com.softfz.model.SystemUser;
import com.softfz.security.password.MD5Strategy;
import com.softfz.security.password.PasswordStrategy;
import com.softfz.service.FBfzServiceException;
import com.softfz.service.IAreaService;

public class AreaServiceImpl implements IAreaService{
	private IAreaDAO areaDAO;
	public AreaServiceImpl() {
		this.areaDAO = DAOFactory.getInstance().getAreaDAO();
	}

	public List<Area> queryArea() {
		// TODO Auto-generated method stub
		return areaDAO.queryArea();
	}

	public void save(Area area) {
		// TODO Auto-generated method stub
		//System.out.println(area.getAreaname());
		boolean isExit=areaDAO.isExit(area);
		if(isExit){
			throw new FBfzServiceException("区域已经添加");
		}
		TransactionManager transactionManager=JdbcUtils.getTransactionManager();
		try{
			transactionManager.beginTransaction();
			areaDAO.save(area);
			transactionManager.commit();
		}catch(Exception e){
			e.printStackTrace();
			transactionManager.rollback();
		}finally{
			transactionManager.endTransaction();
		}
	}

	@Override
	public List<Area> getAllBig() {
		// TODO Auto-generated method stub
		return areaDAO.getAllBig();
	}

	@Override
	public void delete(int areaid) {
		TransactionManager transactionManager=JdbcUtils.getTransactionManager();
		try{
			transactionManager.beginTransaction();
			areaDAO.delete(areaid);
			transactionManager.commit();
		}catch(Exception e){
			e.printStackTrace();
			transactionManager.rollback();
		}finally{
			transactionManager.endTransaction();
		}
		
	}

	@Override
	public Area loadById(int areaid) {
		Area area=areaDAO.loadById(areaid);
		return area;
	}

	@Override
	public void update(Area area) {
		TransactionManager transactionManager=JdbcUtils.getTransactionManager();
		try{
			transactionManager.beginTransaction();
			areaDAO.update(area);
			transactionManager.commit();
		}catch(Exception e){
			e.printStackTrace();
			transactionManager.rollback();
		}finally{
			transactionManager.endTransaction();
		}
		
	}

	@Override
	public List<Area> getSmall(int bigareaid) {
		// TODO Auto-generated method stub
		return areaDAO.getSmall(bigareaid);
	}
}
