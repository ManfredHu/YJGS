package com.yjgs.dal.idal;

import java.util.ArrayList;

import com.yjgs.dcl.News;

public interface INewsDal {
	
	/**
	 * 添加新闻信息
	 * @param fNews			待添加的新闻信息
	 * @return				是否添加成功
	 */
	public boolean AddNews(News fNews);

	/**
	 * 删除新闻信息
	 * @param fNews			待删除的新闻信息
	 * @return				是否删除成功
	 */
	public boolean DeleteNews(News fNews);
	
	/**
	 * 修改新闻信息
	 * @param fNews			待修改的新闻信息
	 * @return				是否修改成功
	 */
	public boolean UPdateNews(News fNews);
	
	/**
	 * 查询系列新闻信息
	 * @param fNews			待查询的新闻信息
	 * @return				查询的新闻信息数据数组
	 */
	public ArrayList<News> SearchNews(News fNews);
	
	/**
	 * 查询具体新闻信息
	 * @param fNews			待查询的新闻信息
	 * @return				查询的新闻信息实体类
	 */
	public News SearchNew(News fNews);
	
	/**
	 * 查询有相应关键字的新闻信息
	 * 
	 * @param fKeyWord		相应关键字
	 * @return						新闻信息集合
	 */
	public ArrayList<News> SearchNew(String fKeyWord);
}
