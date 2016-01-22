package com.yjgs.controller.advice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjgs.bll.AdviceBll;
import com.yjgs.dcl.Advice;

/**
 * Servlet implementation class deleteAdvice
 */
public class deleteAdvice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteAdvice() {
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
		
		int AdviceID = Integer.parseInt(request.getParameter("id"));
		
		Advice advice = new Advice();
		advice.setAdviceID(AdviceID);
		
		AdviceBll adviceBll = new AdviceBll();
		try {
			if(adviceBll.deleteAdvice(advice)){
				request.setAttribute("judge", "true");
				request.setAttribute("text", "删除申述！");
				request.setAttribute("URL", "ManageAdvice.jsp");
				request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
				return;
			}
		} catch (Exception e) {

			System.out.println("删除申述失败！");
			e.printStackTrace();
		}
	}

}
