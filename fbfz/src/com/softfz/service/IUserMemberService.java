package com.softfz.service;

import com.softfz.model.PageModel;
import com.softfz.model.UserMember;

public interface IUserMemberService {
	/**
	 * 注册新会员
	 * @param member 会员对象
	 */
	public void saveUserMember(UserMember member);

	public PageModel queryUserMember(UserMember userMember, int currentPage,
			int pageSize);

	public void lockUserMember(UserMember member);

	public void unlockUserMember(UserMember userMember);

}
