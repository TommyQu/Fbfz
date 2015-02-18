package com.softfz.service.impl;

import java.util.List;

import com.softfz.dao.IMenuDAO;
import com.softfz.dao.factory.DAOFactory;
import com.softfz.jdbc.JdbcUtils;
import com.softfz.jdbc.TransactionManager;
import com.softfz.model.MenuInfo;
import com.softfz.service.FBfzServiceException;
import com.softfz.service.IMenuService;

public class MenuServiceImpl implements IMenuService {

	private IMenuDAO menuDAO;
	public MenuServiceImpl(){
		menuDAO=DAOFactory.getInstance().getMenuDAO();
	}
	@Override
	public List<MenuInfo> loadAllMenu() {
		// TODO Auto-generated method stub
		return menuDAO.loadAllMenu();
	}
	@Override
	public List<MenuInfo> loadMenusByRoleid(int rid) {
		// TODO Auto-generated method stub
		return menuDAO.loadMenusByRoleid(rid);
	}
	@Override
	public void save(MenuInfo menu) {
		// TODO Auto-generated method stub
		boolean isExit=menuDAO.isExit(menu.getMenuname());
		if(isExit){
			throw new FBfzServiceException("菜单名已经被使用");
		}
		menuDAO.save(menu);
	}
	@Override
	public MenuInfo loadMenuById(Integer mid) {
		// TODO Auto-generated method stub
		return menuDAO.loadMenuById(mid);
	}
	@Override
	public void update(MenuInfo menu) {
		// TODO Auto-generated method stub
		TransactionManager transactionManager=JdbcUtils.getTransactionManager();
		try{
			transactionManager.beginTransaction();
			menuDAO.update(menu);
			transactionManager.commit();
		}catch(Exception e){
			e.printStackTrace();
			transactionManager.rollback();
		}finally{
			transactionManager.endTransaction();
		}
	}
	@Override
	public void delete(MenuInfo menu) {
		// TODO Auto-generated method stub
		TransactionManager transactionManager=JdbcUtils.getTransactionManager();
		try{
			transactionManager.beginTransaction();
			if(menu.getFatherid()==null){
				menuDAO.deleteChildren(menu.getMenuid());
			}
			menuDAO.delete(menu.getMenuid());
			menuDAO.deleteMenuRoleRelation(menu.getMenuid());
			transactionManager.commit();
		}catch(Exception e){
			e.printStackTrace();
			transactionManager.rollback();
		}finally{
			transactionManager.endTransaction();
		}
	}

}
