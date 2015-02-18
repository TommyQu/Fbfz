package com.softfz.service;

import com.softfz.model.Appraise;
import com.softfz.model.PageModel;

public interface IAppraiseService {
	PageModel queryAppraise(Appraise appraise, int currentPage,
			int pageSize);

	void delete(int appid);
}
