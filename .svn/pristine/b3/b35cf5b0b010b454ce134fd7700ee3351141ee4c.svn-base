package com.yjgs.fittler;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.yjgs.dcl.Permission;
import com.yjgs.enumdata.ManagerLevel;

/**
 * Servlet Filter implementation class PermissionCheck
 */
public class PermissionCheck implements Filter {

    /**
     * Default constructor. 
     */
    public PermissionCheck() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpSession session = null;
		HttpServletRequest httpRequest = null;
		boolean isPass = false;
		
		//步骤1：获取HttpRequest对象
		httpRequest = (HttpServletRequest)request;
		
		//步骤2：获取session
		session = httpRequest.getSession(true);
		
		//步骤3：进行实际的权限判断
		isPass = check(httpRequest,session);
		
		//步骤4：根据判断处理是否放行或跳转到错误页面
		if(isPass) {
			
			chain.doFilter(request, response);
			return;
		}
		else {
			
			request.setAttribute("judge", "false");
			request.setAttribute("text", "对不起，您没有相应访问权限");
			request.setAttribute("URL", "../welcome/adminIndex.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
			return;
			
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	@SuppressWarnings("unchecked")
	private boolean check(HttpServletRequest fRequest,HttpSession fSession) {
		
		
		Map<Permission, Boolean> permissionStatus = null;
		ManagerLevel managerLevel = null;
		String folderName = null;
		String servletPath = null;
		
		try {
			
			//步骤1：获取管理员等级,超级管理员则无需检测
			managerLevel = (ManagerLevel) fSession.getAttribute("UserLevel");
			if(managerLevel.equals(ManagerLevel.SUPER)) {
				
				return true;
			}
			
			//步骤2：获取当前访问的路径并提取一级文件夹名
			servletPath = fRequest.getServletPath();
			
			Pattern p = Pattern.compile("/(\\S+?)/\\S+");
			Matcher m = p.matcher(servletPath);
			if(!m.find()) return false;
			folderName = m.group(1);
			
			//步骤3：获取管理员权限状态
			permissionStatus = (Map<Permission, Boolean>) fSession.getAttribute("Permission");
			Set<Permission> keySet =  permissionStatus.keySet();
			Permission[] keys =  keySet.toArray(new Permission[keySet.size()]);
			
			
			//步骤3：根据提取出来的文件夹名，匹配相应类别权限并检测是否拥有
			
			//检测权限管理（普通管理员无此功能访问权限）
			if(folderName.equals("PermissionManage")) {
				
				return false;
			}
			
			//检测产品管理权限
			if(folderName.equals("ProductManage")) {
				
				for(Permission aKey : keys) {
					
					if(aKey.getContent().equals("产品管理")) {
						
						return permissionStatus.get(aKey);
					}
				}
			}
			
			//检测新闻管理权限
			if(folderName.equals("NewsManage")) {
				
				for(Permission aKey : keys) {
					
					if(aKey.getContent().equals("新闻管理")) {
						
						return permissionStatus.get(aKey);
					}
				}
			}
			
			//检测反馈管理权限
			if(folderName.equals("AdviceManage")) {
				
				for(Permission aKey : keys) {
					
					if(aKey.getContent().equals("反馈管理")) {
						
						return permissionStatus.get(aKey);
					}
				}
			}
			
			//拥有反馈管理的一般管理员才可以查看消息
			if (folderName.equals("Message")) {

				for (Permission aKey : keys) {

					if (aKey.getContent().equals("反馈管理")) {

						return permissionStatus.get(aKey);
					}
				}
			}
			
			
			//检测企业信息管理权限
			if(folderName.equals("InfoManage")) {
				
				for(Permission aKey : keys) {
					
					if(aKey.getContent().equals("企业信息管理")) {
						
						return permissionStatus.get(aKey);
					}
				}
			}
			
			//检测功能管理权限
			if(folderName.equals("FunctionManage")) {
				
				for(Permission aKey : keys) {
					
					if(aKey.getContent().equals("功能管理")) {
						
						return permissionStatus.get(aKey);
					}
				}
			}
			
			//检测首页管理权限
			if(folderName.equals("FirstPageManage")) {
				
				for(Permission aKey : keys) {
					
					if(aKey.getContent().equals("首页管理")) {
						
						return permissionStatus.get(aKey);
					}
				}
			}
			
		} 
		catch (Exception e) {

			System.out.println("权限检测异常");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

}
