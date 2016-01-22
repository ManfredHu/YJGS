package com.yjgs.dal;

import java.util.ArrayList;

import com.yjgs.dcl.OtherPicture;
import com.yjgs.dpl.OtherPictureDpl;

public class OtherPictureDal {

	/**
	 * 更新图片
	 * 
	 * @param fPicture		图片数据
	 * @return					返回是否更新成功
	 */
	public boolean updatePic(OtherPicture fPicture) {
		
		OtherPictureDpl opDpl = null;
		String sqlString = null;
		int reCount = 0;
		
		sqlString = String.format("UPDATE tb_other_picture"
				+ " SET FileName='%s', PictureAddr='%s', PictureBreAddr='%s' WHERE PictureType=%d "
				, fPicture.getFileName(),fPicture.getPictureAddr(),fPicture.getPictureBreAddr(),fPicture.getPitureType());
		
		opDpl = new OtherPictureDpl();
		reCount = opDpl.excuteUpdate(sqlString);
		
		if(reCount == 0) {
			
			sqlString = String.format("INSERT INTO tb_other_picture"
					+ "(FileName,PictureAddr,PictureBreAddr,PictureType) VALUES ('%s','%s','%s',%d)"
					, fPicture.getFileName(),fPicture.getPictureAddr(),fPicture.getPictureBreAddr(),fPicture.getPitureType());
			
			reCount = opDpl.excuteUpdate(sqlString);
			if(reCount == 0) return false;
			return true;
		}
		
		return true;
	}
	
	/**
	 * 获取当前的Logo图片
	 * 
	 * @return	返回Logo图片信息
	 */
	public OtherPicture getLogoPic() {
		
		OtherPictureDpl opDpl = null;
		ArrayList<OtherPicture> picture = null;
		String sqlString = null;
		
		sqlString = "SELECT * FROM tb_other_picture WHERE  PictureType = 0 ORDER BY PictureID DESC";
		
		opDpl = new OtherPictureDpl();
		picture = opDpl.excuteQuery(sqlString);
		
		if(picture.size()==0) return null;
		return picture.get(0);
	}
	
	/**
	 * 获取当前企业简介图片
	 * 
	 * @return		返回企业简介图片
	 */	
	public OtherPicture getIntroPic() {
		
		OtherPictureDpl opDpl = null;
		ArrayList<OtherPicture> picture = null;
		String sqlString = null;
		
		sqlString = "SELECT * FROM tb_other_picture WHERE  PictureType = 1 ORDER BY PictureID DESC";
		
		opDpl = new OtherPictureDpl();
		picture = opDpl.excuteQuery(sqlString);
		
		if(picture.size()==0) return null;
		return picture.get(0);
	}
}
