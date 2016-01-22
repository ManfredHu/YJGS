package com.yjgs.dal.idal;

import java.util.ArrayList;

import com.yjgs.dcl.NewsList;
import com.yjgs.dcl.NewsType;

/**
 * 新闻的列表展示数据操作层
 * @author 周宇钦
 *
 */
public interface INewsListDal {
	
	/**
	 * 新闻列表的数据展示
	 * @return			含有新闻信息的数据数组
	 */
	public ArrayList<NewsList> ShowList();
	
	/**
	 * 新闻列表的新闻系列数据展示
	 * @param fNewsType			新闻列表类型
	 * @return					含有新闻信息的数据数组
	 */
	public ArrayList<NewsList> ShowList(NewsType fNewsType);
	
	/**
	 * 查询一个列表项的详细信息
	 * 
	 * @param fList		列表项
	 * @return				返回新闻列表项详细信息
	 */
	public NewsList ShowList(NewsList fList);

}
