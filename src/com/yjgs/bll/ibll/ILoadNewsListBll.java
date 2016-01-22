package com.yjgs.bll.ibll;

import java.util.ArrayList;

import com.yjgs.dcl.NewsList;
import com.yjgs.dcl.NewsType;

/**
 * 新闻列表展示（新闻系列列表和新闻信息列表）
 * @author 周宇钦
 *
 */
public interface ILoadNewsListBll {
	
	/**
	 * 加载新闻系列列表
	 * 
	 * @return				新闻系列数据数组
	 */
	public ArrayList<NewsType> loadNewsTypeList();

	/**
	 * 加载具体页的新闻信息列表
	 * @param fpage					加载的页数
	 * @param fNewsType				新闻类型
	 * @return						新闻信息列表
	 */
	public ArrayList<NewsList> loadNewsList(int fpage,NewsType fNewsType);
}
