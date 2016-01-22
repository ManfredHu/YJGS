package com.yjgs.bll.ibll;

import java.util.ArrayList;

import com.yjgs.dcl.Advice;

public interface IAdviceManageBll {

	/**
	 * 获取建议反馈列表总页数
	 * 
	 * @return	返回总页数
	 */
	public int getSumOfPage();
	
	/**
	 * 加载具体页码的建议反馈
	 * 
	 * @param fPage	页码
	 * @return			建议反馈信息集合
	 */
	public ArrayList<Advice> loadAdvices(int fPage);
	
	/**
	 * 回复建议反馈
	 * 
	 * @param fReply		回复的内容
	 * @return				是否回复成功
	 */
	public boolean replyAdvice(Advice fReply);
	
	/**
	 * 批量删除建议反馈
	 * 
	 * @param fAdvices	需要删除的建议反馈集合
	 * @return				返回是否删除成功
	 */
	public boolean deleteAdvices(ArrayList<Advice> fAdvices);
}
