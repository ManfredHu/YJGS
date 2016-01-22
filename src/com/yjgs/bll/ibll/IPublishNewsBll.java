package com.yjgs.bll.ibll;

import java.util.ArrayList;

import com.yjgs.dcl.News;
import com.yjgs.dcl.NewsPicture;

public interface IPublishNewsBll {
	
	/**
	 * 发布新闻
	 * @param fNews				新闻详细信息
	 * @param fNewsPictures		新闻图片数据数组
	 * @return
	 */
	public boolean AddNews(News fNews,ArrayList<NewsPicture> fNewsPictures); 

}
