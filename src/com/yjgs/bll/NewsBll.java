package com.yjgs.bll;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import com.yjgs.bll.ibll.ILoadNewsInfoBll;
import com.yjgs.dal.NewsDal;
import com.yjgs.dal.NewsTypeDal;
import com.yjgs.dcl.News;
import com.yjgs.dcl.NewsPicture;
import com.yjgs.dcl.NewsType;

public class NewsBll implements ILoadNewsInfoBll {

	// 添加新闻信息
	public boolean addNews(News fNews) {

		NewsDal newsDal = new NewsDal();

		return newsDal.addNews(fNews);
	}

	@Override
	public ArrayList<News> LoadNewsInfo(News fNews) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<NewsPicture> LoadNewsPic(News fNews) {
		// TODO Auto-generated method stub
		return null;
	}

	// 加载新闻具体信息
	public void LoadNewsInfo(int fNewsID, JspWriter fout) {

		NewsBll newsBll = new NewsBll();
		News news = new News();
		News lastNews = new News();
		News afterNews = new News();

		news.setNewsID(fNewsID);
		try {
			// 获取新闻具体信息动态数组
			news = newsBll.loadNewsInfo(news);

			// 加载数据
			fout.print(String.format("<h4 class='newsTitleforh4'>新闻标题：%s</h4>",
					news.getTitle()));
			fout.println(String.format(
					"<h4 class='newsTimeforh4'>发布时间：%s</h4>",
					news.getPublishTime()));
			NewsTypeDal newsTypeDal = new NewsTypeDal();
			NewsType newsType = new NewsType();
			newsType.setTypeID(news.getTypeID());
			newsType = newsTypeDal.getNewsType(newsType);
			lastNews = getLastNews(fNewsID);
			afterNews = getAfterNews(fNewsID);
			fout.println(String.format(
					"<h4 class='newsTypeforh4'>新闻类型：%s</h4>",
					newsType.getTypeName()));
			fout.println(String.format(
					"<p class='newsContent'>新闻正文：</p><p>%s</p>",
					news.getContent()));
			fout.println("<div class='links'>");
			if (lastNews != null) {
				fout.println(String
						.format("<a class='nextNews' href='ShowNews.jsp?newsID=%d'>下一篇：%s</a><br />",
								lastNews.getNewsID(), lastNews.getTitle()));
			}
			if (afterNews != null) {
				fout.println(String
						.format("<a class='lastNews' href='ShowNews.jsp?newsID=%d'>上一篇：%s</a>",
								afterNews.getNewsID(), afterNews.getTitle()));
			}
			fout.println("</div>");
		} catch (Exception e) {

			System.out.print("加载新闻信息失败！");
			e.printStackTrace();
		}

	}

	// 获取上一条新闻
	public News getLastNews(int fNewsID) {

		ArrayList<Integer> iDList = new ArrayList<Integer>();
		iDList = getNewsIDList();

		if (iDList.size() != 0) {

			if (fNewsID == iDList.get(0)) {
				return null;
			}

			for (int i = 1; i < iDList.size(); i++) {
				if (fNewsID == iDList.get(i)) {
					NewsBll newsBll = new NewsBll();
					News news = new News();
					news.setNewsID(iDList.get(i - 1));
					return newsBll.loadNewsInfo(news);
				}
			}
		}
		return null;
	}

	// 获取上一条新闻
	public News getAfterNews(int fNewsID) {

		ArrayList<Integer> iDList = new ArrayList<Integer>();
		iDList = getNewsIDList();

		if (iDList.size() != 0) {

			if (fNewsID == iDList.get(iDList.size() - 1)) {
				return null;
			}

			for (int i = 1; i < iDList.size(); i++) {
				if (fNewsID == iDList.get(i)) {
					NewsBll newsBll = new NewsBll();
					News news = new News();
					news.setNewsID(iDList.get(i + 1));
					return newsBll.loadNewsInfo(news);
				}
			}
		}
		return null;
	}

	// 复制图片
	public static void Copy(String oldPath, String newPath, String webPath) {
		try {
			int bytesum = 0;
			int byteread = 0;
			oldPath = oldPath.substring(2); // 删除“..”
			newPath = newPath.substring(2);
			File oldfile = new File(webPath + oldPath); // 构建路径
			if (oldfile.exists()) { // 若图片存在，复制图片到新目录
				InputStream inStream = new FileInputStream(webPath + oldPath);
				FileOutputStream fs = new FileOutputStream(webPath + newPath);
				byte[] buffer = new byte[1444];
				int length;
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread;
					System.out.println(bytesum);
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
			}
		} catch (Exception e) {
			System.out.println("error ");
			e.printStackTrace();
		}
	}

	// 更新图片替换后的新闻内容
	// public boolean UpdateText(News fNews){
	//
	// NewsDal nDal = new NewsDal();
	//
	// return nDal.UpdateText(fNews);
	// }

	// 加载具体新闻信息
	public News loadNewsInfo(News fNews) {

		NewsDal nDal = new NewsDal();

		return nDal.LoadNewsInfo(fNews);
	}

	// 删除缓存图片
	public void DeletePic(String oldPath, String webPath) {

		oldPath = oldPath.substring(2); // 删除“..”

		File oldfile = new File(webPath + oldPath); // 构建路径，若存在便删除数据
		System.out.println(webPath + oldPath);
		if (oldfile.exists() && oldfile.isFile()) {
			oldfile.delete();
		} else {
			System.out.println("路径不存在！");
		}
	}

	public void DeleteSPic(String oldPath, String webPath) {

		oldPath = oldPath.substring(2); // 删除“..”
		// String[] pathsStrings = oldPath.split("/");
		// oldPath=pathsStrings[1]+"\\"+pathsStrings[2];
		File oldfile = new File(webPath + oldPath); // 构建路径，若存在便删除数据
		System.out.println(webPath + oldPath);
		System.out.println(oldPath);
		if (oldfile.exists()) {
			oldfile.delete();
		} else {
			System.out.println("路径不存在！");
		}
	}

	// 加载更新新闻内容
	public void LoadUpdateNews(JspWriter fout, int fID) {

		News news = new News();
		NewsDal newsDal = new NewsDal();
		NewsTypeBll newsTypeBll = new NewsTypeBll();

		// 填充数据
		news.setNewsID(fID);
		try {

			// 获取相应新闻类别新闻
			news = newsDal.LoadNewsInfo(news);

			// 加载新闻信息
			fout.print("<form action='UpdateNewsSel' method='post'>");
			fout.print(String.format(
					"<input type='hidden' name='NewsID' value=%d>",
					news.getNewsID()));
			fout.print(String
					.format("<div class='newsTitle'><span>新闻标题：</span><input type='NewsTitle' value=%s name='NewsTitle'></div>",
							news.getTitle()));
			fout.print("<div class='newsType'><span>新闻类型：</span>");
			newsTypeBll.loadNewsType(fout);
			fout.print("</div>");
			fout.print(String
					.format("<div class='newsContent'><span class='newsContentspan'>新闻内容：</span><textarea name='Text'>%s</textarea></div>",
							news.getContent(), news.getContent()));
			// System.out.println(news.getContent());
			// fout.print("<script type='text/javascript'> var editor = CKEDITOR.replace('Context');</script>");
			fout.print("<input class='typeAddBtn' type='submit' value='提交' />");
			fout.print("</form>");

			// fout.print("<form action='deleteNewsSel' method='post'>");
			// fout.print(String.format("<input type='hidden' value=%d name='deleteNewsID'>",news.getNewsID()
			// ));
			// fout.print("<input type='submit' value='删除' />");
			// fout.print("</form>");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.print("数据加载失败!");
		}
	}

	// 更新新闻信息
	public boolean UpdateNews(News fNews) {

		NewsDal newsDal = new NewsDal();

		return newsDal.updateNews(fNews);
	}

	// 删除新闻
	public boolean DeleteNews(News fNews) {

		NewsDal newsDal = new NewsDal();

		return newsDal.deleteNews(fNews);
	}

	// 管理界面根据新闻类型查看相应系列的新闻
	public void LoadNews(JspWriter fout) {

		NewsDal newsDal = new NewsDal();
		NewsTypeBll newsTypeBll = new NewsTypeBll();
		try {
			newsTypeBll.loadManagerNewsType(fout);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	// 管理界面根据新闻类型查看相应系列的新闻
	public void LoadNewsType(JspWriter fout) {

		NewsDal newsDal = new NewsDal();
		NewsTypeBll newsTypeBll = new NewsTypeBll();
		try {
			fout.print("新闻类型：");
			newsTypeBll.loadManagerNewsType(fout);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	/**
	 * 获取总页数
	 * 
	 * @param fTypeID
	 *            类别ID
	 * @return 返回总页数
	 */
	public int getPageNum(int fTypeID) {

		int pageSize = 8;
		int NewsNum = 0;
		int pageNum = 1;

		NewsDal nDal = new NewsDal();
		News news = new News();
		news.setTypeID(fTypeID);
		ArrayList<News> news2 = nDal.getAllNews(news);
		ArrayList<News> allNews = nDal.getNewsIDList();
		if (news2.size() == 0) {
			NewsNum = allNews.size();
		} else {
			NewsNum = news2.size();
		}

		// 步骤3：计算总页数
		if (NewsNum != 0) {
			pageNum = (NewsNum - 1) / pageSize + 1;
		}

		return pageNum;
	}

	/**
	 * 加载指定类别，指定页数的新闻列表
	 * 
	 * @param fOut
	 *            Jsp输出对象
	 * @param fTypeID
	 *            类型ID
	 * @param fPage
	 *            页码
	 */
	public void loadProductList(JspWriter fOut, int fTypeID, int fPage) {

		NewsDal nDal = null;
		News news = null;
		ArrayList<News> newsList = new ArrayList<News>();

		try {
			nDal = new NewsDal();
			news = new News();
			news.setTypeID(fTypeID);
			newsList = nDal.getList(news, fPage);
			if (newsList == null) {
				fOut.print("<p style='text-align:center;'>此新闻类别暂无新闻！</p>");
			} else {
				fOut.println("<table class='tb'>");
				fOut.print("<thead><tr><th class='newsTitle'>新闻标题（点击查看详细信息）</th><th class='publishTime'>发布时间</th><th class='delete'>删除</th></tr></thead>");
				for (News aNews : newsList) {
					fOut.println(String
							.format("<tr><td><a href='UpdateNews.jsp?newsID=%d'>%s</a></td><td>%s</td><td><input class='deletebtn' type='button' value='删除' onclick='deleteNews(%d);' /></td></tr>",
									aNews.getNewsID(), aNews.getTitle(),
									aNews.getPublishTime(), aNews.getNewsID()));

				}
				fOut.println("</table>");
			}
		} catch (Exception e) {

			System.out.println("加载新闻列表异常");
			e.printStackTrace();
			return;
		}
	}

	/**
	 * 加载页码列表
	 * 
	 * @param fOut
	 *            JSP输出对象
	 * @param fTypeID
	 *            类别ID
	 * @param fPage
	 *            页码
	 */
	public void loadPageLinks(JspWriter fOut, int fTypeID, int fPage) {

		int pageNum = 1;
		int startPage = 0;
		int endPage = 0;
		int pageLinksNum = 5; // 一组页码列表的个数

		try {

			// 步骤2：计算总页数
			pageNum = getPageNum(fTypeID);

			// 步骤3：计算页码列表的开始项和结尾项
			startPage = ((fPage - 1) / pageLinksNum) * pageLinksNum;
			if (startPage == 0)
				startPage = 1;
			endPage = startPage + pageLinksNum;
			if (endPage > pageNum)
				endPage = pageNum;

			// 步骤4：输出页码列表

			// 输出“上一页”
			if (fPage > 1) {

				fOut.println(String
						.format("<a href='ManagerNews.jsp?typeID=%d&page=%d' class='upPage'>上一页 </a> ",
								fTypeID, fPage - 1));
			}

			// 输出页码列表
			for (int i = startPage; i <= endPage; i++) {

				fOut.println(String.format(
						"<a href='ManagerNews.jsp?typeID=%d&page=%d'>%d</a> ",
						fTypeID, i, i));
				System.out.println(fTypeID);
			}

			// 输出“下一页”
			if (fPage < pageNum) {

				fOut.println(String
						.format("<a href='ManagerNews.jsp?typeID=%d&page=%d' class='downPage'>下一页 </a> ",
								fTypeID, fPage + 1));
			}

		} catch (Exception e) {

			System.out.println("加载页码列表异常");
			e.printStackTrace();
			return;
		}

	}

	public void loadPageLink(JspWriter fOut, int fTypeID, int fPage) {

		int pageNum = 1;
		int startPage = 0;
		int endPage = 0;
		int pageLinksNum = 5; // 一组页码列表的个数

		try {

			// 步骤2：计算总页数
			pageNum = getPageNum(fTypeID);

			// 步骤3：计算页码列表的开始项和结尾项
			startPage = ((fPage - 1) / pageLinksNum) * pageLinksNum;
			if (startPage == 0)
				startPage = 1;
			endPage = startPage + pageLinksNum;
			if (endPage > pageNum)
				endPage = pageNum;

			// 步骤4：输出页码列表

			// 输出“上一页”
			if (fPage > 1) {

				fOut.println(String
						.format("<a href='ShowTypeNews.jsp?typeID=%d&page=%d' class='upPage'>上一页 </a> ",
								fTypeID, fPage - 1));
			}

			// 输出页码列表
			for (int i = startPage; i <= endPage; i++) {

				fOut.println(String.format(
						"<a href='ShowTypeNews.jsp?typeID=%d&page=%d'>%d</a> ",
						fTypeID, i, i));
				System.out.println(fTypeID);
			}

			// 输出“下一页”
			if (fPage < pageNum) {

				fOut.println(String
						.format("<a href='ShowTypeNews.jsp?typeID=%d&page=%d' class='downPage'>下一页 </a> ",
								fTypeID, fPage + 1));
			}

		} catch (Exception e) {

			System.out.println("加载页码列表异常");
			e.printStackTrace();
			return;
		}

	}

	/**
	 * 加载页码选择下拉框
	 * 
	 * @param fOut
	 *            JSP输出对象
	 * @param fPageNum
	 *            总页数
	 */
	public void loadPageOption(JspWriter fOut, int fPageNum) {

		try {

			for (int i = 1; i <= fPageNum; i++) {

				fOut.println(String.format("<option value=%d >%d</option>", i,
						i));
			}

		} catch (Exception e) {

			System.out.println("加载页码下拉框异常");
			e.printStackTrace();
			return;
		}
	}

	// 获取新闻所有ID
	public ArrayList<Integer> getNewsIDList() {

		NewsDal newsDal = new NewsDal();

		ArrayList<News> newsList = new ArrayList<News>();
		newsList = newsDal.getNewsIDList();

		ArrayList<Integer> strings = new ArrayList<Integer>();
		for (int i = 0; i < newsList.size(); i++) {

			strings.add(newsList.get(i).getNewsID());
		}

		return strings;
	}

	public void NewsTypeLoad(JspWriter fOut, HttpServletRequest fRequest) {

		NewsTypeDal tnDal = new NewsTypeDal();

		ArrayList<NewsType> types = new ArrayList<NewsType>();

		int typeID = 0;

		try {

			// 步骤1：获取所有的类别

			types = tnDal.getAllNewsType();

			// 步骤2：获取当前类别ID
			if (fRequest.getParameter("typeID") != null) {

				typeID = Integer.valueOf(fRequest.getParameter("typeID"));
			}

			// 步骤3：输出下拉框表单
			fOut.println("<option value=0>所有类别</option>");
			for (NewsType aType : types) {

				fOut.println(String.format("<option value=%d %s>%s</option>",
						aType.getTypeID(),
						aType.getTypeID() == typeID ? "selected='selected'"
								: "", aType.getTypeName()));
			}

		} catch (Exception e) {

			System.out.println("业务逻辑层：加载类别选择异常");
			e.printStackTrace();
			return;
		}
	}
}
