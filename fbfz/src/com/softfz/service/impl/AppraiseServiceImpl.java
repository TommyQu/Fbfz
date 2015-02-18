package com.softfz.service.impl;

import com.softfz.dao.IAppraiseDAO;
import com.softfz.dao.factory.DAOFactory;
import com.softfz.jdbc.JdbcUtils;
import com.softfz.jdbc.TransactionManager;
import com.softfz.model.Appraise;
import com.softfz.model.PageModel;
import com.softfz.service.IAppraiseService;

public class AppraiseServiceImpl implements IAppraiseService{
	private IAppraiseDAO appraiseDAO;
	public AppraiseServiceImpl()
	{
		this.appraiseDAO=DAOFactory.getInstance().getAppraiseDAO();
	}
	public PageModel queryAppraise(Appraise appraise, int currentPage,
			int pageSize) {
		// TODO Auto-generated method stub
		return appraiseDAO.queryAppraise(appraise, currentPage, pageSize);
	}
	@Override
	public void delete(int appid) {
		TransactionManager transactionManager=JdbcUtils.getTransactionManager();
		try{
			transactionManager.beginTransaction();
			appraiseDAO.delete(appid);
			transactionManager.commit();
		}catch(Exception e){
			e.printStackTrace();
			transactionManager.rollback();
		}finally{
			transactionManager.endTransaction();
		}
		
	}

}
