package com.yjgs.dal;

import java.util.ArrayList;

import com.yjgs.dal.idal.IFunctionDal;
import com.yjgs.dcl.Function;
import com.yjgs.dpl.FunctionDpl;

public class FunctionDal implements IFunctionDal {

	@Override
	public boolean updateFunctions(ArrayList<Function> fFunctions) {
		
		FunctionDpl funDpl = null;
		String sqlString = null;
		int reCount = 0;
		
		//步骤1：实例化包装类
		funDpl = new FunctionDpl();
		
		//步骤2：循环遍历权限申请集合、编写sql语句并注入相应数据、执行并判断是否成功
		for(Function aFunction : fFunctions) {
			
			sqlString = String.format("UPDATE tb_function "
					+ "SET Name = '%s', IsShow = %d WHERE FunctionID=%d"
					,aFunction.getName(),aFunction.isShow()? 1 : 0,aFunction.getFunctionID() );
			
			reCount = funDpl.excuteUpdate(sqlString);
			
			if(reCount <= 0 ) return false;
		}
		
		//若遍历成功，则返回True
		return true;
	}

	@Override
	public ArrayList<Function> getAllFunctions() {
		
		ArrayList<Function> functions = null;
		FunctionDpl funDpl = null;
		String sqlString = null;
		
		// 步骤1：实例化包装类并编辑SQL语句
		funDpl = new FunctionDpl();
		sqlString = "SELECT * FROM tb_function ORDER BY FunctionID ASC";
		
		//步骤2：执行SQL语句并接收权限数据集合
		functions = funDpl.excuteQuery(sqlString);
		
		// 步骤3：根据返回的数据集合判断查询是否成功
		// 成功返回数据集合、否则返回null
		if(functions.size() ==0) return null;
		return functions;
				
	}

}
