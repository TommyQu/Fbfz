package com.softfz.service.impl;

import com.softfz.dao.IUserMemberDAO;
import com.softfz.dao.factory.DAOFactory;
import com.softfz.model.PageModel;
import com.softfz.model.UserMember;
import com.softfz.security.password.MD5Strategy;
import com.softfz.security.password.PasswordStrategy;
import com.softfz.service.FBfzServiceException;
import com.softfz.service.IUserMemberService;

public class UserMemberServiceImpl implements IUserMemberService {
	private IUserMemberDAO memberDAO;
	private final static String PWD_SALT = "softfz";

	public UserMemberServiceImpl() {
		this.memberDAO = DAOFactory.getInstance().getUserMemberDAO();
	}

	public void saveUserMember(UserMember member) {
		UserMember tmp = this.memberDAO.getUserMemberByUserName(member
				.getUsername());
		if (tmp != null) {
			throw new FBfzServiceException("登录名已经被使用");
		}
		// 设置默认密码
		String password = "123456";
		PasswordStrategy strategy = new MD5Strategy();
		String pwd = strategy.encrypt(password, PWD_SALT);
		member.setPassword(pwd);
		// 保存
		this.memberDAO.saveUserMember(member);
	}

	@Override
	public PageModel queryUserMember(UserMember userMember, int currentPage,
			int pageSize) {
		// TODO Auto-generated method stub
		return memberDAO.queryUserMember(userMember,currentPage,pageSize);
	}

	@Override
	public void lockUserMember(UserMember member) {
		// TODO Auto-generated method stub
		
		UserMember tmp = this.memberDAO.getUserMemberByUserId(member.getUserid());
		tmp.setState(2);
		this.memberDAO.updateUserMember(tmp);
	}
	public void unlockUserMember(UserMember member) {
		// TODO Auto-generated method stub
		
		UserMember tmp = this.memberDAO.getUserMemberByUserId(member.getUserid());
		tmp.setState(1);
		this.memberDAO.updateUserMember(tmp);
	}
}
