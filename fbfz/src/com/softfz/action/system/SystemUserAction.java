package com.softfz.action.system;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.opensymphony.xwork2.ModelDriven;
import com.softfz.action.common.BaseAction;
import com.softfz.model.Role;
import com.softfz.model.SystemUser;
import com.softfz.service.FBfzServiceException;
import com.softfz.service.IRoleService;
import com.softfz.service.ISystemUserService;
import com.softfz.service.factory.ServiceFactory;

public class SystemUserAction extends BaseAction implements
		ModelDriven<SystemUser> {
	private SystemUser systemUser = new SystemUser();
	private ISystemUserService userService;
	private IRoleService roleService;
	private List<Role> roles;
	private String[] rolelist;
	private int uid;

	public SystemUserAction() {
		userService = ServiceFactory.getInstance().getSystemUserService();
		roleService = ServiceFactory.getInstance().getRoleService();
	}

	// 查询所有管理员(支持账号和状态)
	public String query() throws Exception {
		pageModel = userService.querySystemUser(systemUser, currentPage,
				pageSize);
		return SUCCESS;
	}

	// 获取所有角色信息
	public String getAllRoles() {
		roles = roleService.getAllRoles();
		return SUCCESS;
	}

	// 保存管理员信息
	public String save() {
		// 根据管理员名查询是否已经存在
		// System.out.println(systemUser.getLoginname());
		try {
			List<Integer> tmplist=new ArrayList<Integer>();
			for(String r:rolelist){
				tmplist.add(Integer.parseInt(r));
			}
			systemUser.setUserroles(tmplist);
			userService.save(systemUser);
			message.success("新增管理员成功！！！", true, "");
		} catch (FBfzServiceException e) {
			message.fail(e.getMessage());
		} catch (Exception e) {
			message.systemfail();
		}
		return returnjson();
	}
	//跳转至管理员修改页面
	public String jumptoUpdate()throws Exception{
		SystemUser tmp=userService.loadById(uid);
		roles=roleService.getAllRoles();
		BeanUtils.copyProperties(systemUser, tmp);
		return "jump";
	}
	//修改管理员信息
	public String update(){
		try {
			List<Integer> tmplist=new ArrayList<Integer>();
			for(String r:rolelist){
				tmplist.add(Integer.parseInt(r));
			}
			//SystemUser tmp=userService.loadById(systemUser.getUserid());
			systemUser.setUserroles(tmplist);
			userService.update(systemUser);
			message.success("修改管理员成功！！！", true, "");
		} catch (FBfzServiceException e) {
			message.fail(e.getMessage());
		} catch (Exception e) {
			message.systemfail();
		}
		return returnjson();
	}
	//冻结管理员
	public String userlocked(){
		try {
			userService.userlocked(uid);
			message.success("成功冻结管理员！！！", false, "");
		} catch (FBfzServiceException e) {
			message.fail(e.getMessage());
		} catch (Exception e) {
			message.systemfail();
		}
		return returnjson();
	}
	
	//解冻管理员
	public String userunlocked(){
		try {
			userService.userunlocked(uid);
			message.success("成功解冻管理员！！！", false, "");
		} catch (FBfzServiceException e) {
			message.fail(e.getMessage());
		} catch (Exception e) {
			message.systemfail();
		}
		return returnjson();
	}

	// get方法汇总
	public SystemUser getModel() {
		return systemUser;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public String[] getRolelist() {
		return rolelist;
	}

	public void setRolelist(String[] rolelist) {
		this.rolelist = rolelist;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

}
