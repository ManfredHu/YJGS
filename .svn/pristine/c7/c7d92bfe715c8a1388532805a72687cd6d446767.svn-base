package com.yjgs.bll;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

import jdk.internal.org.objectweb.asm.commons.AdviceAdapter;

import com.yjgs.dal.AdviceDal;
import com.yjgs.dal.ProductListDal;
import com.yjgs.dcl.Advice;
import com.yjgs.dcl.ProductList;

public class AdviceBll {
	
	public void loadAdvice(){
		
		
	}

	/**
	 * 加载产品列表
	 * 
	 * @param fOut			JSP输出对象
	 * @param fRequest		Servlet请求
	 */
	public void loadAdviceList(JspWriter fOut,HttpServletRequest fRequest) {
		
		AdviceDal pListDal = null;
		Advice advice = null;
		ArrayList<Advice> Advices = null;
		int page = 1;
		
		
		try {
		
			advice = new Advice();
			Advices = new ArrayList<Advice>();
			if(fRequest.getParameter("page") != null) {
				
				page = Integer.valueOf(fRequest.getParameter("page"));
			}
			
			Advices = pListDal.getAllAdvices(page);
			
			fOut.println("<table>");
			if(Advices.size()==0){
				fOut.print("暂无建议反馈内容！");
			}
			for(Advice aAdvice : Advices) {
				
				//步骤3.1：输出行头
				fOut.println("<tr>");
				
				//步骤3.2：输出各数据
				fOut.println(String.format("<td>建议人：%s</td><td>%s</td>", aAdvice.getUserMail(),aAdvice.getAdviceTime()));
				fOut.println(String.format("<td>建议内容：%s</td>",aAdvice.getContent()));
				fOut.println(String.format("<td>管理员回复：%s</td>",aAdvice.getReply()));
				fOut.println("</tr>");
				
			}
			fOut.println("<table>");
			
		} catch (Exception e) {

			System.out.println("业务逻辑层：建议反馈加载异常");
			e.printStackTrace();
			return;
		}		
	}
	
	/**
	 * 加载页码
	 * 
	 * @param fOut			JSP输出对象
	 * @param fRequest		Servlet请求
	 */
	public void loadPageLinks(JspWriter fOut,HttpServletRequest fRequest) {
		
		int typeID = 0;
		int page = 1;
		int pageNum = 1;
		int startPage = 0;
		int endPage = 0;
		int pageLinksNum =5;  //一组页码列表的个数
		
		try {
			
			//步骤1：获取typeID以及page
//			if (fRequest.getParameter("typeID") != null) {
//
//				typeID =  Integer.valueOf(fRequest.getParameter("typeID"));
//			}

			if (fRequest.getParameter("page") != null) {

				page = Integer.valueOf(fRequest.getParameter("page"));
			}
			
			//步骤2：计算总页数
			pageNum = getPageNum();

			//步骤3：计算页码列表的开始项和结尾项
			startPage = ((page -1)/pageLinksNum) * pageLinksNum;
			if(startPage == 0) startPage = 1;
			endPage = startPage + pageLinksNum;			
			if(endPage > pageNum) endPage = pageNum;
			
			//步骤4：输出页码列表
			
			//输出“上一页”
			if(page > 1) {
				
				fOut.println(String.format("<a href='LoadAdvice.jsp?page=%d' class='upPage'>上一页 </a> "
						,page - 1));
			}
			
			//输出页码列表
			for(int i = startPage; i <= endPage; i++) {
				
				fOut.println(String.format("<a href='LoadAdvice.jsp?page=%d'>%d</a> "
						,i,i));
			}
			
			//输出“下一页”
			if(page < pageNum) {
				
				fOut.println(String.format("<a href='LoadAdvice.jsp?page=%d' class='downPage'>下一页 </a> "
						,page + 1));
			}
			
		} catch (Exception e) {

			System.out.println("业务逻辑层：页码列表加载异常");
			e.printStackTrace();
			return;
		}
	}
	
	public void loadManPageLinks(JspWriter fOut,HttpServletRequest fRequest) {
		
		int typeID = 0;
		int page = 1;
		int pageNum = 1;
		int startPage = 0;
		int endPage = 0;
		int pageLinksNum =5;  //一组页码列表的个数
		
		try {
			
			//步骤1：获取typeID以及page
//			if (fRequest.getParameter("typeID") != null) {
//
//				typeID =  Integer.valueOf(fRequest.getParameter("typeID"));
//			}

			if (fRequest.getParameter("page") != null) {

				page = Integer.valueOf(fRequest.getParameter("page"));
			}
			
			//步骤2：计算总页数
			pageNum = getPageNum();

			//步骤3：计算页码列表的开始项和结尾项
			startPage = ((page -1)/pageLinksNum) * pageLinksNum;
			if(startPage == 0) startPage = 1;
			endPage = startPage + pageLinksNum;			
			if(endPage > pageNum) endPage = pageNum;
			
			//步骤4：输出页码列表
			
			//输出“上一页”
			if(page > 1) {
				
				fOut.println(String.format("<a href='ManageAdvice.jsp?page=%d'  class='upPage'>上一页 </a> "
						,page - 1));
			}
			
			//输出页码列表
			for(int i = startPage; i <= endPage; i++) {
				
				fOut.println(String.format("<a href='ManageAdvice.jsp?page=%d'>%d</a> "
						,i,i));
			}
			
			//输出“下一页”
			if(page < pageNum) {
				
				fOut.println(String.format("<a href='ManageAdvice.jsp?page=%d' class='downPage'>下一页 </a> "
						,page + 1));
			}
			
		} catch (Exception e) {

			System.out.println("业务逻辑层：页码列表加载异常");
			e.printStackTrace();
			return;
		}
	}
	
	/**
	 * 获取总页数
	 * 
	 * @param fTypeID		类别ID
	 * @return					总页数
	 */
	public int getPageNum() {
		
		int pageSize = 5;
		int AdviceNum = 0;
		int pageNum = 1;
		
		AdviceDal pDal = new AdviceDal();
		Advice Advice = new Advice();
		//Advice.setAdviceTypeID(fTypeID);
		ArrayList<Advice> Advices = pDal.getPageSum();
		if (Advices == null)
			AdviceNum = 0;
		else
			AdviceNum = Advices.size();
		
		//int AdviceSum = pDal.getManagePageSum();	
		//步骤3：计算总页数
		if(AdviceNum != 0) {
			pageNum = (AdviceNum - 1)/pageSize +1;
		}
		
		return pageNum;
	}
	
	/**
	 * 加载页码列表
	 * 
	 * @param fOut			JSP输出对象
	 * @param fTypeID		类别ID
	 * @param fPage			页码
	 */
	public void loadPageLinks(JspWriter fOut,int fPage) {
		
		int pageNum = 1;
		int startPage = 0;
		int endPage = 0;
		int pageLinksNum =5;  //一组页码列表的个数
		
		try {
			
			//步骤2：计算总页数
			pageNum = getPageNum();

			//步骤3：计算页码列表的开始项和结尾项
			startPage = ((fPage -1)/pageLinksNum) * pageLinksNum;
			if(startPage == 0) startPage = 1;
			endPage = startPage + pageLinksNum;
			if(endPage > pageNum) endPage = pageNum;
			
			//步骤4：输出页码列表
			
			//输出“上一页”
			if(fPage > 1) {
				
				fOut.println(String.format("<a href='LoadAdvice.jsp?page=%d'>上一页 </a> "
						,fPage - 1));
			}
			
			//输出页码列表
			for(int i = startPage; i <= endPage; i++) {
				
				fOut.println(String.format("<a href='LoadAdvice.jsp?page=%d'>%d </a> "
						,i,i));
			}
			
			//输出“下一页”
			if(fPage < pageNum) {
				
				fOut.println(String.format("<a href='LoadAdvice.jsp?page=%d'>下一页 </a> "
						,fPage + 1));
			}
			
		} catch (Exception e) {

			System.out.println("加载页码列表异常");
			e.printStackTrace();
			return;
		}
		
	}
	
	/**
	 * 加载指定页数的建议反馈列表
	 * 
	 * @param fOut			Jsp输出对象
	 * @param fTypeID		类型ID
	 * @param fPage			页码
	 */
	public void loadProductList(JspWriter fOut,int fPage) {
		
		AdviceDal pListDal = null;
		Advice advice = null;
		ArrayList<Advice> Advices = null;
		
		try {
			
			//步骤1：实例化DAL并获取相应数据
			pListDal = new AdviceDal();
			advice = new Advice();
			Advices = new ArrayList<Advice>();
			//product.setProductTypeID(fTypeID);
			//products = pListDal.getList_fs(product, fPage);
			Advices = pListDal.getManAdvices(fPage);
			
			if(Advices==null){
				fOut.println("<p style='padding:20px;'>暂无建议反馈内容！</p>");
				return;
			}
			
			//步骤2：遍历产品数据集合并输出
			fOut.print("<table class='tb'><thead><tr><th>留言者</th><th class='time'>日期</th><th>问题</th><th class='toreply'>回复</th><th class='delete'>删除</th></thead><tbody>");
			for(Advice aAdvice : Advices) {
				
				//步骤3.1：输出行头
				fOut.println("<tr>");
				
				//步骤3.2：输出各数据
				fOut.println(String.format("<td class='adviser'>%s</td><td class='time'>%s</td>", aAdvice.getUserMail(),aAdvice.getAdviceTime()));
				fOut.println(String.format("<td class='content'>%s</td>",aAdvice.getContent()));
				fOut.println(String.format("<td class='toreply'><a href='UpdateAdvice.jsp?id=%d'>回复</a></td>", aAdvice.getAdviceID()));
				fOut.println(String.format("<td class='delete'><a href='deleteAdvice?id=%d'>删除</a></td>",aAdvice.getAdviceID()));
				fOut.println("</tr>");
			}
			fOut.print("</tbody></table>");
			
		} catch (Exception e) {
			
			System.out.println("加载建议反馈列表异常");
			e.printStackTrace();
			return;
		}
	}
	
	/**
	 * 加载指定页数的建议反馈列表
	 * 
	 * @param fOut			Jsp输出对象
	 * @param fTypeID		类型ID
	 * @param fPage			页码
	 */
	public void loadAdvicesList(JspWriter fOut,int fPage) {
		
		AdviceDal pListDal = null;
		Advice advice = null;
		ArrayList<Advice> Advices = null;
		
		try {
			
			//步骤1：实例化DAL并获取相应数据
			pListDal = new AdviceDal();
			advice = new Advice();
			Advices = new ArrayList<Advice>();
			//product.setProductTypeID(fTypeID);
			//products = pListDal.getList_fs(product, fPage);
			Advices = pListDal.getAllAdvices(fPage);
			
			if(Advices==null){
				fOut.println("<p style='text-align:center;'>暂无建议反馈内容！</p>");
				return;
			}
			fOut.println("<div class='adviseList'>");
			//步骤2：遍历产品数据集合并输出
			for(Advice aAdvice : Advices) {
				
				//步骤3.1：输出行头
				fOut.println("<div class='oneAdvise'>");
				
				//步骤3.2：输出各数据
				fOut.println(String.format("<span class='person'>网友邮箱：%s</span><span class='time'>发表时间：%s</span>", aAdvice.getUserMail(),aAdvice.getAdviceTime()));
				fOut.println(String.format("<p>反馈内容：%s</p>",aAdvice.getContent()));
				fOut.println(String.format("<p class='adminReply'>管理员回复：%s</p>",aAdvice.getReply()));
				fOut.println("</div>");
			}
			fOut.println("</div>");
		} catch (Exception e) {
			
			System.out.println("加载建议反馈列表异常");
			e.printStackTrace();
			return;
		}
	}
	
	/**
	 * 加载页码选择下拉框
	 * 
	 * @param fOut				JSP输出对象
	 * @param fPageNum		总页数
	 */
	public void loadPageOption(JspWriter fOut , int fPageNum) {
		
		try {
			
			for(int i = 1; i<= fPageNum; i++) {
				
				fOut.println(String.format("<option value=%d >%d</option>", i,i));
			}
			
		} catch (Exception e) {
			
			System.out.println("加载页码下拉框异常");
			e.printStackTrace();
			return;
		}
	}
	
	//更新回复后的建议反馈
	public boolean changeRead(Advice fAdvice){
		AdviceDal adviceDal = new AdviceDal();
		
		return adviceDal.updateAdvice(fAdvice);
	}
	
	//获取有id的建议反馈
	public Advice getAdvices(Advice fAdvice){
		AdviceDal adviceDal = new AdviceDal();
		
		return adviceDal.getAdvices(fAdvice);
	}
	
	//加载管理建议反馈页面
	public void loadManAdvice(int AdviceID,JspWriter fout){
		
		Advice advice = new Advice();
		advice.setAdviceID(AdviceID);
		
		AdviceDal adviceDal = new AdviceDal();
		try {
			advice = adviceDal.getAdvices(advice);
			
			fout.println("<form class='updateForm' action='UpdateAdviceSel' method='post' >");
			fout.println(String.format("<div><span class='up-account'>申述账号：</span><span>%s</span></div>",advice.getUserMail()));
			fout.println(String.format("<div><span class='up-time'>申述时间：</span><span>%s</span></div>",advice.getAdviceTime()));
			fout.println(String.format("<div><span class='up-content'>申述内容：</span><p>%s</p></div>",advice.getContent()));
			fout.println("<div><span class='up-apply'>回复：</span><textarea name='text'></textarea></div>");
			fout.println("<input class='save' type='submit' value='提交' />");
			fout.println(String.format("<input type='hidden' name='email' value=%s>",advice.getUserMail()));
			fout.println(String.format("<input type='hidden' name='Adviceid' value=%d>",advice.getAdviceID()));
			
			fout.println("</form>");
		} catch (Exception e) {
			System.out.println("加载申述内容出错！");
			e.printStackTrace();
		}
	}
	
	//删除建议反馈
	public boolean deleteAdvice(Advice fAdvice){
		
		AdviceDal adviceDal = new AdviceDal();
		
		return adviceDal.deleteAdvice(fAdvice);
	}
}
