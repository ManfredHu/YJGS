package com.yjgs.bll.ibll;

import java.util.ArrayList;

import com.yjgs.dcl.Advice;

public interface IAdviceForUserBll {

	/**
	 * 加载指定页码的建议反馈
	 * 
	 * @param fPage	页码（第几页）
	 * @return			指定页码的建议反馈信息的集合
	 */
	public ArrayList<Advice> loadAdvicesByPage(int fPage);
	
	/**
	 * 获取建议反馈列表总页数
	 * 
	 * @return	返回总页数
	 */
	public int getSumOfPage();
	
	/**
	 * 提交一条新的建议反馈
	 * 
	 * @param fAdvice	新的建议反馈信息
	 * @return				返回是否成功添加
	 */
	public boolean submitNewAdvice(Advice fAdvice);
}
