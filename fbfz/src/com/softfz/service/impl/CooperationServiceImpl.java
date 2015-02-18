package com.softfz.service.impl;

import java.util.List;

import com.softfz.dao.ICooperationDAO;
import com.softfz.dao.factory.DAOFactory;
import com.softfz.jdbc.JdbcUtils;
import com.softfz.jdbc.TransactionManager;
import com.softfz.model.AdShop;
import com.softfz.model.Cooperation;
import com.softfz.model.PageModel;
import com.softfz.service.FBfzServiceException;
import com.softfz.service.ICooperationService;

public class CooperationServiceImpl implements ICooperationService {
	private ICooperationDAO cooperationDAO;

	public CooperationServiceImpl() {
		this.cooperationDAO = DAOFactory.getInstance().getCooperationDAO();
	}

	public PageModel queryCooperation(Cooperation cooperation, int currentPage,
			int pageSize) {
		return cooperationDAO.queryCooperation(cooperation, currentPage,
				pageSize);
	}

	@Override
	public List<Cooperation> getTopVip() {
		
		return cooperationDAO.getTopVip();
	}

	@Override
	public List<Cooperation> getTopTypeShop() {
		
		return cooperationDAO.getTopTypeShop();
	}

	@Override
	public List<Cooperation> getTopTatalShop() {
		
		return cooperationDAO.getTopTatalShop();
	}

	@Override
	public List<AdShop> getOneLevelAd() {
	
		return cooperationDAO.getOneLevelAd();
	}

	@Override
	public void save(Cooperation cooperation) {
		// TODO Auto-generated method stub
		boolean isExit=cooperationDAO.isExit(cooperation);
		if(isExit){
			throw new FBfzServiceException("区域已经添加");
		}
		TransactionManager transactionManager=JdbcUtils.getTransactionManager();
		try{
			transactionManager.beginTransaction();
			cooperationDAO.save(cooperation);
			transactionManager.commit();
		}catch(Exception e){
			e.printStackTrace();
			transactionManager.rollback();
		}finally{
			transactionManager.endTransaction();
		}
	}


}
