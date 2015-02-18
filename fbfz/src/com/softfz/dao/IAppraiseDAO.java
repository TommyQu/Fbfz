package com.softfz.dao;

import com.softfz.model.Appraise;
import com.softfz.model.PageModel;

public interface IAppraiseDAO {
	PageModel queryAppraise(Appraise appraise, int currentPage,
			int pageSize);

	void delete(int appid);
}
