package com.softfz.action.system;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.opensymphony.xwork2.ModelDriven;
import com.softfz.action.common.BaseAction;
import com.softfz.model.MenuInfo;
import com.softfz.model.Resources;
import com.softfz.model.Role;
import com.softfz.service.FBfzServiceException;
import com.softfz.service.IMenuService;
import com.softfz.service.IResourcesService;
import com.softfz.service.IRoleService;
import com.softfz.service.ISystemUserService;
import com.softfz.service.factory.ServiceFactory;

public class RoleAction extends BaseAction implements
ModelDriven<Role>{
	private Role role=new Role();
	private int rid;
	private IRoleService roleService;
	private IMenuService menuService;
	private IResourcesService resourcesService;
	private List<MenuInfo> menus;
	private List<Resources> resources;
	
	
	public RoleAction(){
		roleService=ServiceFactory.getInstance().getRoleService();
		menuService=ServiceFactory.getInstance().getMenuService();
		resourcesService=ServiceFactory.getInstance().getResourcesService();
	}

	//更新角色
	public String update(){
		try {
			roleService.update(role);
			message.success("修改角色成功！！！", true, "");
		} catch (FBfzServiceException e) {
			message.fail(e.getMessage());
		} catch (Exception e) {
			message.systemfail();
		}
		return returnjson();
	}
	//跳转至更新页面
	public String jumptoupdate() throws Exception{
		Role tmp=roleService.loadById(rid);
		menus=menuService.loadMenusByRoleid(rid);
		resources=resourcesService.loadResourcesById(rid);
		for(Resources re:resources){
			tmp.getRoleresources().add(re.getResourceid());
		}
		//System.out.println(tmp.getRoledesr());
		for(MenuInfo m:menus){
			tmp.getRolemenus().add(m.getMenuid());
		}
		menus=menuService.loadAllMenu();
		resources=resourcesService.loadAllResources();
		BeanUtils.copyProperties(role, tmp);
		return "jumpupdate";		
	}
	//分页查询角色栏
	public String query() throws Exception {
		pageModel = roleService.queryRole(role, currentPage,
				pageSize);
		return SUCCESS;
	}
	//跳转至增加角色页面
	public String jump(){
		menus=menuService.loadAllMenu();
		resources=resourcesService.loadAllResources();
		return "jump";
	}
	
	//删除角色
	public String delete(){
		try {
			role.setRoleid(rid);
			roleService.delete(role);
			message.success("删除角色成功！！！", true, "");
		} catch (FBfzServiceException e) {
			message.fail(e.getMessage());
		} catch (Exception e) {
			message.systemfail();
		}
		return returnjson();
	}
	//保存角色
	public String save(){
		//System.out.println(role.getRolename());
		try {
			roleService.save(role);
			message.success("新增角色成功！！！", true, "");
		} catch (FBfzServiceException e) {
			message.fail(e.getMessage());
		} catch (Exception e) {
			message.systemfail();
		}
		return returnjson();
	}
	
	//get 方法汇总
	@Override
	public Role getModel() {
		// TODO Auto-generated method stub
		return role;
	}


	public List<MenuInfo> getMenus() {
		return menus;
	}

	public void setMenus(List<MenuInfo> menus) {
		this.menus = menus;
	}

	public List<Resources> getResources() {
		return resources;
	}

	public void setResources(List<Resources> resources) {
		this.resources = resources;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}


}
