package com.softfz.service;

import java.util.List;

import com.softfz.model.PageModel;
import com.softfz.model.Role;

public interface IRoleService {

	//获取所有角色信息
	List<Role> getAllRoles();

	//分页查询所有角色
	PageModel queryRole(Role role, int currentPage, int pageSize);

	//保存角色
	void save(Role role);

	Role loadById(int rid);

	void update(Role role);

	void delete(Role role);

}
