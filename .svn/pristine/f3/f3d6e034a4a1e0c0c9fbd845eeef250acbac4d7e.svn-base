package com.yjgs.controller.functionManage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjgs.dal.FunctionDal;
import com.yjgs.dcl.Function;

public class FunctionManageSel extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		if (req.getParameter("product").equals("")
				|| req.getParameter("about").equals("")
				|| req.getParameter("news").equals("")
				|| req.getParameter("hire").equals("")
				|| req.getParameter("advertise").equals("")
				|| req.getParameter("contact").equals("")) {
			req.setAttribute("judge", "false");
			req.setAttribute("text", "功能名不能为空！");
			req.setAttribute("URL", "../FunctionManage/FunctionManage.jsp");
			req.getRequestDispatcher("../Master/handlePage.jsp").forward(req,
					resp);
			return;
		}

		ArrayList<Function> functions = new ArrayList<Function>();
		// 产品中心部分
		Function ff0 = new Function();
		ff0.setFunctionID(1);
		ff0.setName(req.getParameter("product"));
		ff0.setShow(req.getParameter("0").equals("yes") ? true : false);
		functions.add(ff0);
		// 关于我们部分
		Function ff1 = new Function();
		ff1.setFunctionID(2);
		ff1.setName(req.getParameter("about"));
		ff1.setShow(req.getParameter("1").equals("yes") ? true : false);
		functions.add(ff1);
		// 新闻中心部分
		Function ff2 = new Function();
		ff2.setFunctionID(3);
		ff2.setName(req.getParameter("news"));
		ff2.setShow(req.getParameter("2").equals("yes") ? true : false);
		functions.add(ff2);
		// 人才招聘部分
		Function ff3 = new Function();
		ff3.setFunctionID(4);
		ff3.setName(req.getParameter("hire"));
		ff3.setShow(req.getParameter("3").equals("yes") ? true : false);
		functions.add(ff3);
		// 建议反馈部分
		Function ff4 = new Function();
		ff4.setFunctionID(5);
		ff4.setName(req.getParameter("advertise"));
		ff4.setShow(req.getParameter("4").equals("yes") ? true : false);
		functions.add(ff4);
		// 联系我们部分
		Function ff5 = new Function();
		ff5.setFunctionID(6);
		ff5.setName(req.getParameter("contact"));
		ff5.setShow(req.getParameter("5").equals("yes") ? true : false);
		functions.add(ff5);
		FunctionDal fd = new FunctionDal();
		//更新数据
		if (fd.updateFunctions(functions)) {
			req.setAttribute("judge", "true");
			req.setAttribute("text", "修改成功！");
			req.setAttribute("URL", "../FunctionManage/FunctionManage.jsp");
			req.getRequestDispatcher("../Master/handlePage.jsp").forward(req,
					resp);
		} else {
			req.setAttribute("judge", "false");
			req.setAttribute("text", "修改失败！");
			req.setAttribute("URL", "../FunctionManage/FunctionManage.jsp");
			req.getRequestDispatcher("../Master/handlePage.jsp").forward(req,
					resp);
		}
	}
}
