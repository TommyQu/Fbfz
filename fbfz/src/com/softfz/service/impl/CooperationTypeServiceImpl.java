package com.softfz.service.impl;

import java.util.List;

import com.softfz.dao.ICooperationTypeDAO;
import com.softfz.dao.factory.DAOFactory;
import com.softfz.dao.impl.CooperationTypeDAOImpl;
import com.softfz.jdbc.JdbcUtils;
import com.softfz.jdbc.TransactionManager;
import com.softfz.model.Area;
import com.softfz.model.CooperationType;
import com.softfz.service.FBfzServiceException;
import com.softfz.service.ICooperationTypeService;

public class CooperationTypeServiceImpl implements ICooperationTypeService {
	private ICooperationTypeDAO typeDAO;

	public CooperationTypeServiceImpl() {
		typeDAO = DAOFactory.getInstance().getCooperationTypeDAO();
	}

	@Override
	public List<CooperationType> getAllType() {
		return typeDAO.getAllType();
	}

	@Override
	public List<CooperationType> getAllBigType() {
		
		return typeDAO.getAllBigType();
	}

	@Override
	public List<CooperationType> getSmallTypeByFatherid(Integer bigtypeid) {
		return typeDAO.getSmallTypeByFatherid(bigtypeid);
	}

	@Override
	public void save(CooperationType cooperationType) {
		boolean isExit=typeDAO.isExit(cooperationType);
		if(isExit){
			throw new FBfzServiceException("分类已经添加");
		}
		TransactionManager transactionManager=JdbcUtils.getTransactionManager();
		try{
			transactionManager.beginTransaction();
			typeDAO.save(cooperationType);
			transactionManager.commit();
		}catch(Exception e){
			e.printStackTrace();
			transactionManager.rollback();
		}finally{
			transactionManager.endTransaction();
		}
		
	}

	@Override
	public void delete(int typeid) {
		TransactionManager transactionManager=JdbcUtils.getTransactionManager();
		try{
			transactionManager.beginTransaction();
			typeDAO.delete(typeid);
			transactionManager.commit();
		}catch(Exception e){
			e.printStackTrace();
			transactionManager.rollback();
		}finally{
			transactionManager.endTransaction();
		}
		
	}

	@Override
	public CooperationType loadById(int typeid) {
		// TODO Auto-generated method stub
		CooperationType type=typeDAO.loadById(typeid);
		return type;
	}

	@Override
	public void update(CooperationType cooperationType) {
		TransactionManager transactionManager=JdbcUtils.getTransactionManager();
		try{
			transactionManager.beginTransaction();
			typeDAO.update(cooperationType);
			transactionManager.commit();
		}catch(Exception e){
			e.printStackTrace();
			transactionManager.rollback();
		}finally{
			transactionManager.endTransaction();
		}
		
		
	}

}
