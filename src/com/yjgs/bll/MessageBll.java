package com.yjgs.bll;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;

import com.yjgs.dal.AdviceDal;
import com.yjgs.dal.ComplaintDal;
import com.yjgs.dal.PermissionApplyDal;
import com.yjgs.dcl.Complaint;
import com.yjgs.dcl.Permission;
import com.yjgs.dcl.PermissionApply;
import com.yjgs.enumdata.ManagerLevel;

public class MessageBll {

	
	/**
	 * 加载超级管理员的消息 （未处理的申诉以及申请）
	 * 
	 * @param fOut	JSP输出对象
	 */
	public void loadSuperManagerMess(JspWriter fOut,HttpServletRequest fRequest) {
		
		PermissionApplyDal paDal = null;
		ComplaintDal cpDal = null;
		ArrayList<PermissionApply> applies = null;
		ArrayList<Complaint> complaints = null;
		
		try {
			
			//步骤1：判断用户是否为超级管理员
			HttpSession session =  fRequest.getSession();
			if(((ManagerLevel)session.getAttribute("UserLevel")).equals(ManagerLevel.COMMON)) {
				
				return;
			}
			
			//步骤1：获取数据
			paDal = new PermissionApplyDal();
			cpDal = new ComplaintDal();
			
			applies = paDal.getNoReadApplies();
			complaints = cpDal.getAllNoPassComplaints();
			
			//步骤2：判断是否有申请
			fOut.println("<div><h2>权限申请消息：</h2>");
			if(applies == null) {
				
				fOut.println("<p>暂时没有新的权限申请！</p>");
			}
			else {
				
				fOut.println(String.format("<p>还有<span>%d</span>个未处理的权限申请，"
						+ "<a href='../PermissionManage/ApplyDeal.jsp'>立即查看</a></p></div>", applies.size()));
			}
			
			//步骤3：判断是否有申诉
			fOut.println("<div><h2>账号申诉消息：</h2>");
			if(complaints == null) {
				
				fOut.println("<p>暂时没有新的账号申诉！</p>");
			}
			else {
				
				fOut.println(String.format("<p>还有<span>%d</span>个未处理的账号申诉，"
						+ "<a href='../ManagerComplaint/NewsRemind.jsp'>立即查看</a></p></div>", complaints.size()));
			}
			
		} catch (Exception e) {

			System.out.println("加载超级管理员消息异常");
			e.printStackTrace();
			return;
		}
	}
	
	/**
	 * 加载建议反馈消息
	 * 
	 * @param fOut		JSP输出对象
	 */
	public void loadAdviceMess(JspWriter fOut) {
		
		AdviceDal aDal = null;
		int advicesNum = 0;
		
		try {
			
			//步骤1：获取未回复的建议反馈数量
			aDal = new AdviceDal();
			advicesNum = aDal.getNum(false);
			
			//步骤2：判断是否输出提醒
			fOut.println("<div class='bottomDiv'><h2>建议反馈消息：</h2>");
			if(advicesNum == 0) {
				
				fOut.println("<p>暂时没有建议反馈！</p>");
			}
			else {
				
				fOut.println(String.format("<p>还有<span>%d</span>个未回复的建议反馈"
						+ "，<a href='../AdviceManage/ManageAdvice.jsp' >立即查看</a></p></div>", advicesNum));
			}
			
			
		} catch (Exception e) {

			System.out.println("加载建议反馈消息异常");
			e.printStackTrace();
			return;
		}
	}
	
	public void loadMessageLink(JspWriter fOut,HttpServletRequest fRequest) {
		
		PermissionApplyDal paDal = null;
		ComplaintDal cpDal = null;
		AdviceDal aDal = null;
		ArrayList<PermissionApply> applies = null;
		ArrayList<Complaint> complaints = null;
		int advicesNum = 0;
		
		boolean isRemind = false;	//是否提醒
		boolean isSupper = false; 	//是否是超级管理员
		
		try {
			
			//步骤1：获取Session判断用户等级以及是否具有建议管理权限
			HttpSession session = fRequest.getSession(true);
			if(((ManagerLevel)session.getAttribute("UserLevel")).equals(ManagerLevel.SUPER)) {
				
				isSupper = true;
			}
			
			//检查普通用户是否具有建议管理的权限
			if(!isSupper) {
				
				@SuppressWarnings("unchecked")
				Map<Permission, Boolean> permissionStatus 
				= (Map<Permission, Boolean>) session.getAttribute("Permission");
				Set<Permission> keySet =  permissionStatus.keySet();
				Permission[] keys =  keySet.toArray(new Permission[keySet.size()]);
				
				for(Permission aKey : keys) {
					
					if(aKey.getContent().equals("反馈管理")) {
						
						if(!permissionStatus.get(aKey)) return;
					}
				}
			}
			
			//步骤2：获取后台数据，判断是否具有新的消息
			paDal = new PermissionApplyDal();
			cpDal = new ComplaintDal();
			aDal = new AdviceDal();
			
			applies = paDal.getNoReadApplies();
			complaints = cpDal.getAllNoPassComplaints();
			advicesNum = aDal.getNum(false);
			
			if(isSupper) {
				
				if(applies != null || complaints != null || advicesNum != 0) {
					
					isRemind = true;
				}
			}
			else {
				
				if(advicesNum != 0) {
					
					isRemind = true;
				}
			}
			
			//步骤3：根据以上判断，输出提醒消息以及链接
			if(isRemind) {
				
				fOut.println("<a class='hasNews' href='../Message/MessageReminding.jsp' >您有新消息</a>");
			}
			else {
				
				fOut.println("<a class='noNews' href='../Message/MessageReminding.jsp' >消息</a>");
			}
				
			
		} catch (Exception e) {
			
			System.out.println("加载消息链接异常");
			e.printStackTrace();
			return;
		}
		
	}
}
