package com.yjgs.dal;

import java.util.ArrayList;

import com.yjgs.dcl.News;
import com.yjgs.dcl.NewsType;
import com.yjgs.dpl.NewsDpl;
import com.yjgs.dpl.NewsTypeDpl;

public class NewsTypeDal {

	public NewsType getNewsType(NewsType fNewsType){
		
		//第一步，获取新闻ID
		
		int typeID = fNewsType.getTypeID();
		
		//第二步，编写sql语句，
		
		String strSql = "select * from tb_news_type where TypeID="+typeID+" "; 
		
		//第三步，执行数据包装类NewsDpl，获得新闻具体信息的数据集合
		
		ArrayList<NewsType> news = new ArrayList<NewsType>();
		NewsTypeDpl pDl = new NewsTypeDpl();
		news = pDl.excuteQuery(strSql);
		
		//第四步，返回该新闻具体信息数据集合
		
		return news.get(0);
	}
	
	/**
	 * 获取所有新闻类别信息
	 * @param fNewsType
	 * @return
	 */
	public ArrayList<NewsType> getAllNewsType(){
		
		//第1步，编写sql语句，
		
		String strSql = "select * from tb_news_type "; 
		
		//第2步，执行数据包装类NewsDpl，获得新闻具体信息的数据集合
		
		ArrayList<NewsType> news = new ArrayList<NewsType>();
		NewsTypeDpl pDl = new NewsTypeDpl();
		news = pDl.excuteQuery(strSql);
		
		//第3步，返回该新闻具体信息数据集合
		
		return news;
	}

	/**
	 * 删除新闻
	 * @param fProduct				封装有新闻ID的新闻实体类
	 * @return						是否删除成功。
	 */
	public boolean deleteNewsType(NewsType fNewsType){
		
		//第一步，获取新闻信息
		int typeID = fNewsType.getTypeID();
		
		//第二步，编写sql语句
		String strSql = "delete from tb_news_type where TypeID="+typeID+""; 
		
		//第三步，实例化数据操作类，声明、定义返回值
		int reCount = 0;
		NewsTypeDpl pDl = new NewsTypeDpl();
		
		//第四步，执行数据操作层方法，获取返回值
		reCount = pDl.excuteUpdate(strSql);
		
		//第五步，判断返回值是否为1，是则返回true，不是则返回false
		if(reCount==1) return true;
		else return false;
	}
	
	public boolean addNewsType(NewsType fNewsType){
		
		//第一步，获取新闻信息
		String	typeName	= fNewsType.getTypeName();
		
		//第二步，编写sql语句
		String strSql = "insert into tb_news_type (TypeName) value ('"
				+ typeName
				+ "')";

		//第三步，实例化包装类和返回值类型
		NewsTypeDpl pDl = new NewsTypeDpl();
		int addResult = 0;
		
		//第四步，执行数据包装层excuteUpdate（）方法获得返回值
		addResult = pDl.excuteUpdate(strSql);
		
		//第五步，判断返回结果，输出返回值
		if(addResult==1){
			return true;
		}
		else return false;
	}
	
	public boolean updateNewsType(NewsType fNewsType){
		
		//第一步，获取所有产品信息
		int 	typeID		= fNewsType.getTypeID();
		String 	typeName	= fNewsType.getTypeName();
		
		//第二步，编写sql语句
		String strSql = "update tb_news_type set TypeName='" + typeName
				+ "' where TypeID="+typeID+" ";

		//第三步，实例化包装类和返回值类型
		NewsTypeDpl pDl = new NewsTypeDpl();
		int addResult = 0;
		
		//第四步，执行数据包装层excuteUpdate（）方法获得返回值
		addResult = pDl.excuteUpdate(strSql);
		
		//第五步，判断返回结果，输出返回值
		if(addResult==1){
			return true;
		}
		else return false;
	}
	
	//获取相应新闻类型的所有新闻
	public ArrayList<News> getTypeNews(NewsType fNewsType){
		
		//第一步，获取新闻ID
		
		int typeID = fNewsType.getTypeID();
		
		//第二步，编写sql语句，
		
		String strSql = "select * from tb_news where TypeID="+typeID+" "; 
		
		//第三步，执行数据包装类NewsDpl，获得新闻具体信息的数据集合
		
		ArrayList<News> news = new ArrayList<News>();
		NewsDpl pDl = new NewsDpl();
		news = pDl.excuteQuery(strSql);
		
		//第四步，返回该新闻具体信息数据集合
		
		return news;
	}
}
