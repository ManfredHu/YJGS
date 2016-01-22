package com.yjgs.dal;

import java.util.ArrayList;

import com.yjgs.dal.idal.IFirstPagePictureDal;
import com.yjgs.dcl.FirstPagePicture;
import com.yjgs.dpl.FirstPagePictureDpl;


public class FirstPagePictureDal implements IFirstPagePictureDal {

	@Override
	public boolean addPicture(FirstPagePicture fPicture) {
		
		FirstPagePictureDpl fpDpl = null;
		String sqlString = null;
		int reCount = 0;
		
		//步骤1：实例化包装类并编写SQL语句
		fpDpl = new FirstPagePictureDpl();
		sqlString = String.format("INSERT INTO tb_firstpage_picture "
				+ "(FileName,PictureAddr,PictureBreAddr,SortingNum) "
				+ "VALUES ('%s','%s','%s',%d)"
				,fPicture.getFileName(),fPicture.getPictureAddr()
				,fPicture.getPictureBreAddr(),fPicture.getSortingNum());
		
		//步骤2：执行SQL语句并接收受影响行数
		reCount = fpDpl.excuteUpdate(sqlString);
		
		//步骤3：根据受影响行数判断添加是否成功
		if(reCount <= 0) {
			return false;
		}
		else {
			return true;
		}

	}

	@Override
	public boolean deletePicture(FirstPagePicture fPicture) {
		
		FirstPagePictureDpl fpDpl = null;
		String sqlString = null;
		int reCount = 0;
		
		//步骤1：实例化包装类并编写SQL语句
		fpDpl = new FirstPagePictureDpl();
		sqlString = String.format("DELETE FROM  tb_firstpage_picture "
				+ "WHERE PictureID = %d",fPicture.getPictureID());
		
		//步骤2：执行SQL语句并接收受影响行数
		reCount = fpDpl.excuteUpdate(sqlString);
		
		//步骤3：根据受影响行数判断添加是否成功
		if(reCount <= 0) {
			return false;
		}
		else {
			return true;
		}
		
	}

	@Override
	public boolean updatePictures(ArrayList<FirstPagePicture> fPictures) {
		
		FirstPagePictureDpl fpDpl = null;
		String sqlString = null;
		int reCount = 0;
		
		//步骤1：实例化包装类
		fpDpl = new FirstPagePictureDpl();
		
		//步骤2：循环遍历权限申请集合、编写sql语句并注入相应数据、执行并判断是否成功
		for(FirstPagePicture picture : fPictures) {
			
			//只更新序号
			sqlString = String.format("UPDATE tb_firstpage_picture "
					+ "SET SortingNum = %d WHERE PictureID=%d"
					,picture.getSortingNum(),picture.getPictureID());
			
			reCount = fpDpl.excuteUpdate(sqlString);
			
			if(reCount <= 0 ) return false;
		}
		
		//若遍历成功，则返回True
		return true;
		
	}

	@Override
	public ArrayList<FirstPagePicture> getAllPictures() {
		
		ArrayList<FirstPagePicture> pictures = null;
		FirstPagePictureDpl fpDpl = null;
		String sqlString = null;
		
		// 步骤1：实例化包装类
		fpDpl = new FirstPagePictureDpl();
		sqlString = "SELECT * FROM tb_firstpage_picture ORDER BY SortingNum ASC";
		
		//步骤2：执行SQL语句并接收权限数据集合
		pictures = fpDpl.excuteQuery(sqlString);
		
		// 步骤3：根据返回的数据集合判断查询是否成功
		// 成功返回数据集合、否则返回null
		if(pictures.size() ==0) return null;
		return pictures;
	}
	
	public FirstPagePicture getTheEndPic() {
		
		ArrayList<FirstPagePicture> pictures = null;
		FirstPagePictureDpl fpDpl = null;
		String sqlString = null;
		
		// 步骤1：实例化包装类
		fpDpl = new FirstPagePictureDpl();
		sqlString = "SELECT * FROM tb_firstpage_picture WHERE SortingNum "
				+ "in(SELECT MAX(SortingNum) FROM tb_firstpage_picture) ";
		
		//步骤2：执行SQL语句并接收权限数据集合
		pictures = fpDpl.excuteQuery(sqlString);
		
		// 步骤3：根据返回的数据集合判断查询是否成功
		// 成功返回数据集合、否则返回null
		if(pictures.size() ==0) return null;
		return pictures.get(0);
		
	}
	
	/**
	 * 获取图片的详细信息
	 * 
	 * @param fPicture		图片数据
	 * @return					返回图片信息
	 */
	public FirstPagePicture getAPicture(FirstPagePicture fPicture) {
		
		ArrayList<FirstPagePicture> pictures = null;
		FirstPagePictureDpl fpDpl = null;
		String sqlString = null;
		
		// 步骤1：实例化包装类
		fpDpl = new FirstPagePictureDpl();
		sqlString = "SELECT * FROM tb_firstpage_picture WHERE PictureID =" + fPicture.getPictureID();
		
		//步骤2：执行SQL语句并接收权限数据集合
		pictures = fpDpl.excuteQuery(sqlString);
		
		// 步骤3：根据返回的数据集合判断查询是否成功
		// 成功返回数据集合、否则返回null
		if(pictures.size() ==0) return null;
		return pictures.get(0);
		
	}
	
	/**
	 * 根据排列序号获取图片
	 * 
	 * @param fPicture		图片信息（含序号）
	 * @return					返回图片完整信息
	 */
	public FirstPagePicture getPicBySort(FirstPagePicture fPicture) {
		
		ArrayList<FirstPagePicture> pictures = null;
		FirstPagePictureDpl fpDpl = null;
		String sqlString = null;
		
		// 步骤1：实例化包装类
		fpDpl = new FirstPagePictureDpl();
		sqlString = "SELECT * FROM tb_firstpage_picture WHERE SortingNum =" + fPicture.getSortingNum();
		
		//步骤2：执行SQL语句并接收权限数据集合
		pictures = fpDpl.excuteQuery(sqlString);
		
		// 步骤3：根据返回的数据集合判断查询是否成功
		// 成功返回数据集合、否则返回null
		if(pictures.size() ==0) return null;
		return pictures.get(0);
	}

}
