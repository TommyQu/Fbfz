package com.softfz.dao.factory;

import com.softfz.dao.IAppraiseDAO;
import com.softfz.dao.IAreaDAO;
import com.softfz.dao.ICooperationDAO;
import com.softfz.dao.ICooperationTypeDAO;
import com.softfz.dao.IMenuDAO;
import com.softfz.dao.IResourcesDAO;
import com.softfz.dao.IRoleDAO;
import com.softfz.dao.ISystemUserDAO;
import com.softfz.dao.IUserMemberDAO;



public abstract class DAOFactory {
	private static DAOFactory factory = new DefaultDAOFactory();

	public static DAOFactory getInstance() {
		return factory;
	}
	/**
	 * 获取系统管理员数据接口
	 * @return
	 */
	public abstract ISystemUserDAO getSystemUserDAO();
	public abstract IResourcesDAO getResourcesDAO();
	
	public abstract ICooperationDAO getCooperationDAO();
	
	public abstract IUserMemberDAO getUserMemberDAO();
	public abstract ICooperationTypeDAO getCooperationTypeDAO();
	public abstract IRoleDAO getRoleDAO();
	public abstract IAreaDAO getAreaDAO();
	public abstract IMenuDAO getMenuDAO();
	public abstract IAppraiseDAO getAppraiseDAO();
}
