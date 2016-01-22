package com.yjgs.dal.idal;

import java.util.ArrayList;

import com.yjgs.dcl.Advice;

public interface IAdviceDal {

	/**
	 * 添加一条新的反馈记录
	 * 
	 * @param fAdvice	所要添加的反馈的信息
	 * @return				返回是否添加成功
	 */
	public boolean addAdvice(Advice fAdvice);
	
	/**
	 * 删除一条反馈记录
	 * 
	 * @param fAdvice	所要删除的反馈记录
	 * @return				返回是否删除成功
	 */
	public boolean deleteAdvices(ArrayList<Advice> fAdvices);
	
	/**
	 * 修改一条反馈记录
	 * 
	 * @param fAdvice	所要修改的反馈信息
	 * @return				返回是否修改成功
	 */
	public boolean updateAdvice(Advice fAdvice);
	
	/**
	 * 获得一条建议反馈的详细信息
	 * 
	 * @param fAdvice	所要获取的反馈的信息
	 * @return				返回反馈的详细信息
	 */
	public Advice getAdvice(Advice fAdvice);
	
	/**
	 * 返回指定页码指定类型的建议反馈记录
	 * 
	 * @param fPage			页码
	 * @param isReply		类型（是否回复）
	 * @return					指定的反馈记录集合
	 */
	public ArrayList<Advice> getAdvices(int fPage,boolean isReply);
	
	
	/**
	 * 返回指定类型的反馈记录数据的总页数
	 * 
	 * @param isReply	类型（是否回复）
	 * @return				指定类型记录的总页数
	 */
	public int getPageSum(boolean isReply);

	
	boolean deleteAdvice(Advice fAdvices);
	
}
