package com.yjgs.bll.ibll;

import java.util.ArrayList;

import com.yjgs.dcl.Function;

public interface IFunctionManageBll {

	/**
	 * 加载所有一级功能状态
	 * 
	 * @return	返回一级功能状态信息集合
	 */
	public ArrayList<Function> loadStatus();
	
	/**
	 * 更新一级功能状态
	 * 
	 * @param functions	一级功能状态信息集合
	 * @return					是否成功更新
	 */
	public boolean updateStatus(ArrayList<Function> functions);
}
