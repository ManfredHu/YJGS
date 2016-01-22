package com.yjgs.dal;

import java.sql.Date;
import java.util.ArrayList;

import com.yjgs.dcl.News;
import com.yjgs.dcl.ProductList;
import com.yjgs.dpl.NewsDpl;
import com.yjgs.dpl.ProductListDpl;

public class NewsDal {

	public ArrayList<News> getNews(News fNews){
		
		//第一步，获取新闻ID
		
		int newsID = fNews.getNewsID();
		
		//第二步，编写sql语句，
		
		String strSql = "select * from tb_news where NewsID="+newsID+" "; 
		
		//第三步，执行数据包装类NewsDpl，获得新闻具体信息的数据集合
		
		ArrayList<News> news = new ArrayList<News>();
		NewsDpl pDl = new NewsDpl();
		news = pDl.excuteQuery(strSql);
		
		//第四步，返回该新闻具体信息数据集合
		
		return news;
	}
	
	public ArrayList<News> getNewsIDList(){

		//第1步，编写sql语句，
		
		String strSql = "select * from tb_news "; 
		
		//第2步，执行数据包装类NewsDpl，获得新闻具体信息的数据集合
		
		ArrayList<News> news = new ArrayList<News>();
		NewsDpl pDl = new NewsDpl();
		news = pDl.excuteQuery(strSql);
		
		//第3步，返回该新闻具体信息数据集合
		
		return news;
	}

	/**
	 * 删除新闻
	 * @param fProduct				封装有新闻ID的新闻实体类
	 * @return						是否删除成功。
	 */
	public boolean deleteNews(News fNews){
		
		//第一步，获取产品信息
		int newsID = fNews.getNewsID();
		
		//第二步，编写sql语句
		String strSql = "delete from tb_news where NewsID="+newsID+""; 
		
		//第三步，实例化数据操作类，声明、定义返回值
		int reCount = 0;
		NewsDpl pDl = new NewsDpl();
		
		//第四步，执行数据操作层方法，获取返回值
		reCount = pDl.excuteUpdate(strSql);
		
		//第五步，判断返回值是否为1，是则返回true，不是则返回false
		if(reCount==1) return true;
		else return false;
	}
	
	public boolean addNews(News fNews){
		
		//第一步，获取新闻信息
		int typeID 		= fNews.getTypeID();
		String title	= fNews.getTitle();
		String content  = fNews.getContent();
		Date publishTime= fNews.getPublishTime();
		
		//第二步，编写sql语句
		String strSql = "insert into tb_news (TypeID,Title,Content,PublishTime) value ("
				+ typeID
				+ ",'"
				+ title
				+ "','"
				+ content
				+ "',now())";

		//第三步，实例化包装类和返回值类型
		NewsDpl pDl = new NewsDpl();
		int addResult = 0;
		
		//第四步，执行数据包装层excuteUpdate（）方法获得返回值
		addResult = pDl.excuteUpdate(strSql);
		
		//第五步，判断返回结果，输出返回值
		if(addResult==1){
			return true;
		}
		else return false;
	}
	
	public boolean updateNews(News fNews){
		
		//第一步，获取所有产品信息
		int newsID		= fNews.getNewsID();
		int typeID 		= fNews.getTypeID();
		String title	= fNews.getTitle();
		String content  = fNews.getContent();
		//Date publishTime= fNews.getPublishTime();
		
		//第二步，编写sql语句
		String strSql = "update tb_news set TypeID=" + typeID
				+ ",Title='" + title + "',Content='" + content
				+ "',PublishTime=now() where NewsID="+newsID+""  ;

		//第三步，实例化包装类和返回值类型
		NewsDpl pDl = new NewsDpl();
		int addResult = 0;
		
		//第四步，执行数据包装层excuteUpdate（）方法获得返回值
		addResult = pDl.excuteUpdate(strSql);
		
		//第五步，判断返回结果，输出返回值
		if(addResult==1){
			return true;
		}
		else return false;
	}
	
	public News LoadNewsInfo(News fNews){
		
		int newsID = fNews.getNewsID();
		
		//第二步，编写sql语句，
		
		String strSql = "select * from tb_news where NewsID="+newsID+" "; 
		
		//第三步，执行数据包装类NewsDpl，获得新闻具体信息的数据集合
		
		ArrayList<News> news = new ArrayList<News>();
		NewsDpl pDl = new NewsDpl();
		news = pDl.excuteQuery(strSql);
		
		//第四步，返回该新闻具体信息数据集合
		
		return news.get(0);
	}
	
	/**
	 * 获取指定类别指定页码的新闻列表项集合
	 * 
	 * @param fProduct				新闻数据（类别）
	 * @param fPage					页码
	 * @return
	 */
	public ArrayList<News> getList(News fNews,int fPage) {
		
//		ProductListDpl pDpl = null;
//		ArrayList<ProductList> products = null;
//		String sqlString = null;
		
		NewsDpl nDpl = null;
		ArrayList<News> news = null;
		String sqlString = null;
		int startPage = 0;
		int pageSize = 8;	//一页8记录
		
		//步骤1：实例化包装类
		nDpl = new NewsDpl();
		
		//步骤2：计算页的开始位置并编写SQL语句注入该数据
		startPage = pageSize*(fPage - 1);
		sqlString = String.format("SELECT * FROM tb_news"
				+ " %s ORDER BY PublishTime DESC LIMIT %d,%d", 
				fNews.getTypeID()==0? "":"WHERE TypeID =" + fNews.getTypeID()
				,startPage,pageSize);
		
		//步骤3：执行SQ语句并根据返回的数据集合判断查询是否成功
		news = nDpl.excuteQuery(sqlString);
		if(news.size() == 0) {
			return null;
		}
		return news;
	}
	
	public ArrayList<News> getAllNews(News fNews){
		
		//第一步，获取新闻ID
		
		int newsID = fNews.getTypeID();
		
		//第二步，编写sql语句，
		
		String strSql = "select * from tb_news where TypeID="+newsID+" "; 
		
		//第三步，执行数据包装类NewsDpl，获得新闻具体信息的数据集合
		
		ArrayList<News> news = new ArrayList<News>();
		NewsDpl pDl = new NewsDpl();
		news = pDl.excuteQuery(strSql);
		
		//第四步，返回该新闻具体信息数据集合
		
		return news;
	}
}
