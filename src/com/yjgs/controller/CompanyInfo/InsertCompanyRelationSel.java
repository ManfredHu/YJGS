package com.yjgs.controller.CompanyInfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yjgs.bll.CompanyInfoManagerBll;
import com.yjgs.dal.CompanyInfoDal;
import com.yjgs.dcl.CompanyInfo;
import com.yjgs.enumdata.CompanyInfoType;

/**
 * Servlet implementation class InsertCompanyRelationSel
 */
public class InsertCompanyRelationSel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCompanyRelationSel() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String text = request.getParameter("text");
		CompanyInfo companyInfo = new CompanyInfo();
		CompanyInfo companyInfo2 = new CompanyInfo();
		CompanyInfoManagerBll cbll = new CompanyInfoManagerBll();
		CompanyInfoDal typeDal = new CompanyInfoDal();
		CompanyInfoType cit = null;
		
		if(text==""){
			request.setAttribute("judge", "false");
			request.setAttribute("text", "添加企业信息不能为空！");
			request.setAttribute("URL", "../CompanyInfoManage/UpdateCompanyRelation.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
			return;
		}
		
		companyInfo.setInfoType(cit.CONTACTS);
		companyInfo2.setInfoType(cit.CONTACTS);
		companyInfo.setInfoContent(text);
		
		try {
			
			companyInfo2=typeDal.getAInfo(companyInfo);
			
			if(companyInfo2!=null){
				request.setAttribute("judge", "true");
				request.setAttribute("text", "企业联系方式已存在，请前往修改！");
				request.setAttribute("URL", "../CompanyInfoManage/UpdateCompanyRelation.jsp");
				request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
				return;
			}
			
			if(cbll.AddText(companyInfo)){
				request.setAttribute("judge", "true");
				request.setAttribute("text", "添加企业联系方式成功！");
				request.setAttribute("URL", "../CompanyInfoManage/UpdateCompanyRelation.jsp");
				request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
				return;
			}
		} catch (Exception e) {
			
			System.out.println("添加企业联系方式失败！");
			e.printStackTrace();
			request.setAttribute("judge", "false");
			request.setAttribute("text", "添加企业联系方式失败！");
			request.setAttribute("URL", "../CompanyInfoManage/UpdateCompanyRelation.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
			return;
		}
	}
	

}
