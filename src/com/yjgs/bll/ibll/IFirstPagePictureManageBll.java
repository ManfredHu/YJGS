package com.yjgs.bll.ibll;

import java.util.ArrayList;

import com.yjgs.dcl.FirstPagePicture;

public interface IFirstPagePictureManageBll {

	/**
	 *加载所有首页图片信息
	 * 
	 * @return	返回首页图片信息集合
	 */
	public ArrayList<FirstPagePicture> loadPictures();
	
	/**
	 * 上传新的首页图片
	 * 
	 * @param fPicture	需要上传的首页图片信息
	 * @return				返回是否上传成功
	 */
	public boolean uploadNewPicture(FirstPagePicture fPicture);
	
	/**
	 * 批量删除首页图片
	 * 
	 * @param fPictures		需要删除的图片信息集合
	 * @return					返回是否删除成功
	 */
	public boolean deletePictures(ArrayList<FirstPagePicture> fPictures);
	
	/**
	 * 对首页图片进行重排序
	 * 
	 * @param fPictures		需要排序的图片信息集合
	 * @return					返回是否排序成功
	 */
	public boolean sortPictures(ArrayList<FirstPagePicture> fPictures);
}
