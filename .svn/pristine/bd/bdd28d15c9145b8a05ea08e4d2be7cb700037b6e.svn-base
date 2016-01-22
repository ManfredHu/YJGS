package com.yjgs.bll;

import java.util.ArrayList;

import javax.servlet.jsp.JspWriter;

import com.yjgs.dal.CompanyInfoDal;
import com.yjgs.dcl.CompanyInfo;
import com.yjgs.enumdata.CompanyInfoType;

public class CompanyInfoManagerBll {
	
	//加载管理企业信息页面
	public void loadManagerCompanyInfo(JspWriter fout){
		
		CompanyInfoDal typeDal = new CompanyInfoDal();;
		CompanyInfo companyInfo = new CompanyInfo();
		CompanyInfo companyInfo2 = new CompanyInfo();
		CompanyInfoType type = null;
		
		companyInfo.setInfoType(type.INTRODUCE);
		
		try {
			companyInfo2=typeDal.getAInfo(companyInfo);
			if(companyInfo2!=null){
				fout.println("<form action='UpdateCompanyInfoSel' method='post'>");
				fout.println(String.format("<h3 class='forh3'>企业信息修改</h3><textarea name='text'>%s</textarea>", companyInfo2.getInfoContent()));
				fout.println(String.format("<input type='hidden' name='id' value=%s>", companyInfo2.getInfoID()));
				fout.println("<input class='nextBtn' type='submit' value='修改' />");
				fout.println("</form>");
			}
			if(companyInfo2==null){
				fout.println("暂无企业信息，请添加。");
				fout.println("<form action='InsertCompanyInfoSel' method='post'>");
				fout.println("<h3 class='forh3'>企业信息修改</h3><textarea name='text'></textarea>");
				fout.println("<input class='nextBtn' type='submit' value='添加' />");
				fout.println("</form>");
			}
		} catch (Exception e) {
			
			System.out.print("加载企业信息失败！");
			e.printStackTrace();
		}
		
	}
	
	//加载首页产品信息
	public void loadCompanyInfo(JspWriter fout){
		
		CompanyInfoDal typeDal = new CompanyInfoDal();;
		CompanyInfo companyInfo = new CompanyInfo();
		CompanyInfo companyInfo2 = new CompanyInfo();
		CompanyInfoType type = null;
		
		companyInfo.setInfoType(type.INTRODUCE);
		
		try {
			companyInfo2=typeDal.getAInfo(companyInfo);
			
			if(companyInfo2!=null){
			fout.println(String.format("<div class='companyInfo'>%s</div>", companyInfo2.getInfoContent()));
			}
			if(companyInfo2==null){
				fout.println("暂无企业信息！");
			}
		} catch (Exception e) {
			
			System.out.print("加载企业信息失败！");
			e.printStackTrace();
		}
	}
	
	//修改企业信息
	public boolean UpdateText(CompanyInfo fCompanyInfo){
		
		CompanyInfoDal companyInfoDal = new CompanyInfoDal();
		
		return companyInfoDal.updateInfo(fCompanyInfo);
	}
	
	//增加信息
	public boolean AddText(CompanyInfo fCompanyInfo){
		
		CompanyInfoDal companyInfoDal = new CompanyInfoDal();
		
		return companyInfoDal.addInfo(fCompanyInfo);
	}
	
	//加载联系方式
	public void loadRelation(JspWriter fout){
		
		CompanyInfoDal companyInfoDal = new CompanyInfoDal();
		CompanyInfo companyInfo = new CompanyInfo();
		CompanyInfoType type = null;
		companyInfo.setInfoType(type.CONTACTS);
		ArrayList<CompanyInfo> companyInfos = new ArrayList<CompanyInfo>();
		try {
			companyInfos=companyInfoDal.getAllInfo(companyInfo);
			
			if(companyInfos!=null){
				fout.println("<h3>企业联系方式：</h3>");
				fout.println("<table>");
				fout.println("<form action='UpdateRelationSel' method='post'>");
			for(int t=0;t<companyInfos.size();t++){
				String[] part=companyInfos.get(t).getInfoContent().split(":");
				
				fout.println(String.format("<tr><td><input type='text' name='content1' value=%s /></td><td>:</td><td><input type='text' name='content2' value=%s /></td></tr>", part[0],part[1]));
				fout.println(String.format("<input type='hidden' name='id' value=%d>", companyInfos.get(t).getInfoID()));
			}
				fout.println("<input type='submit' value='提交' />");
				fout.println("</form>");
				fout.println("</table>");
			}
		} catch (Exception e) {
			
			System.out.println("加载联系方式失败！");
			e.printStackTrace();
		}
	}
	
	//加载企业联系方式在插件ckeditor里
	public void loadManagerRelation(JspWriter fout){
		
		CompanyInfoDal companyInfoDal = new CompanyInfoDal();
		CompanyInfo companyInfo = new CompanyInfo();
		CompanyInfoType type = null;
		companyInfo.setInfoType(type.CONTACTS);
		CompanyInfo companyInfos = new CompanyInfo();
		try {
			companyInfos=companyInfoDal.getAInfo(companyInfo);
			
			if(companyInfos!=null){
				fout.println("<form action='UpdateRelationSel' method='post'>");
				fout.println(String.format("<h3 class='forh3'>修改企业联系方式</h3><textarea name='text'>%s</textarea>", companyInfos.getInfoContent()));
				fout.println(String.format("<input type='hidden' name='id' value=%d>", companyInfos.getInfoID()));
				fout.println("<input class='nextBtn' type='submit' value='提交' />");
				fout.println("</form>");
			}
			
			else{
				fout.println("暂无企业联系方式，请添加。");
				fout.println("<form action='InsertCompanyRelationSel' method='post'>");
				fout.println("<h3 class='forh3'>修改企业联系方式</h3><textarea name='text'></textarea>");
				fout.println("<input class='nextBtn' type='submit' value='添加' />");
				fout.println("</form>");
			}
		} catch (Exception e) {
			
			System.out.println("加载联系方式失败！");
			e.printStackTrace();
		}
	}
	
	//加载企业联系方式
	public void loadRelationContent(JspWriter fout){
		
		CompanyInfoDal companyInfoDal = new CompanyInfoDal();
		CompanyInfo companyInfo = new CompanyInfo();
		CompanyInfoType type = null;
		companyInfo.setInfoType(type.CONTACTS);
		CompanyInfo companyInfos = new CompanyInfo();
		try {
			companyInfos=companyInfoDal.getAInfo(companyInfo);
			if(companyInfos.getInfoContent()==""){
				fout.println("<p>暂无企业联系方式！</p>");
			}
			fout.println("<div class='centerfor'>");
			fout.println(String.format("<h2>企业联系方式:</h2><div class='contactContent'>%s</div>", companyInfos.getInfoContent()));
			fout.println("</div>");
		}
		catch(Exception e){
			System.out.print("加载企业联系方式失败！");
			e.printStackTrace();
		}
	}
	
	//修改申述内容
	public void UpdateRecruitment(JspWriter fout){
		
		CompanyInfoDal companyInfoDal = new CompanyInfoDal();
		CompanyInfo companyInfo = new CompanyInfo();
		CompanyInfoType type = null;
		companyInfo.setInfoType(type.RECRUITMENT);
		CompanyInfo companyInfos = new CompanyInfo();
		try {
			companyInfos=companyInfoDal.getAInfo(companyInfo);
			
			if(companyInfos!=null){
				fout.println("<form action='UpdateRecruitmentSel' method='post'>");
				fout.println(String.format("<h3 class='forh3'>企业招聘信息</h3><textarea name='text'>%s</textarea>", companyInfos.getInfoContent()));
				fout.println(String.format("<input type='hidden' name='id' value=%d>", companyInfos.getInfoID()));
				fout.println("<input  class='nextBtn' type='submit' value='提交' />");
				fout.println("</form>");
			}
			else{
				fout.println("暂无企业招聘信息，请添加。");
				fout.println("<form action='InsertCompanyRecruitmentSel' method='post'>");
				fout.println("<h3 class='forh3'>企业招聘信息</h3><textarea name='text'></textarea>");
				fout.println("<input class='nextBtn' type='submit' value='添加' />");
				fout.println("</form>");
			}
		} catch (Exception e) {
			
			System.out.println("加载联系方式失败！");
			e.printStackTrace();
		}
	}
	
	//加载企业招聘信息
	public void loadRecruitment(JspWriter fout){
		
		CompanyInfoDal companyInfoDal = new CompanyInfoDal();
		CompanyInfo companyInfo = new CompanyInfo();
		CompanyInfoType type = null;
		companyInfo.setInfoType(type.RECRUITMENT);
		CompanyInfo companyInfos = new CompanyInfo();
		try {
			companyInfos=companyInfoDal.getAInfo(companyInfo);
			if(companyInfos.getInfoContent()==""){
				fout.print("暂无企业招聘信息！");
			}
			else
			fout.println(String.format("<h2>企业招聘信息:</h2>%s", companyInfos.getInfoContent()));
		}
		catch(Exception e){
			System.out.print("加载企业招聘信息失败！");
			e.printStackTrace();
		}
	}
	
	//获取企业信息内容
	public CompanyInfo getConpanyInfo(CompanyInfo fCompanyInfo){
		
		CompanyInfoDal cDal = new CompanyInfoDal();
		
		return cDal.getInfo(fCompanyInfo);
	}
	
	//插入企业信息
	public Boolean insertCompanyInfo(CompanyInfo fCompanyInfo){
		
		CompanyInfoDal cDal = new CompanyInfoDal();
		
		return cDal.addInfo(fCompanyInfo);
	}
}
