package com.softfz.action.frontweb;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.softfz.model.UserMember;
import com.softfz.service.FBfzServiceException;
import com.softfz.service.IUserMemberService;
import com.softfz.service.factory.ServiceFactory;

public class UserMemberAction extends CenterAction implements
		ModelDriven<UserMember> {
	private UserMember member = new UserMember();
	private IUserMemberService userMemberService;
	private String checkpassword;// 用于接受客户端请求的确认密码

	public UserMemberAction() {
		userMemberService = ServiceFactory.getInstance().getUserMemberService();
	}

	public String register() throws Exception {
		if (checkpassword == null
				|| !checkpassword.equals(member.getPassword())) {
			// 密码和确认密码必须相等
			return goFail("密码和确认密码必须相等");
		}
		try {
			userMemberService.saveUserMember(member);
			// 正常注册
			return goSuccess("注册成功", "index.jsp");
		} catch (FBfzServiceException e) {
			// 业务逻辑异常
			return goFail(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			// 系统异常
			return goSystemFail();
		}
	}

	public UserMember getModel() {
		return member;
	}

	public String getCheckpassword() {
		return checkpassword;
	}

	public void setCheckpassword(String checkpassword) {
		this.checkpassword = checkpassword;
	}

}
