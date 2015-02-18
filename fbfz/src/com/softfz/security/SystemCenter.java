package com.softfz.security;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.softfz.model.SystemUser;
import com.softfz.service.factory.ServiceFactory;

public class SystemCenter {
	private List<String> allProctedURI;
	private Map<Integer, List<String>> roleResoures;
	private static SystemCenter instance = new SystemCenter();

	private SystemCenter() {
		// 初始化allProctedURI
		this.allProctedURI = ServiceFactory.getInstance().getResourcesService()
				.getAllResources();
		// 初始化roleResoures
		this.roleResoures = ServiceFactory.getInstance().getResourcesService()
				.getRoleResourcesRelation();

	}

	public static SystemCenter getInstance() {
		return instance;
	}

	public void login(HttpServletRequest request, SystemUser systemUser) {
		HttpSession session = request.getSession();
		session.setAttribute("systemusser", systemUser);
	}

	public void logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("systemusser");
	}

	public SystemUser getCurrentLoginUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return (SystemUser) session.getAttribute("systemusser");
	}

	public boolean hasPermission(HttpServletRequest request) {
		// 0。判断当前用户是否已经登录
		SystemUser systemUser = getCurrentLoginUser(request);
		if (systemUser == null||systemUser.getState()==2) {
			return false;
		}
		// 1。判断当前请求是否需要 受到保护
		// 1.1获取当前的请求的URI
		String requesturi = request.getRequestURI();
		// 1.2获取上下文路径
		String contextPath = request.getContextPath();
		String uri = requesturi.substring(contextPath.length() + 1);
		boolean flag = this.allProctedURI.contains(uri);
		if (!flag) {
			return true;
		} else {
			// 2。如果有受到保护，判断当前请求是否在当前登录的用户的访问范围内。
			// 2.1获取当前登录用户的角色
			List<Integer> roleids = systemUser.getUserroles();
			for (Integer roleid : roleids) {
				List<String> rs = this.roleResoures.get(roleid);
				if (rs.contains(uri)) {
					return true;
				}
			}
			return false;
		}
	}
}
