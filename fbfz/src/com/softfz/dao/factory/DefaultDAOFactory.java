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
import com.softfz.dao.impl.AppraiseDAOImpl;
import com.softfz.dao.impl.AreaDAOImpl;
import com.softfz.dao.impl.CooperationDAOImpl;
import com.softfz.dao.impl.CooperationTypeDAOImpl;
import com.softfz.dao.impl.MenuDAOImpl;
import com.softfz.dao.impl.ResourcesDAOImpl;
import com.softfz.dao.impl.RoleDAOImpl;
import com.softfz.dao.impl.SystemUserDAOImpl;
import com.softfz.dao.impl.UserMemberDAOImpl;

class DefaultDAOFactory extends DAOFactory {
	ISystemUserDAO systemUserDAO = new SystemUserDAOImpl();
	private IResourcesDAO resourcesDAO = new ResourcesDAOImpl();
	private ICooperationDAO cooperationDAO = new CooperationDAOImpl();
	private IUserMemberDAO userMemberDAO = new UserMemberDAOImpl();
	private ICooperationTypeDAO typeDAO = new CooperationTypeDAOImpl();
	private IRoleDAO roleDAO = new RoleDAOImpl();
	private IAreaDAO areaDAO = new AreaDAOImpl();
	private IMenuDAO menuDAO=new MenuDAOImpl();
	private IAppraiseDAO appraiseDAO=new AppraiseDAOImpl();
	@Override
	public ISystemUserDAO getSystemUserDAO() {

		return systemUserDAO;
	}

	@Override
	public IResourcesDAO getResourcesDAO() {
		return resourcesDAO;
	}

	@Override
	public ICooperationDAO getCooperationDAO() {
		return cooperationDAO;
	}

	@Override
	public IUserMemberDAO getUserMemberDAO() {
		return userMemberDAO;
	}

	@Override
	public ICooperationTypeDAO getCooperationTypeDAO() {
		return typeDAO;
	}

	@Override
	public IRoleDAO getRoleDAO() {
		// TODO Auto-generated method stub
		return roleDAO;
	}

	@Override
	public IAreaDAO getAreaDAO() {
		// TODO Auto-generated method stub
		return areaDAO;
	}

	public IMenuDAO getMenuDAO() {
		// TODO Auto-generated method stub
		return menuDAO;
	}

	@Override
	public IAppraiseDAO getAppraiseDAO() {
		// TODO Auto-generated method stub
		return appraiseDAO;
	}


}
