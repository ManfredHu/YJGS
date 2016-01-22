package com.yjgs.controller.findPwd_complaint;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjgs.bll.ManagerBll;
import com.yjgs.dcl.Manager;
import com.yjgs.publ.MD5;

/**
 * Servlet implementation class UpdateRePasswordSel
 */
public class UpdateRePasswordSel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRePasswordSel() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int ManagerID = Integer.parseInt(request.getParameter("id"));
		
		ManagerBll managerBll = new ManagerBll();
		Manager manager = new Manager();
		manager.setPassword(MD5.GetMD5Code("8888"));
		manager.setManagerID(ManagerID);
		
		try {
			
			if(managerBll.UpdatePwd(manager)){
				System.out.println("修改原始密码成功！");
			}
		} catch (Exception e) {
			
			System.out.println("修改原始密码出错！");
			e.printStackTrace();
		}
	}

}
