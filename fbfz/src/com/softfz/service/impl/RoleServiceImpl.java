package com.softfz.service.impl;

import java.util.Date;
import java.util.List;

import com.softfz.dao.*;
import com.softfz.dao.factory.DAOFactory;
import com.softfz.jdbc.JdbcUtils;
import com.softfz.jdbc.TransactionManager;
import com.softfz.model.PageModel;
import com.softfz.model.Role;
import com.softfz.security.password.MD5Strategy;
import com.softfz.security.password.PasswordStrategy;
import com.softfz.service.FBfzServiceException;
import com.softfz.service.IRoleService;

public class RoleServiceImpl implements IRoleService {

	private IRoleDAO roleDAO;
	private IMenuDAO menuDAO;

	public RoleServiceImpl() {
		roleDAO = DAOFactory.getInstance().getRoleDAO();
		menuDAO=DAOFactory.getInstance().getMenuDAO();
	}

	// 获取所有角色信息
	@Override
	public List<Role> getAllRoles() {
		// TODO Auto-generated method stub
		return roleDAO.getAllRoles();
	}

	// 分页查询所有角色
	@Override
	public PageModel queryRole(Role role, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return roleDAO.queryRole(role, currentPage, pageSize);
	}

	@Override
	public void save(Role role) {
		// TODO Auto-generated method stub
		boolean isExit = roleDAO.isExit(role);
		if (isExit) {
			throw new FBfzServiceException("角色名已经被使用");
		}
		TransactionManager transactionManager = JdbcUtils
				.getTransactionManager();
		try {
			transactionManager.beginTransaction();
			int roleid = roleDAO.save(role);
			if (role.getRolemenus() != null)
				for (Integer menuid : role.getRolemenus()) {
					roleDAO.saveRoleMenuRelation(roleid, menuid);
				}
			if (role.getRoleresources() != null)
				for (Integer resourceid : role.getRoleresources()) {
					roleDAO.saveRoleResourceRelation(roleid, resourceid);
				}
			transactionManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transactionManager.rollback();
		} finally {
			transactionManager.endTransaction();
		}
	}

	@Override
	public Role loadById(int rid) {
		// TODO Auto-generated method stub
		return roleDAO.loadById(rid);
	}
	@Override
	public void update(Role role) {
		// TODO Auto-generated method stub
		TransactionManager transactionManager=JdbcUtils.getTransactionManager();
		try{
			transactionManager.beginTransaction();
			roleDAO.deleteRoleMenuRelation(role.getRoleid());
			for(Integer menuid:role.getRolemenus()){
			   roleDAO.saveRoleMenuRelation(role.getRoleid(),menuid);
			}
			roleDAO.deleteRoleResourceRelation(role.getRoleid());
			for (Integer resourceid : role.getRoleresources()) {
				roleDAO.saveRoleResourceRelation(role.getRoleid(), resourceid);
			}
			transactionManager.commit();
		}catch(Exception e){
			e.printStackTrace();
			transactionManager.rollback();
		}finally{
			transactionManager.endTransaction();
		}
		
	}

	@Override
	public void delete(Role role) {
		// TODO Auto-generated method stub
		boolean isTaken = roleDAO.isTaken(role);
		if (isTaken) {
			throw new FBfzServiceException("角色已经分配给用户，不能删除");
		}
		TransactionManager transactionManager = JdbcUtils
				.getTransactionManager();
		try {
			transactionManager.beginTransaction();
			roleDAO.deleteRoleMenuRelation(role.getRoleid());
			roleDAO.deleteRoleResourceRelation(role.getRoleid());
			roleDAO.delete(role);
			transactionManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transactionManager.rollback();
		} finally {
			transactionManager.endTransaction();
		}
		
	}

}
