package com.yjgs.dal;


import com.yjgs.dal.idal.ICompanyInfoPictureDal;
import com.yjgs.dcl.CompanyInfoPicture;
import com.yjgs.dpl.CompanyInfoPictureDpl;

public class CompanyInfoPictureDal implements ICompanyInfoPictureDal {

	@Override
	public boolean addPicture(CompanyInfoPicture fPicture) {

		CompanyInfoPictureDpl cpDpl = null;
		String sqlString = null;
		int reCount = 0;
		
		//步骤1：实例化包装类并编写SQL语句
		cpDpl = new CompanyInfoPictureDpl();
		sqlString = String.format("INSERT INTO tb_company_info_picture "
				+ "(InfoID,FileName,PictureAddr,PictureBreAddr) "
				+ "VALUES (%d,'%s','%s','%s')"
				,fPicture.getInfoID(),fPicture.getFileName()
				,fPicture.getPictureAddr(),fPicture.getPictureBreAddr());
		
		//步骤2：执行SQL语句并接收受影响行数
		reCount = cpDpl.excuteUpdate(sqlString);
		
		//步骤3：根据受影响行数判断添加是否成功
		if(reCount <= 0) {
			return false;
		}
		else {
			return true;
		}
		
	}

	@Override
	public boolean deletePicture(CompanyInfoPicture fPicture) {

		CompanyInfoPictureDpl cpDpl = null;
		String sqlString = null;
		int reCount = 0;
		
		//步骤1：实例化包装类并编写SQL语句
		cpDpl = new CompanyInfoPictureDpl();
		sqlString = String.format("DELETE FROM  tb_company_info_picture"
				+ "WHERE PictureID = %d", fPicture.getPictureID());
		
		//步骤2：执行SQL语句并接收受影响行数
		reCount = cpDpl.excuteUpdate(sqlString);
		
		//步骤3：根据受影响行数判断添加是否成功
		if(reCount <= 0) {
			return false;
		}
		else {
			return true;
		}
	}

}
