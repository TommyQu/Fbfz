package com.softfz.dao;

import java.util.List;

import com.softfz.model.PageModel;
import com.softfz.model.Role;

public interface IRoleDAO {

	//获取所有角色信息
	List<Role> getAllRoles();

	PageModel queryRole(Role role, int currentPage, int pageSize);

	boolean isExit(Role role);

	int save(Role role);

	void saveRoleMenuRelation(int roleid, Integer menuid);

	void saveRoleResourceRelation(int roleid, Integer resourceid);

	Role loadById(int rid);

	void deleteRoleMenuRelation(Integer roleid);

	void deleteRoleResourceRelation(Integer roleid);

	boolean isTaken(Role role);

	void delete(Role role);


}
