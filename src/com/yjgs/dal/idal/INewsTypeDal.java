package com.yjgs.dal.idal;

import java.util.ArrayList;

import com.yjgs.dcl.News;

public interface INewsTypeDal {
	
	/**
	 * 增加新闻类型
	 * @param fNews			要增加的新闻信息
	 * @return				是否添加成功
	 */
	public boolean AddNewsType(News fNews);
	
	/**
	 * 批量增加新闻类别
	 * @param fNews			要增加的新闻信息数组
	 * @return				是否添加成功
	 */
	public boolean AddNewsType(ArrayList<News> fNews);

	/**
	 * 删除新闻类型
	 * @param fNews			要删除的新闻信息
	 * @return				是否删除成功
	 */
	public boolean DeleteNewsType(News fNews);
	
	/**
	 * 批量删除新闻类别
	 * @param fNews			要删除的新闻信息数组
	 * @return				是否删除成功
	 */
	public boolean DeleteNewsType(ArrayList<News> fNews);
	
	/**
	 * 修改新闻类型
	 * @param fNews			要修改的新闻信息
	 * @return				是否修改成功
	 */
	public boolean UpdateNewsType(News fNews);
	
	/**
	 * 批量修改新闻类别
	 * @param fNews			要修改的新闻信息
	 * @return				是否修改成功
	 */
	public boolean UpdateNewsType(ArrayList<News> fNews);
	
	/**
	 * 查询新闻类别
	 * @return			所有新闻的类别
	 */
	public ArrayList<News> SearchType();
}
