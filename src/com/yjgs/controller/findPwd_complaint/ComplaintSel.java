package com.yjgs.controller.findPwd_complaint;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yjgs.bll.ComplaintBll;
import com.yjgs.bll.ManagerBll;
import com.yjgs.dcl.Complaint;
import com.yjgs.dcl.Manager;

import java.util.regex.*;
/**
 * Servlet implementation class ComplaintSel
 */
public class ComplaintSel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComplaintSel() {
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

		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String complaintNum = request.getParameter("ComplaintNum");
		String complaintReason = request.getParameter("ComplaintReason");
		String email = request.getParameter("email");
		
		//验证数据全不能为空
		if(complaintNum==""||complaintReason==""||email==""){
			
			if(complaintNum==""){
				
				String errorInfo = String.format("Complaint.jsp?nullInfo=%s", "账号不能为空！");
				request.getRequestDispatcher(errorInfo).forward(request, response); 
				return ;
			}
			
			if(complaintReason==""){
				
				String errorInfo = String.format("Complaint.jsp?nullInfo=%s", "理由不能为空！");
				request.getRequestDispatcher(errorInfo).forward(request, response); 
				return ;
			}
			
			if(email==""){
				
				String errorInfo = String.format("Complaint.jsp?nullInfo=%s", "邮箱不能为空！");
				request.getRequestDispatcher(errorInfo).forward(request, response); 
				return ;
			}
		}
		
		//验证账号是否存在
		boolean istrue = NumIsNull(complaintNum);
		if(istrue==false){
			String errorInfo = String.format("Complaint.jsp?errorInfo=%s", "账号不存在！");
			request.getRequestDispatcher(errorInfo).forward(request, response); 
			return ;
		}
		
		//判断邮箱格式是否正确
		
		boolean isEmail = isEmail(email);
		{
			if(isEmail==false){
				String errorInfo = String.format("Complaint.jsp?"
						+ "nullInfo=%s", "邮箱格式错误！");
				request.getRequestDispatcher(errorInfo).forward(request, response); 
				return ;
			}
		}
		
		//进行添加申请操作
		Complaint complaint = new Complaint();
		complaint.setConplaintAccount(complaintNum);
		complaint.setConplaintReason(complaintReason);
		complaint.setEmail(email);
		
		ComplaintBll cBll = new ComplaintBll();
		try {
		
			boolean result = cBll.addComplaint(complaint);
			
			if(result==true){
				request.setAttribute("judge", "true");
				request.setAttribute("text", "申诉成功，请耐心等候管理员的回复！");
				request.setAttribute("URL", "../ManagerLogin/ManagerLogin.jsp");
				request.getRequestDispatcher("../Tips/NormalTips.jsp").forward(request, response);
				return;
			}
			
			else{
				request.setAttribute("judge", "false");
				request.setAttribute("text", "很抱歉，申诉失败，请再次填写申诉信息！");
				request.setAttribute("URL", "Complaint.jsp");
				request.getRequestDispatcher("../Tips/NormalTips.jsp").forward(request, response);
				return;
			}
				
		} catch (Exception e) {

			e.printStackTrace();
			request.setAttribute("judge", "false");
			request.setAttribute("text", "很抱歉，申诉失败，请再次填写申诉信息！");
			request.setAttribute("URL", "Complaint.jsp");
			request.getRequestDispatcher("../Tips/NormalTips.jsp").forward(request, response);
			return;
		}finally{
			HttpSession session =  request.getSession();
			session.removeAttribute("UserID");
		}
	}
	
	//判断账号是否存在
	public boolean NumIsNull(String managernum){
		
		Manager manager = new Manager();
		manager.setManagerAccount(managernum);
		
		ManagerBll mBll = new ManagerBll();
		boolean result = false;
		
		try{
			result = mBll.HasManager(manager);
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.print("数据操控层返回数据无值~");
		}
		
		if(result!=false){
			return true;
		}
		else return false;
	}

	//验证邮箱格式
	
	public boolean isEmail(String femail){
		
		String regEx = "\\w+@\\w+\\.\\w+";
		Pattern p=Pattern.compile(regEx);
		Matcher m=p.matcher(femail);
		boolean result=m.find();
		return result;
	}
}
