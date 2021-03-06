package com.yjgs.controller.permanage;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yjgs.dal.ManagerDal;
import com.yjgs.dcl.Manager;

/**
 * Servlet implementation class AccountValidate
 */
public class AccountValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountValidate() {
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
		
		ManagerDal mDal = null;
		ArrayList<Manager> managers = null;
		String userAccount = null;
		boolean isPass = true;
		
		// 步骤1：设置请求与相应的编码及文档格式
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		try {
			
			//步骤2：验证账号（不重复验证）
			mDal = new ManagerDal();
			managers = mDal.selectAllManager();
			userAccount = request.getParameter("userAccount");
			if(managers != null) {
				
				for(Manager aManager : managers) {
					
					if(aManager.getManagerAccount().equals(userAccount)) {
						
						isPass = false;
						break;
					}
				}
			}
			//输出验证结果
			response.getWriter().print(isPass);
			response.getWriter().flush();
			response.getWriter().close();
			
		} catch (Exception e) {
			
			System.out.println("数据验证异常");
			e.printStackTrace();
		}
		
		
	}

}
