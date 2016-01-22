package com.yjgs.dal.idal;

import java.util.ArrayList;

import com.yjgs.dcl.News;
import com.yjgs.dcl.NewsPicture;

public interface INewsPictureDal {
	
	/**
	 * 批量添加新闻图片
	 * @param fNewsPictures				待添加的新闻图片数据数组
	 * @return							是否添加成功
	 */
	public boolean AddPictrue(ArrayList<NewsPicture> fNewsPictures);
	
	/**
	 * 添加新闻图片
	 * @param fNewsPicture				待添加的新闻图片数据数组
	 * @return							是否添加成功
	 */
	public boolean AddPictrue(NewsPicture fNewsPicture);
	
	/**
	 * 批量删除新闻图片
	 * @param fNewsPictures				待删除的新闻图片数据数组
	 * @return							是否删除成功
	 */
	public boolean DeletePictrue(ArrayList<NewsPicture> fNewsPictures);
	
	/**
	 * 删除新闻图片
	 * @param fNewsPicture				待删除的新闻图片数据
	 * @return							是否删除成功
	 */
	public boolean DeletePictrue(NewsPicture fNewsPicture);
	
	/**
	 * 批量修改新闻图片信息
	 * @param fNewsPictures				待修改的新闻图片数据数组
	 * @return							是否修改成功
	 */
	public boolean UpdatePictrue(ArrayList<NewsPicture> fNewsPictures);
	
	/**
	 * 修改单一新闻图片信息
	 * @param fNewsPicture				待修改的新闻图片数据
	 * @return							是否修改成功
	 */
	public boolean UpdatePictrue(NewsPicture fNewsPicture);
	
	/**
	 * 查找新闻图片信息
	 * @param fNews					待查询的新闻信息				
	 * @return						该新闻的所有图片
	 */
	public ArrayList<NewsPicture> searchPictures(News fNews);

}
