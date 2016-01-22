package com.yjgs.bll.ibll;

import com.yjgs.dcl.News;

public interface IManaNewsInfoBll {
	
	/**
	 * 删除新闻信息
	 * @param fNews				待删出的新闻信息
	 * @return					是否删除成功
	 */
	public boolean DeleteInfo(News fNews);

	/**
	 * 修改新闻信息
	 * @param fNews				要修改的新闻信息
	 * @return					是否修改成功
	 */
	public boolean UpdateInfo(News fNews);
	
}
