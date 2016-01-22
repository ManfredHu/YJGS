package com.yjgs.bll;

import java.util.ArrayList;
import javax.servlet.jsp.JspWriter;
import com.yjgs.dal.FunctionDal;
import com.yjgs.dcl.Function;

public class FunctionManageBll {
	// 加载所以导航信息
	public void loadStatus(JspWriter fOut) {
		ArrayList<Function> functions = null;
		FunctionDal fDal = null;

		try {
			// 步骤1：取得所有一级导航79
			fDal = new FunctionDal();
			functions = fDal.getAllFunctions();
			// 如果无法获取数据库数据，抛出异常
			if (functions == null)
				throw new Exception("位置：功能数据层，描述：无法获取功能状态");
			// 步骤2：输出导航
			fOut.print("<form id='functionManageForm' action='FunctionManageSel' method='post'><ul>");
			// 判断哪个个单选框被选中，并输出不同的代码

			// 产品中心部分
			if (functions.get(0).isShow()) {
				fOut.println(String
						.format("<li><input class='textfield' onfocus='blue(this);' onblur='checkPass(this);' type='text' name='product' value='%s' /><div><label><input type='radio' name='0' value='yes' checked='checked' />显示</label>"
								+ "<label><input type='radio' name='0' value='no' />隐藏</label></div></li>",
								functions.get(0).getName()));
			} else {
				fOut.println(String
						.format("<li><input class='textfield' onfocus='blue(this);' onblur='checkPass(this);' type='text' name='product' value='%s' /><div><label><input type='radio' name='0' value='yes'  />显示</label>"
								+ "<label><input type='radio' name='0' value='no' checked='checked' />隐藏</label></div></li>",
								functions.get(0).getName()));
			}

			// 关于我们部分
			if (functions.get(1).isShow()) {
				fOut.println(String
						.format("<li><input class='textfield' onfocus='blue(this);' onblur='checkPass(this);' type='text' name='about' value='%s' /><div><label><input type='radio' name='1' value='yes' checked='checked' />显示</label>"
								+ "<label><input type='radio' name='1' value='no' />隐藏</label></div></li>",
								functions.get(1).getName()));
			} else {
				fOut.println(String
						.format("<li><input class='textfield' onfocus='blue(this);' onblur='checkPass(this);' type='text' name='about' value='%s' /><div><label><input type='radio' name='1' value='yes'  />显示</label>"
								+ "<label><input type='radio' name='1' value='no' checked='checked' />隐藏</label></div></li>",
								functions.get(1).getName()));
			}

			// 新闻中心部分
			if (functions.get(2).isShow()) {
				fOut.println(String
						.format("<li><input class='textfield' onfocus='blue(this);' onblur='checkPass(this);' type='text' name='news' value='%s' /><div><label><input type='radio' name='2' value='yes' checked='checked' />显示</label>"
								+ "<label><input type='radio' name='2' value='no' />隐藏</label></div></li>",
								functions.get(2).getName()));
			} else {
				fOut.println(String
						.format("<li><input class='textfield' onfocus='blue(this);' onblur='checkPass(this);' type='text' name='news' value='%s' /><div><label><input type='radio' name='2' value='yes' />显示</label>"
								+ "<label><input type='radio' name='2' value='no' checked='checked' />隐藏</label></div></li>",
								functions.get(2).getName()));
			}

			// 人才招聘部分
			if (functions.get(3).isShow()) {
				fOut.println(String
						.format("<li><input class='textfield' onfocus='blue(this);' onblur='checkPass(this);' type='text' name='hire' value='%s' /><div><label><input type='radio' name='3' value='yes' checked='checked' />显示</label>"
								+ "<label><input type='radio' name='3' value='no' />隐藏</label></div></li>",
								functions.get(3).getName()));
			} else {
				fOut.println(String
						.format("<li><input class='textfield' onfocus='blue(this);' onblur='checkPass(this);' type='text' name='hire' value='%s' /><div><label><input type='radio' name='3' value='yes' />显示</label>"
								+ "<label><input type='radio' name='3' value='no' checked='checked' />隐藏</label></div></li>",
								functions.get(3).getName()));
			}

			// 建议反馈部分
			if (functions.get(4).isShow()) {
				fOut.println(String
						.format("<li><input class='textfield' onfocus='blue(this);' onblur='checkPass(this);' type='text' name='advertise' value='%s' /><div><label><input type='radio' name='4' value='yes' checked='checked' />显示</label>"
								+ "<label><input type='radio' name='4' value='no' />隐藏</label></div></li>",
								functions.get(4).getName()));
			} else {
				fOut.println(String
						.format("<li><input class='textfield' onfocus='blue(this);' onblur='checkPass(this);' type='text' name='advertise' value='%s' /><div><label><input type='radio' name='4' value='yes'  />显示</label>"
								+ "<label><input type='radio' name='4' value='no' checked='checked' />隐藏</label></div></li>",
								functions.get(4).getName()));
			}

			// 联系我们部分
			if (functions.get(5).isShow()) {
				fOut.println(String
						.format("<li><input class='textfield' onfocus='blue(this);' onblur='checkPass(this);' type='text' name='contact' value='%s' /><div><label><input type='radio' name='5' value='yes' checked='checked' />显示</label>"
								+ "<label><input type='radio' name='5' value='no' />隐藏</label></div></li>",
								functions.get(5).getName()));
			} else {
				fOut.println(String
						.format("<li><input class='textfield' onfocus='blue(this);' onblur='checkPass(this);' type='text' name='contact' value='%s' /><div><label><input type='radio' name='5' value='yes' />显示</label>"
								+ "<label><input type='radio' name='5' value='no' checked='checked' />隐藏</label></div></li>",
								functions.get(5).getName()));
			}
			fOut.println("</ul><input id='sureBtn' onclick='return checkAll();' class='surebtn' type='submit' value='确定' /></form>");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("功能状态加载异常！");
		}

	}

	public boolean updateStatus(ArrayList<Function> functions) {
		return false;

	}

}
