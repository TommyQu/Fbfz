package com.softfz.action.android;

import java.util.List;

import com.softfz.model.CooperationType;
import com.softfz.service.FBfzServiceException;
import com.softfz.service.ICooperationTypeService;
import com.softfz.service.factory.ServiceFactory;

public class IndexAction extends AndroidBaseAction {
	
	private ICooperationTypeService typeService;

	public IndexAction() {
		typeService = ServiceFactory.getInstance().getCooperationTypeService();
	}
	private String username;
	private String task;
	public String list() throws Exception {
		System.out.println("接受手机端传递的参数：username="+username);
		System.out.println("接受手机端传递的参数：task="+task);
		try {
			List<CooperationType> list = typeService.getAllBigType();
			return success(list);
		} catch (FBfzServiceException e) {
			// 业务逻辑异常
			return fail(e.getMessage());
		} catch (Exception e) {
			// 系统异常
			return systemfail();
		}
		
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setTask(String task) {
		this.task = task;
	}
	
}
