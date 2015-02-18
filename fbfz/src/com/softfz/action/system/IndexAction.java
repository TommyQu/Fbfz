package com.softfz.action.system;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.softfz.model.MenuInfo;
import com.softfz.model.SystemUser;
import com.softfz.security.SystemCenter;
import com.softfz.service.FBfzServiceException;
import com.softfz.service.ISystemUserService;
import com.softfz.service.factory.ServiceFactory;

public class IndexAction extends ActionSupport implements
		ModelDriven<SystemUser> {
	private SystemUser user = new SystemUser();
	private List<MenuInfo> menus;
	private ISystemUserService systemUserService;

	public IndexAction() {
		this.systemUserService = ServiceFactory.getInstance()
				.getSystemUserService();
	}

	public String index() throws Exception {
		// 获取用户拥有的菜单
		HttpServletRequest request = ServletActionContext.getRequest();
		SystemCenter center = SystemCenter.getInstance();
		SystemUser user = center.getCurrentLoginUser(request);
		int userid = user.getUserid();
		menus=this.systemUserService.getUserMenus(userid);
		return SUCCESS;
	}

	public String login() throws Exception {
		// 为下一次保留保留登录名
		HttpServletResponse response = ServletActionContext.getResponse();
		Cookie cookie = new Cookie("loginname", user.getLoginname());
		cookie.setPath("/");
		cookie.setMaxAge(7 * 24 * 60 * 60);
		response.addCookie(cookie);
		try {
			SystemUser systemUser = this.systemUserService.login(
					user.getLoginname(), user.getPassword());
			// 正常登录
			// 保留登录状态
			SystemCenter center = SystemCenter.getInstance();
			HttpServletRequest request = ServletActionContext.getRequest();
			center.login(request, systemUser);
			return "index";
		} catch (FBfzServiceException e) {
			this.addActionMessage(e.getMessage());
			return "input";
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionMessage("系统异常，请联系管理员");
			return "input";
		}

	}

	@Override
	public SystemUser getModel() {
		return user;
	}

	public List<MenuInfo> getMenus() {
		return menus;
	}

}
