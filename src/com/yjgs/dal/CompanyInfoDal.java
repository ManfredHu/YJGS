package com.yjgs.dal;

import java.util.ArrayList;

import com.yjgs.dal.idal.ICompanyInfoDal;
import com.yjgs.dcl.CompanyInfo;
import com.yjgs.dpl.CompanyInfoDpl;

public class CompanyInfoDal implements ICompanyInfoDal {

	@Override
	public boolean updateInfo(CompanyInfo fInfo) {
		
		CompanyInfoDpl ciDpl = null;
		String sqlString = null;
		int reCount = 0;
		
		//步骤1：实例化包装类并编写SQL语句
		ciDpl = new CompanyInfoDpl();
		sqlString = String.format("UPDATE tb_company_info SET InfoContent ='%s'"
				+ "WHERE InfoID = %d",fInfo.getInfoContent(),fInfo.getInfoID());
		
		//步骤2：执行SQL语句并接收受影响行数
		reCount = ciDpl.excuteUpdate(sqlString);
		
		//步骤3：根据受影响行数判断添加是否成功
		if(reCount <= 0) {
			return false;
		}
		else {
			return true;
		}
		
	}

	@Override
	public CompanyInfo getAInfo(CompanyInfo fInfo) {
		
		ArrayList<CompanyInfo> info = null;
		CompanyInfoDpl ciDpl = null;	
		String sqlString = null;
		int infoType = 0;
		
		//步骤1：实例化包装类
		ciDpl = new CompanyInfoDpl();
		
		//步骤2：将企业信息类型转化为整数
		switch (fInfo.getInfoType()) {
		case INTRODUCE :
			infoType = 0;
			break;

		case CONTACTS :
			infoType = 1;
			break;
			
		case RECRUITMENT :
			infoType = 2;
			break;
		}
		
		//步骤3：编写相应SQL语句并注入转化后的企业类型数据
		sqlString = String.format("SELECT * FROM tb_company_info "
				+ "WHERE InfoType = %d", infoType);
		
		//步骤4：执行SQL语句并根据返回的数据集合判断是否查询成功
		//成功返回第一项,否则返回null
		info = ciDpl.excuteQuery(sqlString);
		if(info.size() ==0) return null;
		return info.get(0);
	}

	//由公司信息ID获取公司信息
	public CompanyInfo getInfo(CompanyInfo fInfo) {
		
		ArrayList<CompanyInfo> info = null;
		CompanyInfoDpl ciDpl = null;	
		String sqlString = null;
		int infoType = 0;
		
		//步骤1：实例化包装类
		ciDpl = new CompanyInfoDpl();
		
		
		//步骤3：编写相应SQL语句并注入转化后的企业类型数据
		sqlString = String.format("SELECT * FROM tb_company_info "
				+ "WHERE InfoID = %d", fInfo.getInfoID());
		
		//步骤4：执行SQL语句并根据返回的数据集合判断是否查询成功
		//成功返回第一项,否则返回null
		info = ciDpl.excuteQuery(sqlString);
		if(info.size() ==0) return null;
		return info.get(0);
	}
	//增加记录
	public boolean addInfo(CompanyInfo fInfo) {
		
		CompanyInfoDpl ciDpl = null;
		String sqlString = null;
		int reCount = 0;
		int infoType = 0;
		
		switch (fInfo.getInfoType()) {
		case INTRODUCE :
			infoType = 0;
			break;

		case CONTACTS :
			infoType = 1;
			break;
			
		case RECRUITMENT :
			infoType = 2;
			break;
		}
		
		//步骤1：实例化包装类并编写SQL语句
		ciDpl = new CompanyInfoDpl();
		sqlString = String.format("Insert into tb_company_info (InfoContent,InfoType) value ('%s',%d)",fInfo.getInfoContent(),infoType);
		
		//步骤2：执行SQL语句并接收受影响行数
		reCount = ciDpl.excuteUpdate(sqlString);
		
		//步骤3：根据受影响行数判断添加是否成功
		if(reCount <= 0) {
			return false;
		}
		else {
			return true;
		}
		
	}
	
	public ArrayList<CompanyInfo> getAllInfo(CompanyInfo fInfo) {
		
		ArrayList<CompanyInfo> info = null;
		CompanyInfoDpl ciDpl = null;	
		String sqlString = null;
		int infoType = 0;
		
		//步骤1：实例化包装类
		ciDpl = new CompanyInfoDpl();
		
		//步骤2：将企业信息类型转化为整数
		switch (fInfo.getInfoType()) {
		case INTRODUCE :
			infoType = 0;
			break;

		case CONTACTS :
			infoType = 1;
			break;
			
		case RECRUITMENT :
			infoType = 2;
			break;
		}
		
		//步骤3：编写相应SQL语句并注入转化后的企业类型数据
		sqlString = String.format("SELECT * FROM tb_company_info "
				+ "WHERE InfoType = %d", infoType);
		
		//步骤4：执行SQL语句并根据返回的数据集合判断是否查询成功
		//成功返回第一项,否则返回null
		info = ciDpl.excuteQuery(sqlString);
		if(info.size() ==0) return null;
		return info;
	}
}
