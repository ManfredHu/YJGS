package com.yjgs.bll;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

import com.sun.media.jfxmedia.control.VideoDataBuffer;
import com.sun.org.apache.regexp.internal.recompile;
import com.yjgs.dal.ComplaintDal;
import com.yjgs.dcl.Complaint;
import com.yjgs.dcl.Manager;

public class ComplaintBll {

	//增加申诉
	public boolean addComplaint(Complaint fComplaint){
		
		ComplaintDal cDal = new ComplaintDal();
		
		boolean result = cDal.addComplaint(fComplaint);
		
		return result;
	}
	
	//加载未处理的申述
	public void loadComplaint(JspWriter fout){
		
		ComplaintDal cDal = new ComplaintDal();
		ArrayList<Complaint> complaints = new ArrayList<Complaint>();
		ManagerBll mBll = new ManagerBll();
		Manager manager = new Manager();
		
		try {
			
			complaints=cDal.getNoPassComplaint();
			
			if(complaints==null){
				fout.println("暂无申述！");
				return;
			}
			else{
				fout.println("<h3 class='s'>未处理的申述</h3>");
				fout.println("<table>");
				for(int t=0;t<complaints.size();t++){
					
					try{
						manager=mBll.getManagerByAcco(complaints.get(t));
						if(manager==null){
							fout.println("暂无申述！");
							return;
						}
					}
					catch(Exception e){
						e.printStackTrace();
					}
					
					fout.println(String.format("<tr><td><a href='ManagerComplaint.jsp?Id=%d&ManaName=%s&UserID=%d'>来自%s的申述</a></td></tr>",
							complaints.get(t).getComplaintID(),
							manager.getManagerName(),
							manager.getManagerID(),
							manager.getManagerName()
							));
				}
				fout.println("</table>");
			}
		} catch (Exception e) {

			System.out.print("加载为处理申诉信息出错！");
			e.printStackTrace();
		}
	}
	
	///加载具体申述内容
	public void loadComplaint(int fUserID,int fComplaintID,String fManagerName,JspWriter fout,HttpServletRequest frequest,HttpServletResponse fResponse){
		try {
			frequest.setCharacterEncoding("UTF-8");
			fResponse.setContentType("text/html; charset=UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}

		ComplaintDal cDal = new ComplaintDal();
		Complaint complaint = new Complaint();
		complaint.setComplaintID(fComplaintID);
		
		try {
			
			complaint=cDal.getComplaint(complaint);
			System.out.print(fManagerName);
			if(complaint!=null){
				fout.println("<div>");
				fout.println(String.format("<div style='margin-bottom:20px;'>来自 <span class='name'>%s</span>的申述</div>", fManagerName));
				fout.println(String.format("<div style='margin-bottom:20px;'>申述内容：<p style='text-indent:2em'>%s</p></div>", complaint.getConplaintReason()));
				fout.println(String.format("<div style='margin-bottom:20px;'>申述邮箱：<p style='text-indent:2em'>%s</p></div>", complaint.getEmail()));
				fout.println("</div>");
				fout.println("<form action='dealComplaintSel' method='post'>");
				
				fout.println(String.format("<input type='hidden' name='UserID' value=%d>", fUserID));
				fout.println(String.format("<input type='hidden' name='email' value=%s>", complaint.getEmail()));
				fout.println(String.format("<input type='hidden' name='ComplaintID' value=%d>", complaint.getComplaintID()));
				fout.println(String.format("<input type='hidden' name='ManagerName' value=%s>", fManagerName));
				fout.println(String.format("<input type='hidden' name='cid' value=%d>", complaint.getComplaintID()));
				fout.println("<input class='btnp' type='submit' value='一键还原密码和删除密码问题' />");
				fout.println("</form>");
			}
		} catch (Exception e) {

			System.out.println("加载具体申述信息出错！");
			e.printStackTrace();
		}
	}
	
	//更改通过状态
	public boolean UpdatePass(Complaint fComplaint){
		
		ComplaintDal cDal = new ComplaintDal();
		
		return cDal.updateComplaint(fComplaint);
	}
	
	//获取申述
	public Complaint getComplaint(Complaint fComplaint){
		
		ComplaintDal cDal = new ComplaintDal();
		
		return cDal.getComplaint(fComplaint);
	}
}
