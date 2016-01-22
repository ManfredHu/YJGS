package com.yjgs.controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yjgs.publ.ImageCut;

/**
 * Servlet implementation class CropAvator
 */
public class CropAvator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CropAvator() {
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

		 int x = Integer.valueOf(request.getParameter("x"));
		 int y = Integer.valueOf(request.getParameter("y"));
		 int w = Integer.valueOf(request.getParameter("w"));
		 int h = Integer.valueOf(request.getParameter("h"));
		 HttpSession session = request.getSession(true);
		 String imgPhyPath = session.getAttribute("imgPhyPath").toString();
		 String imgPath = session.getAttribute("imgPath").toString();
		 
		 //切割图片
		 ImageCut imageCut = new ImageCut();
		 imageCut.cutImage(imgPhyPath, x, y, w, h);
		 
		 response.setContentType("text/html; charset=UTF-8");
		 response.getWriter().print(imgPath);
	}

}
