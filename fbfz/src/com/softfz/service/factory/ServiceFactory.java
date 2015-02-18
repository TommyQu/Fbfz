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
import com.sun.corba.se.spi.protocol.InitialServerRequestDispatcher;

public abstract class ServiceFactory {
	private static ServiceFactory factory = new DefaultServiceFactory();

	public static ServiceFactory getInstance() {
		return factory;
	}
	/**
	 * 获取系统管理员业务接口
	 * @return
	 */
	public abstract ISystemUserService getSystemUserService();
	/**
	 * 获取资源管理业务接口
	 * @return
	 */
	public abstract IResourcesService getResourcesService();
	/**
	 * 
	 * @return
	 */
	public abstract ICooperationService getCooperationService();
	/**
	 * 获取会员管理业务接口
	 * @return
	 */
	public abstract IUserMemberService getUserMemberService();
	
	public abstract ICooperationTypeService getCooperationTypeService();
	public abstract IRoleService getRoleService();
	public abstract IAreaService getAreaService();
	public abstract IMenuService getMenuService();
	public abstract IAppraiseService getAppraiseService();
	
}
