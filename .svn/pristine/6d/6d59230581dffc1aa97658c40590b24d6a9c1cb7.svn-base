package com.yjgs.dal;

import java.util.ArrayList;

import com.yjgs.dal.idal.IPageBottomInfoDal;
import com.yjgs.dcl.PageBottomInfo;
import com.yjgs.dpl.PageBottomInfoDpl;


public class PageBottomInfoDal implements IPageBottomInfoDal {

	@Override
	public boolean addInfos(ArrayList<PageBottomInfo> fInfos) {
		
		PageBottomInfoDpl pbDpl = null;
		String sqlString = null;
		int reCount = 0;
		
		// 步骤1：实例化包装类
		pbDpl = new PageBottomInfoDpl();

		// 步骤2：循环遍历权限申请集合、编写sql语句并注入相应数据、执行并判断是否成功
		for (PageBottomInfo info : fInfos) {

			sqlString = String.format("INSERT INTO tb_page_bottom_info "
					+ "(InfoName,InfoValue) "
					+ "VALUES ('%s','%s')",
					info.getInfoName(),info.getInfoValue());

			reCount = pbDpl.excuteUpdate(sqlString);

			if (reCount <= 0)
				return false;
		}

		// 若遍历成功，则返回True
		return true;

	}

	@Override
	public boolean deleteAllInfo() {
		
		PageBottomInfoDpl pbDpl = null;
		String sqlString = null;
		int reCount = 0;
		
		// 步骤1：实例化包装类并编写SQL语句
		pbDpl = new PageBottomInfoDpl();
		sqlString = "DELETE FROM tb_page_bottom_info WHERE InfoID > 0";
		
		//步骤2：执行SQL语句获取受影响行数
		reCount = pbDpl.excuteUpdate(sqlString);
		
		//步骤3：根据受影响行数判断是否执行成功
		if (reCount == 0) return false;
		return true;
		
	}

	@Override
	public ArrayList<PageBottomInfo> getAllInfos() {
		
		ArrayList<PageBottomInfo> infos = null;
		PageBottomInfoDpl pbDpl = null;
		String sqlString = null;
		
		// 步骤1：实例化包装类并编写SQL语句
		pbDpl = new PageBottomInfoDpl();
		sqlString = "SELECT * FROM tb_page_bottom_info ORDER BY InfoID ASC";
		
		//步骤2：执行SQL语句并接收权限数据集合
		infos = pbDpl.excuteQuery(sqlString);
		
		// 步骤3：根据返回的数据集合判断查询是否成功
		// 成功返回数据集合、否则返回null
		if(infos.size() ==0) return null;
		return infos;
	}

}
