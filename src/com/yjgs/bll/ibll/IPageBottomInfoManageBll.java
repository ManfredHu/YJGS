package com.yjgs.bll.ibll;

import java.util.ArrayList;

import com.yjgs.dcl.PageBottomInfo;

public interface IPageBottomInfoManageBll {

	/**
	 * 加载所有的底部信息
	 * 
	 * @return	返回底部信息集合
	 */
	public ArrayList<PageBottomInfo> loadInfos();
	
	/**
	 * 更新底部信息
	 * 
	 * @param fInfos		新的底部信息集合
	 * @return				返回是否更新成功
	 */
	public boolean updateInfo(ArrayList<PageBottomInfo> fInfos);
}
