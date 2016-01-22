package com.yjgs.controller.permanage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yjgs.bll.PermissionManageBll;
import com.yjgs.dcl.Manager;
import com.yjgs.dcl.Mapping_Manager_Permission;

/**
 * Servlet implementation class ModifyPermission
 */
public class ModifyPermission extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyPermission() {
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

		PermissionManageBll pBll = null;
		Map<Manager, ArrayList<Mapping_Manager_Permission>> 
		mapManagers = null; //Map类型
		
		// 步骤1：设置请求与相应的编码及文档格式
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//步骤2：将请求数据封装到实体类中,错误则直接退出
		mapManagers = packMapManagers(request);
		
		//步骤3：调用业务逻辑层，执行权限修改业务，并处理跳转
		pBll = new PermissionManageBll();
		if(pBll.modifyPermission(mapManagers)) {
			
			request.setAttribute("judge", "true");
			request.setAttribute("text", "成功修改权限");
			request.setAttribute("URL", "../PermissionManage/ManagerList.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
			return;
		}
		else {
			
			request.setAttribute("judge", "false");
			request.setAttribute("text", "修改失败，请重试");
			request.setAttribute("URL", "../PermissionManage/ManagerList.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
			return;
		}
		
	}
	
	/**
	 * 将请求数据封装到相应实体类（这里是Map类型）
	 * 
	 * @param fRequest			Servlet请求
	 * @return						管理员与权限映射的Map类型
	 */
	@SuppressWarnings("unchecked")
	private Map<Manager, ArrayList<Mapping_Manager_Permission>> 
	packMapManagers(HttpServletRequest fRequest) {

		Map<String, String[]> testData = null;
		String[]  keys = null;
		Map<Manager, ArrayList<Mapping_Manager_Permission>>
		mapManagers = null; 
		
		//实例化管理员权限的Map类型
		mapManagers = new HashMap<Manager, 
				ArrayList<Mapping_Manager_Permission>>();

		
		try {
			
			//步骤1：获取CheckBox的所有值（Map）
			testData = fRequest.getParameterMap();

			//步骤2：获取Keys即复选框Name的值
			Set<String> aSet = testData.keySet();
			keys = aSet.toArray(new String[aSet.size()]);

			//步骤3：编译正则表达式（用于获取用户ID）
			Pattern p = Pattern.compile("permission:(\\d*)");
			
			//步骤4：遍历Keys并封装相应管理员以及其权限数据
			for(String aKey : keys) {
				
				Manager manager = null;
				ArrayList<Mapping_Manager_Permission> permissions = null;
				
				//步骤4.1：获取管理员ID，封装管理员数据
				Matcher m = p.matcher(aKey);
				if(m.find()) {
					
					manager = new Manager();
					manager.setManagerID(Integer.valueOf(m.group(1)));
				}
				else throw new Exception("获取ID时错误");
				
				//步骤4.2：获取相应管理员权限，并封装权限映射数据
				String[] preValues =  testData.get(aKey);				//包含隐藏表单的Key数组
				String[] values = new String[preValues.length-1];	//去掉隐藏表单的Key数组
				for(int i = 0;i < values.length; i++) {
					values[i] = preValues[i + 1];
				}
				permissions =  new ArrayList<Mapping_Manager_Permission>();
				for(String aValue : values) {
					
					Mapping_Manager_Permission aPermission
					= new Mapping_Manager_Permission();
					aPermission.setPermission(aValue);
					aPermission.setManagerID(Integer.valueOf(m.group(1))); //将ID绑定到权限映射中
					permissions.add(aPermission);
				}
				//步骤4.3：将管理员和权限添加到Map
				mapManagers.put(manager, permissions);
			}
		} 
		catch (Exception e) {

			System.out.println("权限修改，请求数据封装异常");
			e.printStackTrace();
			return null;
		}
		
		return mapManagers;
	}
}
