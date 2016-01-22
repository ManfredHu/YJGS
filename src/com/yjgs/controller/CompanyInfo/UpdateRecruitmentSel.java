package com.yjgs.controller.CompanyInfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yjgs.bll.CompanyInfoManagerBll;
import com.yjgs.bll.NewsBll;
import com.yjgs.dcl.CompanyInfo;

/**
 * Servlet implementation class UpdateRecruitmentSel
 */
public class UpdateRecruitmentSel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRecruitmentSel() {
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
		
		String text  = request.getParameter("text");
		int ID = Integer.parseInt(request.getParameter("id"));
		
		if(text==""||ID==0){
			request.setAttribute("judge", "false");
			request.setAttribute("text", "招聘信息不能为空！");
			request.setAttribute("URL", "UpdateRecruitment.jsp");
			request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
			return;
		}
		
		String newTextString=ChangeText(text,request);
		CompanyInfo companyInfo = new CompanyInfo();
		companyInfo.setInfoContent(newTextString);
		companyInfo.setInfoID(ID);
	
		CompanyInfo companyInfo2 = new CompanyInfo();
		
		CompanyInfoManagerBll companyInfoBll = new CompanyInfoManagerBll();
		companyInfo2 = companyInfoBll.getConpanyInfo(companyInfo);
		try {
			
			if (companyInfoBll.UpdateText(companyInfo)) {
				
				System.out.println("成功!");
				
				try {
					matchPath(text,request);			//复制图片
				} catch (Exception e) {
					System.out.println("复制图片出错！");
					e.printStackTrace();
				}
				
				try {
					deleteSPicture(text,request);		//删除缓存文件夹文件
				} catch (Exception e) {
					System.out.println("删除缓存文件夹文件出错！");
					e.printStackTrace();
				}
				
				try {
					deletePicture(newTextString,companyInfo.getInfoContent(),request);
				} catch (Exception e) {
					System.out.println("删除原数据文件出错！");
					e.printStackTrace();
				}
				
				request.setAttribute("judge", "true");
				request.setAttribute("text", "修改企业信息成功！");
				request.setAttribute("URL", "UpdateRecruitment.jsp");
				request.getRequestDispatcher("../Master/handlePage.jsp").forward(request, response);
				return;
			}
		} catch (Exception e) {
			
			System.out.print("修改企业信息失败！");
			e.printStackTrace();
		}
	}
	
			//复制图片
			public void matchPath(String Text,HttpServletRequest request){

				
				String str = "src=\".*?.[a-z]{3}\"";

		        String newPath = null;
		        String oldPath = null;
		  
		        Pattern p = Pattern.compile(str);
		        Matcher m = p.matcher(Text);
		        
		        while(m.find()){
			        System.out.println(m.group(0));
			        String[] strs = m.group(0).split("\"");
			        String pathstr[] = strs[1].split("/");
			        if(pathstr.length>=4){
			        newPath="../RecruitmentPicture/"+pathstr[3];
			        oldPath="../"+pathstr[1]+"/"+pathstr[2]+"/"+pathstr[3];
			        System.out.println(newPath);
			        System.out.println(pathstr[3]);
			        NewsBll newsBll = new NewsBll();
			        newsBll.Copy(oldPath,newPath,request.getSession().getServletContext().getRealPath("/"));
					}
		       }
			}
			
			//改变图片地址
			public String ChangeText(String Text,HttpServletRequest request){
				
				HttpSession session = request.getSession();
				int userID = (int)session.getAttribute("UserID");
				
				String regex = "PicCache/" + userID;
				Pattern pat = Pattern.compile(regex);  
				Matcher matcher = pat.matcher(Text);     
				 if (matcher.find()) { 
					   String temp = Text.substring(matcher.start(),matcher.end());
					   Text = Text.replaceAll(temp, temp.substring(0,temp.lastIndexOf(regex))+"RecruitmentPicture");
			}
				 return Text;
			}
			
			//删除缓存文件夹的图片
			public void deleteSPicture(String Text,HttpServletRequest request){
	
		        String str = "src=\".*?.[a-z]{3}\"";
		        
			    Pattern p = Pattern.compile(str);
			    Matcher m = p.matcher(Text);
			    while(m.find()){
				    System.out.println(m.group(0));
				    
				    String[] strs = m.group(0).split("\"");
					String pathstr[] = strs[1].split("/");
					if(pathstr.length>=4){
				    System.out.println(strs[1]);
				    NewsBll newsBll = new NewsBll();
				    newsBll.DeletePic(strs[1],request.getSession().getServletContext().getRealPath("/"));
				}
			}
		
	}
	
	//删除原有数据
	public Void deletePicture(String Text,String SText,HttpServletRequest request){
		    	
				
				String str ="src=\".*?.[a-z]{3}\"";
			    Pattern p = Pattern.compile(str);
			    Matcher m = p.matcher(Text);
			    
			    String Sstr ="src=\".*?.[a-z]{3}\"";
			    Pattern Sp = Pattern.compile(Sstr);
			    Matcher Sm = Sp.matcher(SText);
			    
			    NewsBll newsBll = new NewsBll();
			    ArrayList<String> rePics = new ArrayList<String>();
			    ArrayList<String> Pics = new ArrayList<String>();
			
			    while(m.find()){
			    
			    		String[] strs = m.group(0).split("\"");
						//String pathstr[] = strs[1].split("/");
			    		rePics.add(strs[1]);		    		
			    		System.out.println(strs[1]);
			    }
			    
			    while(Sm.find()){
			    	
			    		String[] strs = Sm.group(0).split("\"");
						//String pathstr[] = strs[1].split("/");
			    		Pics.add(strs[1]);
			    		System.out.println(strs[1]);
			    	
			    }
			    
			    
			    try {
			    	for(String aString : rePics){
			    		Pics.remove(aString);}
			    	
			    	if(Pics.size()!=0){
			    		for(int q=0;q<Pics.size();q++){
			    			System.out.println(Pics.get(q));
			    			newsBll.DeleteSPic(Pics.get(q),request.getSession().getServletContext().getRealPath("/"));
			    	}
			    		}
			    } catch (Exception e) {
					System.out.print("删除原始图片失败！");
					e.printStackTrace();
				}
			   
			    return null;
		    }
	

}
