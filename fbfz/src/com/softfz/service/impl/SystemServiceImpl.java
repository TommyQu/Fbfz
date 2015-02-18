package com.softfz.service.impl;

import java.util.Date;
import java.util.List;

import com.softfz.dao.ISystemUserDAO;
import com.softfz.dao.factory.DAOFactory;
import com.softfz.jdbc.JdbcUtils;
import com.softfz.jdbc.TransactionManager;
import com.softfz.model.MenuInfo;
import com.softfz.model.PageModel;
import com.softfz.model.SystemUser;
import com.softfz.security.password.MD5Strategy;
import com.softfz.security.password.PasswordStrategy;
import com.softfz.service.FBfzServiceException;
import com.softfz.service.ISystemUserService;

public class SystemServiceImpl implements ISystemUserService{
	private ISystemUserDAO userDAO;
	private final static String PWD_SALT="softfz";
	public SystemServiceImpl(){
		userDAO = DAOFactory.getInstance().getSystemUserDAO();
	}
	public PageModel querySystemUser(SystemUser systemUser, int currentPage,
			int pageSize) {
		
		return userDAO.querySystemUser(systemUser,currentPage,pageSize);
	}
	//登陆
	@Override
	public SystemUser login(String loginname, String password) {
		SystemUser systemUser =userDAO.getSystemUserByLoginName(loginname);
		if(systemUser==null){
			throw new FBfzServiceException("用户名或者密码错误");
		}
		PasswordStrategy strategy = new MD5Strategy();
		password = strategy.encrypt(password, PWD_SALT);
		if(!systemUser.getPassword().equals(password)){
			throw new FBfzServiceException("用户名或者密码错误");
		}
		//获取用户所拥有的角色编号
		List<Integer> roleids = userDAO.getUserRoleids(systemUser.getUserid());
		systemUser.setUserroles(roleids);
		return systemUser;
	}
	
	//获取用户菜单
	@Override
	public List<MenuInfo> getUserMenus(int userid) {
		
		return userDAO.getUserMenus(userid);
	}
	//保存管理员
	@Override
	public void save(SystemUser systemUser) {
		// TODO Auto-generated method stub
		//获取管理员信息
		//判断资源名称是否被使用
		boolean isExit=userDAO.isExit(systemUser);
		if(isExit){
			throw new FBfzServiceException("管理员已经被使用");
		}
		PasswordStrategy strategy=new MD5Strategy();
		String pwd=strategy.encrypt("888888", PWD_SALT);
		Date nowtime=new Date();
		systemUser.setPassword(pwd);
		systemUser.setState(1);
		systemUser.setOpentime(nowtime);
		TransactionManager transactionManager=JdbcUtils.getTransactionManager();
		try{
			transactionManager.beginTransaction();
			int userid=userDAO.save(systemUser);
			userDAO.saveUserRoleRelation(userid,systemUser.getUserroles());
			transactionManager.commit();
		}catch(Exception e){
			e.printStackTrace();
			transactionManager.rollback();
		}finally{
			transactionManager.endTransaction();
		}
	}
	//根据id载入管理员
	public SystemUser loadById(int uid){
		SystemUser systemUser=userDAO.loadById(uid);
		return systemUser;
	}
	//更新管理员
	@Override
	public void update(SystemUser systemUser) {
		// TODO Auto-generated method stub
		TransactionManager transactionManager=JdbcUtils.getTransactionManager();
		try{
			transactionManager.beginTransaction();
			userDAO.update(systemUser);
			userDAO.saveUserRoleRelation(systemUser.getUserid(),systemUser.getUserroles());
			transactionManager.commit();
		}catch(Exception e){
			e.printStackTrace();
			transactionManager.rollback();
		}finally{
			transactionManager.endTransaction();
		}
		
	}
	//冻结
	@Override
	public void userlocked(int uid) {
		// TODO Auto-generated method stub
		userDAO.userlocked(uid);
	}
	//解冻
	@Override
	public void userunlocked(int uid) {
		// TODO Auto-generated method stub
		userDAO.userunlocked(uid);
		
	}

}
