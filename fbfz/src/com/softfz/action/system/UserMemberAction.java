package com.softfz.action.system;

import com.opensymphony.xwork2.ModelDriven;
import com.softfz.action.common.PageAction;
import com.softfz.model.UserMember;
import com.softfz.service.IUserMemberService;
import com.softfz.service.factory.ServiceFactory;

public class UserMemberAction extends PageAction implements ModelDriven<UserMember>{
	private UserMember userMember=new UserMember();
	private IUserMemberService iUserMemberService;
	public UserMemberAction()
	{
		iUserMemberService=ServiceFactory.getInstance().getUserMemberService();
	}
	public String query() throws Exception {
		pageModel = iUserMemberService.queryUserMember(userMember, currentPage,
				pageSize);
		return SUCCESS;
	}
	public String usermemberlocked() throws Exception
	{
		iUserMemberService.lockUserMember(userMember);
		return SUCCESS;
	}
	public String usermemberunlocked() throws Exception
	{
		iUserMemberService.unlockUserMember(userMember);
		return SUCCESS;
	}
	@Override
	public UserMember getModel() {
		// TODO Auto-generated method stub
		return userMember;
	}

}
