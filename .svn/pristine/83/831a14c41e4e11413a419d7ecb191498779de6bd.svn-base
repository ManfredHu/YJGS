package com.yjgs.controller.findPwd_complaint;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jndi.url.corbaname.corbanameURLContextFactory;
import com.yjgs.bll.ComplaintBll;
import com.yjgs.bll.ManagerBll;
import com.yjgs.bll.PasswordProtectProblemBll;
import com.yjgs.dal.PasswordProtectProblemDal;
import com.yjgs.dcl.Complaint;
import com.yjgs.dcl.Manager;
import com.yjgs.dcl.PasswordProtectProblem;
import com.yjgs.publ.MD5;

/**
 * Servlet implementation class dealComplaintSel
 */
public class dealComplaintSel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dealComplaintSel() {
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

		int userID = Integer.parseInt(request.getParameter("UserID"));
		int ComplaintID = Integer.parseInt(request.getParameter("ComplaintID"));
		String ManagerName = request.getParameter("ManagerName");
		
		PasswordProtectProblem ppp = new PasswordProtectProblem();
		ppp.setManagerID(userID);
		
		Complaint complaint = new Complaint();
		complaint.setComplaintID(ComplaintID);
		ComplaintBll cBll = new ComplaintBll();
		
		ManagerBll managerBll = new ManagerBll();
		Manager manager = new Manager();
		manager.setPassword(MD5.GetMD5Code("8888"));
		manager.setManagerID(userID);
		
		PasswordProtectProblemBll pppBll = new PasswordProtectProblemBll();
		try {
			
			if(pppBll.deletePPP(ppp)){
				System.out.println("密保问题删除成功！");
				
				if(managerBll.UpdatePwd(manager)){
					System.out.println("密码重置成功成功！");
				}
				
				complaint=cBll.getComplaint(complaint);
				response.sendRedirect("ResponseComplaint.jsp?Id="+ComplaintID+"&ManaName='"+ManagerName+"'&UserID="+userID+"&email="+complaint.getEmail()+"");
			}
			else{
				if(managerBll.UpdatePwd(manager)){
					System.out.println("密码重置成功成功！");
				}
				
				complaint=cBll.getComplaint(complaint);
				response.sendRedirect("ResponseComplaint.jsp?Id="+ComplaintID+"&ManaName='"+ManagerName+"'&UserID="+userID+"&email="+complaint.getEmail()+"");
			}
		} catch (Exception e) {
		
			System.out.println("密保问题删除失败！");
			e.printStackTrace();
		}
	}

}
