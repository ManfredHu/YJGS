package com.yjgs.bll;

import java.util.ArrayList;

import javax.servlet.jsp.JspWriter;

import com.yjgs.bll.ibll.ILoadMasterPageBll;
import com.yjgs.dcl.Function;
import com.yjgs.dcl.PageBottomInfo;
import com.yjgs.dal.FunctionDal;

public class LoadMasterPageBll implements ILoadMasterPageBll {
	
	/**
	 * 加载所有一级导航
	 */
	@Override
	public void loadFunctionStatus(JspWriter fOut) {
		
		ArrayList<Function> functions = null;
		FunctionDal fDal  = null;
 		
		
		try {
			//步骤1：获取所有功能状态
			fDal = new FunctionDal();
			functions = fDal.getAllFunctions();
			
			//如果无法获取数据库数据，抛出异常
			if(functions == null) throw new Exception("位置：功能数据层，描述：无法获取功能状态");
			
			fOut.println("<ul id='nav'>"+ "<li class='navli'><a href='../FirstPage/FirstPage.jsp'>首页</a></li>");
			//步骤2：遍历功能数据集合输出对应链接
			if(functions.get(0).isShow()) {
				fOut.println(String.format("<li id='liPro'><a class='oneli' href = '../Product/ProductList.jsp'>%s</a>",functions.get(0).getName()));
				fOut.println("<ul id='proNa'>");
				FirstPageManageBll fpBll = new FirstPageManageBll();
				fpBll.loadProductNvigator(fOut);
				fOut.println("</ul></li>");
			}
			
			if(functions.get(1).isShow()) fOut.println(String.format("<li class='navli'><a href = '../CompanyInfo/AboutUs.jsp'>%s</a></li>",
					functions.get(1).getName()));
			if(functions.get(2).isShow()) fOut.println(String.format("<li class='navli'><a href = '../News/ShowTypeNews.jsp'>%s</a></li>",
					functions.get(2).getName()));
			if(functions.get(3).isShow()) fOut.println(String.format("<li class='navli'><a href = '../CompanyInfo/loadRecruitment.jsp'>%s</a></li>",
					functions.get(3).getName()));
			if(functions.get(4).isShow()) fOut.println(String.format("<li class='navli'><a href = '../Advice/LoadAdvice.jsp'>%s</a></li>",
					functions.get(4).getName()));
			if(functions.get(5).isShow()) fOut.println(String.format("<li class='navli'><a href = '../CompanyInfo/loadCompanyRelation.jsp'>%s</a></li>",
					functions.get(5).getName()));
			fOut.println("</ul>");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("功能状态加载异常！开始加载备份链接...");
			try {
				fOut.println("<ul id='nav'>"+ "<li><a href='#'>首页</a></li>");
				fOut.println("<li><a href = '#'>产品中心</a></li>"
						+ "<li><a href = '#'>关于我们</a></li>"
						+ "<li><a href = '#'>新闻中心</a></li>"
						+ "<li><a href = '#'>人才招聘</a></li>"
						+ "<li><a href = '#'>建议反馈</a></li>"
						+ "<li><a href = '#'>联系我们</a></li>");
				fOut.write("</ul>");
			} catch (Exception e2) {
				e2.printStackTrace();
				System.out.println("备份链接加载异常！");
			}
		}
		
	}
	
	/**
	 * 加载页面底部信息
	 */
	@Override
	public ArrayList<PageBottomInfo> loadBottomInfos() {
		// TODO Auto-generated method stub
		return null;
	}

}
