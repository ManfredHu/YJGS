package com.yjgs.dal;

import java.util.ArrayList;

import com.yjgs.dcl.ProductParam;
import com.yjgs.dpl.ProductParamDpl;

public class ProductParamDal {

	/**
	 * 查询产品参数
	 * @param fProductParam			具体产品参数信息
	 * @return						含有该产品的所有参数
	 */
	public ArrayList<ProductParam> getParam(ProductParam fProductParam){
		
		//第一步，获取信息
		
		int productID = fProductParam.getProductID();
		
		//第二步，编写sql语句，
		
		String strSql = "select * from tb_product_param where ProductID="+productID+" "; 
		
		//第三步，执行数据包装类ProductParamDpl，获得产品参数具体信息的数据集合
		
		ArrayList<ProductParam> productParams = new ArrayList<ProductParam>();
		ProductParamDpl pDl = new ProductParamDpl();
		productParams = pDl.excuteQuery(strSql);
		
		//第四步，返回该产品系列具体信息数据集合
		
		return productParams;
	}
	
	/**
	 * 删除产品参数
	 * @param fProductParam			具体产品参数
	 * @return									是否删除成功
	 */
	public boolean deleteParam(ProductParam fProductParam){
		
		ProductParamDpl ppDpl = null;
		String sqlString = null;
		int reCount = 0;
		
		//步骤1：编写SQL语句
		sqlString = String.format("DELETE FROM tb_product_param WHERE ProductID= %d"
				, fProductParam.getProductID());
		
		//步骤2：调用DPL执行SQL语句
		ppDpl = new ProductParamDpl();
		reCount = ppDpl.excuteUpdate(sqlString);
		
		//步骤3：判断并返回
		if(reCount == 0) return false;
		return true;
	}
	
	/**
	 * 增加产品参数
	 * @param fProductParam				待增加的产品参数信息
	 * @return							是否增加成功
	 */
	public boolean addParam(ProductParam fProductParam){
		
		//第一步，获取信息
		int 	productID	= 	fProductParam.getProductID();
		String 	paramName	= 	fProductParam.getParamName();
		String 	paramValue	=	fProductParam.getParamValue();
		
		//第二步，编写sql语句
		String strSql = "insert into tb_product_param (ProductID,ParamName,ParamValue) value ("+productID+",'"+paramName+"','"+paramValue+"') ";

		//第三步，实例化包装类和返回值类型
		ProductParamDpl pDl = new ProductParamDpl();
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
	 * 修改产品参数信息
	 * @param fProductParam				待修改的产品参数信息
	 * @return							是否修改成功
	 */
	public boolean updateParam(ProductParam fProductParam){
		
		//第一步，获取信息
		int 	paramID     = 	fProductParam.getParamID();
		String 	paramName	= 	fProductParam.getParamName();
		String 	paramValue	=	fProductParam.getParamValue();
		
		//第二步，编写sql语句
		String strSql = "update tb_product_param set ParamName='" + paramName
				+ "',ParamValue = '"+paramValue+"' where ParamID=" + paramID + "";
		

		//第三步，实例化包装类和返回值类型
		ProductParamDpl pDl = new ProductParamDpl();
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
