package com.yjgs.dal;

import java.util.ArrayList;

import com.yjgs.dcl.NewsPicture;
import com.yjgs.dpl.NewsPictureDpl;
public class NewsPictureDal {
	
	/**
	 * 查询对应新闻的所有图片信息
	 * @param fNewsPicture				待查询的新闻信息
	 * @return							具有新闻图片的数据集合
	 */
	public ArrayList<NewsPicture> getPicture(NewsPicture fNewsPicture){
		
		//第一步，获取信息
		
		int newsID = fNewsPicture.getNewsID();
		
		//第二步，编写sql语句，
		
		String strSql = "select * from tb_news_picture where NewsID="+newsID+" "; 
		
		//第三步，执行数据包装类NewsPictureDpl，获得新闻参数具体信息的数据集合
		
		ArrayList<NewsPicture> NewsPictures = new ArrayList<NewsPicture>();
		NewsPictureDpl pDl = new NewsPictureDpl();
		NewsPictures = pDl.excuteQuery(strSql);
		
		//第四步，返回该新闻系列具体信息数据集合
		
		return NewsPictures;
	}

	/**
	 * 删除新闻图片
	 * @param fNewsPicture			相应新闻图片信息
	 * @return							是否删除成功
	 */
	public boolean deletePicture(NewsPicture fNewsPicture){
		
		//第一步，获取信息
		int		newsPicID		= 	fNewsPicture.getNewsPicID();
		
		//第二步，编写sql语句
		String strSql = "delete from tb_news_picture where NewsPicID=" + newsPicID + "";

		//第三步，实例化包装类和返回值类型
		NewsPictureDpl pDl = new NewsPictureDpl();
		int reCount = 0;
		
		//第四步，执行数据包装层excuteUpdate（）方法获得返回值
		reCount = pDl.excuteUpdate(strSql);
		
		//第五步，判断返回结果，输出返回值
		if(reCount==1){
			return true;
		}
		else return false;
	}
	
	/**
	 * 增加新闻图片
	 * @param fNewsPicture				待增加的新闻图片信息
	 * @return								是否增加成功
	 */
	public boolean addPicture(NewsPicture fNewsPicture){
		
		//第一步，获取信息
		int		newsID			=	fNewsPicture.getNewsID();
		String	fileName		= 	fNewsPicture.getFileName();
		String	pictureAddr		=fNewsPicture.getPictureAddr();
		String	pictureBreAddr		=fNewsPicture.getPictureBreAddr();
		
		//第二步，编写sql语句
		String strSql = "insert into tb_news_picture (NewsID,FileName,PictureAddr,PictureBreAddr) value ('"+newsID+"','"+fileName+"','"+pictureAddr+"','"+pictureBreAddr+"') ";

		//第三步，实例化包装类和返回值类型
		NewsPictureDpl pDl = new NewsPictureDpl();
		int reCount = 0;
		
		//第四步，执行数据包装层excuteUpdate（）方法获得返回值
		reCount = pDl.excuteUpdate(strSql);
		
		//第五步，判断返回结果，输出返回值
		if(reCount==1){
			return true;
		}
		else return false;
	}

	/**
	 * 修改新闻图片信息
	 * @param fNewsPicture					待修改的新闻图片信息
	 * @return									是否修改成功
	 */
	public boolean updatePicture(NewsPicture fNewsPicture){
	
	//第一步，获取信息
		int		newsPicID		= 	fNewsPicture.getNewsPicID();
		String	fileName		= 	fNewsPicture.getFileName();
		String	pictureAddr		=fNewsPicture.getPictureAddr();
		String	pictureBreAddr		=fNewsPicture.getPictureBreAddr();
	
	//第二步，编写sql语句
	String strSql = "update tb_News_picture set FileName='" + fileName
			+ "',pictureAddr='"+pictureAddr+",poctureBreAddr='"+pictureBreAddr+"''where NewsPicID=" + newsPicID + "";
	

	//第三步，实例化包装类和返回值类型
	NewsPictureDpl pDl = new NewsPictureDpl();
	int reCount = 0;
	
	//第四步，执行数据包装层excuteUpdate（）方法获得返回值
	reCount = pDl.excuteUpdate(strSql);
	
	//第五步，判断返回结果，输出返回值
	if(reCount==1){
		return true;
	}
	else return false;
}

}
