package com.softfz.service.factory;

import com.softfz.service.IAppraiseService;
import com.softfz.service.IAreaService;
import com.softfz.service.ICooperationService;
import com.softfz.service.ICooperationTypeService;
import com.softfz.service.IMenuService;
import com.softfz.service.IResourcesService;
import com.softfz.service.IRoleService;
import com.softfz.service.ISystemUserService;
import com.softfz.service.IUserMemberService;
import com.softfz.service.impl.AppraiseServiceImpl;
import com.softfz.service.impl.AreaServiceImpl;
import com.softfz.service.impl.CooperationServiceImpl;
import com.softfz.service.impl.CooperationTypeServiceImpl;
import com.softfz.service.impl.MenuServiceImpl;
import com.softfz.service.impl.ResourcesServiceImpl;
import com.softfz.service.impl.RoleServiceImpl;
import com.softfz.service.impl.SystemServiceImpl;
import com.softfz.service.impl.UserMemberServiceImpl;

class DefaultServiceFactory extends ServiceFactory {
	private ISystemUserService service = new SystemServiceImpl();

	private IResourcesService resourcesService = new ResourcesServiceImpl();

	private ICooperationService cooperationService = new CooperationServiceImpl();
	
	private IUserMemberService userMemberService = new UserMemberServiceImpl();
	private ICooperationTypeService typeService = new CooperationTypeServiceImpl();
	private IAreaService areaService=new AreaServiceImpl();
	private IRoleService roleService=new RoleServiceImpl();
	private IMenuService menuService=new MenuServiceImpl();
	private IAppraiseService appraiseService=new AppraiseServiceImpl();
	@Override
	public ISystemUserService getSystemUserService() {

		return service;
	}

	@Override
	public IResourcesService getResourcesService() {
		return resourcesService;
	}

	@Override
	public ICooperationService getCooperationService() {
		return cooperationService;
	}

	@Override
	public IUserMemberService getUserMemberService() {
		return userMemberService;
	}

	@Override
	public ICooperationTypeService getCooperationTypeService() {

		return typeService;
	}

	@Override
	public IRoleService getRoleService() {
		// TODO Auto-generated method stub
		return roleService;
	}
	public IAreaService getAreaService() {
		// TODO Auto-generated method stub
		return areaService;
	}

	@Override
	public IMenuService getMenuService() {
		// TODO Auto-generated method stub
		return menuService;
	}

	@Override
	public IAppraiseService getAppraiseService() {
		// TODO Auto-generated method stub
		return appraiseService;
	}
}
