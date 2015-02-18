package com.softfz.dao;

import com.softfz.model.PageModel;
import com.softfz.model.UserMember;

public interface IUserMemberDAO {
	/**
	 * 通过登录名获取会员信息，如果不存在返回null,如果存在返回会员信息对象
	 * @param username 登录名
	 * @return 会员信息对象
	 */
	UserMember getUserMemberByUserName(String username);
	UserMember getUserMemberByUserId(int userid);
	/**
	 * 保存会员信息对象到会员信息表中
	 * @param member 会员信息对象
	 */
	void saveUserMember(UserMember member);
	PageModel queryUserMember(UserMember userMember, int currentPage,
			int pageSize);
	int updateUserMember(UserMember tmp);

}
