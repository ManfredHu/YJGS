package com.yjgs.dal;

import java.util.ArrayList;

import com.yjgs.dal.idal.IFirstPageProductListDal;
import com.yjgs.dcl.FirstPageProductList;
import com.yjgs.dpl.FirstPageProductListDpl;

public class FirstPageProductListDal implements IFirstPageProductListDal {

	@Override
	public boolean addListItems(ArrayList<FirstPageProductList> fList) {
		
		FirstPageProductListDpl fpDpl = null;
		String sqlString = null;
		int reCount = 0;
		
		//步骤1：实例化包装类
		fpDpl = new FirstPageProductListDpl();
		
		//步骤2：循环遍历权限申请集合、编写sql语句并注入相应数据、执行并判断是否成功
		for(FirstPageProductList item : fList) {
			
			sqlString = String.format("INSERT INTO tb_firstpage_productlist "
					+ "(ProductID,SortingNum) "
					+ "VALUES (%d,%d)",item.getProductID(),item.getSortingNum());
			
			reCount = fpDpl.excuteUpdate(sqlString);
			
			if(reCount <= 0 ) return false;
		}
		
		//若遍历成功，则返回True
		return true;

	}

	@Override
	public boolean deleteListItems(ArrayList<FirstPageProductList> fList) {
		
		FirstPageProductListDpl fpDpl = null;
		String sqlString = null;
		int reCount = 0;
		
		//步骤1：实例化包装类
		fpDpl = new FirstPageProductListDpl();
		
		//步骤2：循环遍历权限申请集合、编写sql语句并注入相应数据、执行并判断是否成功
		for(FirstPageProductList item : fList) {
			
			sqlString = String.format("DELETE FROM tb_firstpage_productlist "
					+ "WHERE ListItemID = %d",item.getListItemID());
			
			reCount = fpDpl.excuteUpdate(sqlString);
			
			if(reCount <= 0 ) return false;
		}
		
		//若遍历成功，则返回True
		return true;

	}

	@Override
	public boolean updateListItems(ArrayList<FirstPageProductList> fList) {
		
		FirstPageProductListDpl fpDpl = null;
		String sqlString = null;
		int reCount = 0;
		
		//步骤1：实例化包装类
		fpDpl = new FirstPageProductListDpl();
		
		//步骤2：循环遍历权限申请集合、编写sql语句并注入相应数据、执行并判断是否成功
		for(FirstPageProductList item : fList) {
			
			sqlString = String.format("UPDATE tb_firstpage_productlist "
					+ "SET SortingNum = %d "
					+ "WHERE ListItemID = %d"
					,item.getSortingNum(),item.getListItemID());
			
			reCount = fpDpl.excuteUpdate(sqlString);
			
			if(reCount <= 0 ) return false;
		}
		
		//若遍历成功，则返回True
		return true;
	}

	@Override
	public ArrayList<FirstPageProductList> getAllTheList() {
		
		ArrayList<FirstPageProductList> list = null;
		FirstPageProductListDpl fpDpl = null;
		String sqlString = null;

		//步骤1：实例化包装类并编写查询SQL语句
		fpDpl = new FirstPageProductListDpl();
		sqlString = "SELECT * FROM tb_firstpage_productlist";
		
		//步骤2：执行SQL语句并接收权限数据集合
		list = fpDpl.excuteQuery(sqlString);
		
		// 步骤3：根据返回的数据集合判断查询是否成功
		// 成功返回数据集合、否则返回null
		if(list.size() == 0) return null;
		return list;
		
	}

}
